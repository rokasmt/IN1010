public class Lege{

    protected String navn;

    public Lege(String navn){
        this.navn = navn;
    }
    public String hentNavn(){
        return navn;
    }
    public Resept skrivResept( Legemiddel legemiddel, int pasientID, int reit) throws UlovligUtskrift {
        if (!(legemiddel instanceof PreparatC) && (!(this instanceof Spesialist))) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            return new Militearresept(legemiddel, this, pasientID, reit);
        }
    }
    @Override
    public String toString(){
        return navn;
    }
}
