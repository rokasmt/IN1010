import java.util.concurrent.locks.*;
import java.util.*;

public class Monitor {

  Lock lock = new ReentrantLock();
  Condition ikkeTom = lock.newCondition();
  LinkedList<Melding> meldinger = new LinkedList<Melding>();

  public void leggTilMelding(Melding melding) {
    lock.lock();
    try {
      meldinger.add(melding);
      ikkeTom.signalAll();
    }
    catch (Exception e) {
      System.out.println("Uforventet feil.");
    }
    finally{
      lock.unlock();
    }
  }

  public Melding hentDekryptert() {
    lock.lock();
    try {
      while(meldinger.size() <= 0 && Kryptograf.antallAktKrypto > 0) {
        ikkeTom.await();
      }
      return meldinger.poll();
    }
    catch(InterruptedException e) {
      System.out.println("Uforventet feil.");
    }
    finally {
      lock.unlock();
    }
    return null;
  }
}
