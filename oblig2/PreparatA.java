public class PreparatA extends Legemiddel{

    private int styrke;

    public PreparatA(String navn, double pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;

    }
    public int hentVanedannendeStyrke(){
        return styrke;
    }
    @Override
    public String toString(){
        return " Narkotisk " + super.toString() + " Styrke: " + styrke;
    }

}
