import java.util.ArrayList;


public abstract class Rute{
  public int rad;
  public int kolonne;
  public Labyrint labyrint;

  public Rute ost;
  public Rute syd;
  public Rute vest;
  public Rute nord;

  Rute(Labyrint labyrint, int rad, int kolonne){
    this.labyrint = labyrint;
    this.rad = rad;
    this.kolonne = kolonne;
  }
  public abstract String tilTegn();

  abstract void gaa(String vei, Rute komFra);

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

  @Override
  public String toString() {
    return "(" + kolonne + ", " + rad + ")";
  }
}
