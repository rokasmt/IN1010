class Hovedprogram {
  public static void main(String[] args) {

    int antTelegrafister = 3;
    int antKryptografer = 100;

    Operasjonssentral ops = new Operasjonssentral(antTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();
    KryptertMonitor kryptert = new KryptertMonitor();
    DekryptertMonitor dekryptert = new DekryptertMonitor();

    for (int i = 0; i < antTelegrafister; i++) {
      Telegrafist t = new Telegrafist(kryptert, kanaler[i]);
      Thread thread = new Thread(t);
      thread.start();
    }

    for (int i = 0; i < antKryptografer; i++) {
      Kryptograf k = new Kryptograf(kryptert, dekryptert);
      Thread thread = new Thread(k);
      thread.start();
    }
    Operasjonsleder o = new Operasjonsleder(dekryptert);
    Thread thread = new Thread(o);
    thread.start();
  }

}
