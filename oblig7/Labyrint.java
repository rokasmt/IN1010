import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Labyrint{
  public Rute[][] labyrint;
  public int antallRader;
  public int antallKolonner;
  public Lenkeliste<String> veienUt;
  public int rad;
  public int kolonne;

  public Labyrint(Rute[][] labyrint, int antallRader, int antallKolonner){
    this.labyrint = labyrint;
    this.antallRader = antallRader;
    this.antallKolonner = antallKolonner;
    veienUt = new Lenkeliste<>();
  }

  static Labyrint lesFraFil(File filnavn) throws FileNotFoundException {
      Scanner sc = new Scanner(filnavn);
      String linje = sc.nextLine();
      String[] size = linje.split(" ");
      int rad = Integer.parseInt(size[0]);
      int kolonne = Integer.parseInt(size[1]);
      Rute[][] labyrint = new Rute[rad][kolonne];
      Labyrint labyrint1 = new Labyrint(labyrint, rad, kolonne);

      for (int i = 0; i < rad; i++){
        char[] tegn = sc.nextLine().toCharArray();

        for (int kol = 0; kol < kolonne; kol++){
          labyrint[i][kol] = Rute.lagRute(tegn[kol], labyrint1, i, kol);
        }
      }

      for (int i = 0; i < rad; i++){
        for (int kol = 0; kol < kolonne; kol++){
          //System.out.println("Legger til naboer til (" + kol + ", " + i + ").");
          if(kol > 0) {
            //System.out.println("i = " + i + ", kol = " + kol);
            //System.out.println("Legger til " + labyrint[i][kol-1] + " i vest.");
            labyrint[i][kol].vest = labyrint[i][kol-1];
          }
          if (kol < kolonne - 1) {
            //System.out.println("i = " + i + ", kol = " + kol);
            //System.out.println("Legger til " + labyrint[i][kol+1] + " i ost.");
            labyrint[i][kol].ost = labyrint[i][kol+1];
          }
          if (i > 0) {
            //System.out.println("i = " + i + ", kol = " + kol);
            //System.out.println("Legger til " + labyrint[i-1][kol] + " i nord.");
            labyrint[i][kol].nord = labyrint[i-1][kol];
          }
          if (i < rad - 1) {
            //System.out.println("i = " + i + ", kol = " + kol);
            //System.out.println("Legger til " + labyrint[i+1][kol] + " i syd.");
            labyrint[i][kol].syd = labyrint[i+1][kol];
          }
        }
      }

    //System.out.println(labyrint1);

      return labyrint1;
    }



    Lenkeliste<String> finnUtveiFra(int kolonne, int rad){
      veienUt = new Lenkeliste<>();
      //System.out.println("Finner utvei fra: " + kolonne + ", " + rad + ".");
      labyrint[rad][kolonne].finnUtVei();
      return veienUt;

    }
    public Rute[][] hentLabyrint(){
      return labyrint;
    }
    public int hentRader(){
      return antallRader;
    }
    public int hentKolonner(){
      return antallKolonner;
    }
    @Override
    public String toString(){
      String s = "";
      for(Rute[] rad:labyrint){
        for(Rute rute:rad){
          s += rute.tilTegn();
        }
        s += "\n";
      }
      return s;
    }

  public Lenkeliste<String> hentVeienUt() { return veienUt; }
}
