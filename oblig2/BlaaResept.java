public class BlaaResept extends Resept {

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
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
