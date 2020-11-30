import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.Integer;

class Regneklynge {

    int noderPerRack;

    ArrayList <Rack> listRack = new ArrayList <Rack> ();

    public Regneklynge(String filnavn) {
        Scanner sc = null;
        try {
            File fil = new File(filnavn);
            sc = new Scanner(fil);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        noderPerRack = sc.nextInt();
        //System.out.println("Noder per rack: " + noderPerRack);

        listRack.add(new Rack(noderPerRack));

        while(sc.hasNextLine()) {
            sc.nextLine();

            int antNoder = sc.nextInt();
            int minne = sc.nextInt();
            int antPros = sc.nextInt();

            for(int i = 0; i < antNoder; i++) {
                settInnNode(minne, antPros);
            }
        }
        sc.close();
    }

    public void settInnNode(int minne, int antPros) {
        if (listRack.get(listRack.size() - 1).erFull()) {
            listRack.add(new Rack(noderPerRack));
            //System.out.println("Setter inn ny rack med maxNoder " + noderPerRack);
        }
        listRack.get(listRack.size() - 1).settInn(minne, antPros);
    }


    public int antProsessorer() {
        int antProsessorer = 0;

        for (Rack rack: listRack) {
            antProsessorer += rack.antProsessorer();
        }
        return antProsessorer;
    }

    public int noderMedNokMinne(int paakrevdMinne) {
        int noderNokMinne = 0;

        for (Rack rack: listRack) {
          noderNokMinne += rack.noderMedNokMinneRack(paakrevdMinne);
        }
        return noderNokMinne;
    }

    public int antRacks(){
        return listRack.size();
    }
}
