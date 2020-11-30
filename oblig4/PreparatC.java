public class PreparatC extends Legemiddel{

    public PreparatC(String navn, double pris, double virkestoff){
        super(navn, pris, virkestoff);

    }
    @Override
    public String toString(){
        return "Vanlig " + super.toString();
    }

}
