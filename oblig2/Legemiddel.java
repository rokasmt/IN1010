public abstract class Legemiddel{
    protected String navn;
    protected double pris;
    protected double virkestoff;
    static int idTeller = 0;
    protected int id;

    public Legemiddel(String navn, double pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;

        id = idTeller;
        idTeller++;
    }
    public int hentId(){
        return id;
    }
    public String hentNavn(){
        return navn;
    }
    public double hentPris(){
        return pris;
    }
    public double hentVirkestoff(){
        return virkestoff;
    }
    public void settNyPris(double nyPris){
        pris = nyPris;
    }
    @Override
    public String toString() {
    return " legemiddel " + id + " " +  navn + " Pris: " + pris + " " +
     " Virkestoff: " + virkestoff;
  }
}
