public class Militearresept extends HvitResept {

    public Militearresept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
    }
    public double prisAaBetale(){
        return 0;
    }
}
