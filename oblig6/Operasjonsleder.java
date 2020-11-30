import java.io.*;
import java.util.*;

class Operasjonsleder implements Runnable {
  private LinkedList<Melding> meldinger = new LinkedList<Melding>();
  DekryptertMonitor dekryptert;
  PrintWriter skriver;

  public Operasjonsleder (DekryptertMonitor dekryptert) {
    this.dekryptert = dekryptert;
  }

  public void run() {
    Melding tempMelding = dekryptert.hentDekryptert();
    while (tempMelding != null) {
      meldinger.add(tempMelding);
      tempMelding = dekryptert.hentDekryptert();
    }
    Collections.sort(meldinger);
    skrivTilFil();
  }

  public void skrivTilFil() {
    String filnavn;
    for (int i = 1; i < 4; i++) {
      filnavn = "kanal" + i + ".txt"; //filnavn blir kanalID og txt som type

      try {
        skriver = new PrintWriter(filnavn, "utf-8");
      }
      catch (FileNotFoundException e) {}
      catch (UnsupportedEncodingException e) {}

      skriver.println("Kanal " + i);
      for (Melding melding : meldinger) {
        if (melding.hentKanalID() == i) {
          skriver.println(""); 
          skriver.println("");
          skriver.println(melding.hentMelding());
        }
      }
      skriver.close();
    }

  }
}
