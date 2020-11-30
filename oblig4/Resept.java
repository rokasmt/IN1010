public abstract class Resept {

    private int id;
    protected Legemiddel legemiddel;
    private Lege utskrivendeLege;
    private int pasientId;
    private int reit;
    static int idTeller = 0;


    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasient.hentId();
        this.reit = reit;
        id = idTeller;
        idTeller++;
    }

    public int hentId() {
        return id;
    }
    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }
    public Lege hentLege() {
        return utskrivendeLege;
    }
    public int hentPasientId() {
        return pasientId;
    }
    public int hentReit() {
        return reit;
    }
    public boolean erBrukt() {
        if (reit > 0) {
            reit--;
            return true;
        } else {
            return false;
        }
    }
    public boolean erNarkotisk(){
        return (legemiddel instanceof PreparatA);
    }
    abstract public String farge ();
    abstract public double prisAaBetale ();

    @Override
    public String toString () {
        return "" + id + "" + " Legemiddel: " + legemiddel
                + " Utskrivende lege: " + utskrivendeLege + " Pasient id: "
                + pasientId + " Reit: " + reit;
    }
    public void skrivInfo(){
        System.out.println("Resept-Id: " + id);
        System.out.println("Type: vanlig");
        System.out.println("Legemiddel: " + legemiddel.hentNavn());
        System.out.println("Reit: " + reit);
    }
}
