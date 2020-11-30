public class BlaaResept extends Resept {

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
      super(legemiddel, utskrivendeLege, pasient, reit);
  }

  @Override
  public String farge(){
    return "blaa";
  }

  @Override
  public double prisAaBetale(){
      return legemiddel.hentPris()*0.25;
  }

  @Override
  public String toString(){
    return "Blaa resept " + super.toString();
  }
}
