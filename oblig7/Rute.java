import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

public abstract class Rute extends StackPane {
  public int rad;
  public int kolonne;
  public Labyrint labyrint;
  Rectangle firkant;

  public Rute ost;
  public Rute syd;
  public Rute vest;
  public Rute nord;

  char merke = ' ';
  public boolean harUtvei;
  public int antBesok=0;
  public SortertLenkeliste<String> utveiListe = new SortertLenkeliste<String>();

  Rute(Labyrint labyrint, int rad, int kolonne){
    firkant = new Rectangle(30, 30);
    firkant.setStroke(Color.BLACK);
    getChildren().add(firkant);
    firkant.setOnMouseClicked(e -> finnLosning());
    this.labyrint = labyrint;
    this.rad = rad;
    this.kolonne = kolonne;
    //setFont(new Font(0));
    //setPrefSize(10, 10);
    //setStyle("-fx-background-color: #FFFFFF");
  }

  private void finnLosning() {
    System.out.println("finnLosning() ble trykket.");
    this.finnUtVei();
    System.out.println(labyrint.hentVeienUt());
    boolean[][] utvei = Gui.losningStringTilTabell(labyrint.hentVeienUt().hent(0), labyrint.hentKolonner(), labyrint.hentRader());

    for (int i = 0; i < utvei.length; i++) {
      for (int j = 0; j < utvei[0].length; j++) {
        System.out.print(utvei[i][j]);
      }
      System.out.println();
    }

    for (int i = 0; i < utvei.length; i++) {
      for (int j = 0; j < utvei[0].length; j++) {
        if (utvei[i][j]) {
          System.out.println("Setter rute til grønn");
          labyrint.hentLabyrint()[i][j].firkant.setFill(Color.GREEN);
        }
      }
    }
    Gui.tekst.setText("Det finnes " + labyrint.hentVeienUt().stoerrelse() + " løsninger.");
  }

  public abstract String tilTegn();

  abstract void gaa(String vei, Rute komFra);

  public void tomUtvei(){
    utveiListe = new SortertLenkeliste<String>();
  }

  static Rute lagRute(char tegn, Labyrint labyrint, int rad, int kolonne){
    if (tegn == '#') {
      return new SortRute(labyrint, rad, kolonne);
    } else if (tegn == '.') {
        if (rad == 0 || rad == labyrint.antallRader - 1 || kolonne == 0 || kolonne == labyrint.antallKolonner - 1) {
          return new Aapning(labyrint, rad, kolonne);
        } else {
          return new HvitRute(labyrint, rad, kolonne);
        }
    } else {
      throw new RuntimeException("FEIL");
    }
  }

  public void finnUtVei(){
    //System.out.println("Naboer: " + nord + syd + ost + vest);
    if(nord!=null){
      nord.gaa(toString() ,this);
    }
    if (ost != null) {
      ost.gaa(toString(),this);
    }
    if (vest != null) {
      vest.gaa(toString(),this);
    }
    if (syd != null){
      syd.gaa(toString(),this);
    }
  }

  public void besoktTilNull(){
   antBesok = 0;
  }

  public Lenkeliste<String> hentUtveier(){
    for(Rute[] rad:labyrint.hentLabyrint()){
      for(Rute rute: rad){
        rute.besoktTilNull();
      }
    }
    return utveiListe;
  }

  public int hentRad(){
    return rad;
  }

  public int hentKolonner(){
    return kolonne;
  }

  @Override
  public String toString() {
    return "(" + kolonne + ", " + rad + ")";
  }
}
