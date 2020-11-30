public class PResept extends HvitResept{
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }
    public double prisAaBetale(){
        double nypris;

        if(legemiddel.hentPris() < 108){
            return 0;
        } else {
            return legemiddel.hentPris() - 108;
        }
    }
}
