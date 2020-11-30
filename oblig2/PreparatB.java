public class PreparatB extends Legemiddel{

    private int styrke;

    public PreparatB(String navn, double pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke(){
        return styrke;
    }

    @Override
    public String toString(){
        return " Vanedannende " + super.toString() + " Styrke: " + styrke;
    }
}
