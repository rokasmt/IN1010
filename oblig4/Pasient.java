public class Pasient{
    private String navn;
    private String fnr;
    private int pasientId;
    Stabel<Resept> resepter = new Stabel<Resept>();
    static int idTeller = 0;

    public Pasient(String navn, String fnr){
        this.navn = navn;
        this.fnr = fnr;
        this.pasientId = idTeller;
        idTeller++;
        this.resepter = new Stabel<Resept>();
    }
    public String hentNavn(){
        return navn;
    }
    public String hentFnr(){
        return fnr;
    }
    public int hentId(){
        return pasientId;
    }
    public Stabel<Resept> hentReseptListe(){
        return resepter;
    }
    public void leggerResept(Resept resept){
        resepter.leggPaa(resept);
    }
    public int antNarkotisk(){
    int antall = 0;
    for(Resept resept1: resepter){
        if(resept1.erNarkotisk()){
            antall++;
        }
    }
    return antall;
    }
    public void skrivInfoPasient(){
    System.out.println("Navn: " + navn);
    System.out.println("FNR: " + fnr);
    System.out.println("Id: " + pasientId);
    System.out.println("Resepter til pasient:");
    for(Resept resept: resepter){
      resept.skrivInfo();
    }
    }
public String toString() {
    return navn;
}
}
