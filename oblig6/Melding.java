class Melding implements Comparable<Melding>{
  private String melding;
  private int sekvensnummer, kanalID;

  public Melding (String melding, int sekvensnummer, int kanalID) {
    this.melding = melding;
    this.sekvensnummer = sekvensnummer;
    this.kanalID = kanalID;
  }

  public String hentMelding() {
    return melding;
  }

  public int hentSekvensnummer() {
    return sekvensnummer;
  }

  public int hentKanalID() {
    return kanalID;
  }

  public void settNy(String ny) {
    this.melding = ny;
  }

  @Override
  public int compareTo(Melding melding) {
    //if(this.kanalID ==)
    return this.sekvensnummer - melding.sekvensnummer;
  }
}
