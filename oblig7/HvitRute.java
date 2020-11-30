import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class HvitRute extends Rute {
  public HvitRute(Labyrint labyrint, int rad, int kolonne){
    super(labyrint, rad, kolonne);
    firkant.setFill(Color.WHITE);
  }
  @Override
  public void gaa(String vei,Rute komFra){
    vei += "-->" + toString();
    //System.out.println("Går til " + super.toString());
    if (komFra != nord) {
      nord.gaa(vei, this);
    }
    if (komFra != syd) {
      syd.gaa(vei, this);
    }
    if (komFra != ost) {
      ost.gaa(vei, this);
    }
    if (komFra != vest) {
      vest.gaa(vei, this);
    }
  }
  public String tilTegn() {
    return ".";
  }
}
