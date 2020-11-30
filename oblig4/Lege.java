public class Lege implements Comparable<Lege>{

    protected String navn;
    protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

    public Lege(String navn){
        this.navn = navn;
        this.utskrevedeResepter = new Lenkeliste<Resept>();
    }
    public int compareTo(Lege annenLege){
        return navn.compareTo(annenLege.navn);
    }
    public Lenkeliste<Resept> hentUtskrevedeResepter(){
        return utskrevedeResepter;
    }
    public String hentNavn(){
        return this.navn;
    }
    public void leggTilResept(Resept nyResept){
        this.utskrevedeResepter.leggTil(nyResept);
    }
    public int antNarkotisk(){
    int antall = 0;
    for(Resept resept1: utskrevedeResepter){
        if(resept1.erNarkotisk()){
          antall++;
      }
    }
    return antall;
    }
    public void skrivInfoLege(){
    System.out.println("Navn: " + navn);
    System.out.println("");
    System.out.println("Utstedt resepter: ");
    for(Resept resept: utskrevedeResepter){
      resept.skrivInfo();
    }
    }
    @Override
    public String toString(){
        return navn;
    }
}
