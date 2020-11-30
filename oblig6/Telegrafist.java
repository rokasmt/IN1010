class Telegrafist implements Runnable {
  private int kanalID;
  public static int antallAktTele = 0;
  private KryptertMonitor kryptert;
  private Kanal kanal;
  private int sekvens = 0;

  public Telegrafist(KryptertMonitor kryptert, Kanal kanal) {
    this.kanalID = kanal.hentId();
    this.kryptert = kryptert;
    this.kanal = kanal;
  }

  public String lyttBeskjeder() {
    return kanal.lytt();
  }

  @Override
  public void run() {
    antallAktTele++;
    String tempMelding = lyttBeskjeder();

    while (tempMelding != null) {
      System.out.println("Telegraf i kanal: " + kanalID + " henter melding: " + sekvens);
      Melding meldingKrypt = new Melding(tempMelding, sekvens, kanalID);
      kryptert.leggTilMelding(meldingKrypt);
      tempMelding = lyttBeskjeder();
      sekvens++;
    }
    antallAktTele--;

    if (antallAktTele == 0) {
      System.out.println("Telegrafister er ferdige.");
    }
  }
}
