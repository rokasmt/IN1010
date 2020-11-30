public class Militearresept extends HvitResept {

    public Militearresept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }
    public double prisAaBetale(){
        return 0;
    }
}
