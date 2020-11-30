public class Spesialist extends Lege implements Godkjenningsfritak{

    int kontrollID;

    public Spesialist(String navn, int kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;

    }
    @Override
    public String toString(){
        return super.toString();
    }

    public int hentKontrollID() {
        return kontrollID;
    }
}
