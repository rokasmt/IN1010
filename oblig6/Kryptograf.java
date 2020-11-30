class Kryptograf implements Runnable {
  public static int antallAktKrypto = 0;
  private KryptertMonitor kryptert;
  private DekryptertMonitor dekryptert;

  public Kryptograf (KryptertMonitor kryptert, DekryptertMonitor dekryptert) {
    this.kryptert = kryptert;
    this.dekryptert = dekryptert;
  }

  @Override
  public void run() {
    antallAktKrypto++;
    Melding tempMelding = kryptert.hentKryptert();
    while (tempMelding != null) {
      System.out.println("Antall kryptografer: " + antallAktKrypto + " arbeider.");
      String meldKryptert = tempMelding.hentMelding();
      String meldDekryptert = Kryptografi.dekrypter(meldKryptert);
      tempMelding.settNy(meldDekryptert);
      dekryptert.leggTilMelding(tempMelding);
      tempMelding = kryptert.hentKryptert();
    }
    antallAktKrypto--;

    if(antallAktKrypto == 0) {
      System.out.println("Kryptografer er ferdig.");
    }
  }
}
