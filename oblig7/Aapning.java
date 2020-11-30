public class Aapning extends HvitRute{
  public Aapning(Labyrint labyrint, int rad, int kolonne){
    super(labyrint, rad, kolonne);
  }

  public void gaa(String vei, Rute komFra) {
    vei += " --> " + toString();
    //System.out.println("Kommet til aapning!");
    labyrint.veienUt.leggTil(vei);
  }


}
