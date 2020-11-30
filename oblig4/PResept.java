public class PResept extends HvitResept{
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, 3);
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
