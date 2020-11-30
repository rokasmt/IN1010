import java.util.*;
import java.io.*;

class LegeSystem{
    private static Lenkeliste<Pasient> pasientListe = new Lenkeliste<Pasient>();
    private static Lenkeliste<Resept> resepterListe = new Lenkeliste<Resept>();
    private static SortertLenkeliste<Lege> legeListe = new SortertLenkeliste<Lege>();
    private static Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        lesFraFil("inndata.txt");
        menu();
        valg();
    }

    public static void lesFraFil(String filnavn){
        try{
            Scanner fil = new Scanner(new File(filnavn));
            String linje = fil.nextLine();
            linje = fil.nextLine();

            while (linje.charAt(0) != '#'){
                String[] biter = linje.split(", ");
                String navn = biter[0];
                String fnr = biter[1];
                nyPasient(navn,fnr);
                linje = fil.nextLine();
            }
            linje = fil.nextLine();

            while (linje.charAt(0) != '#'){
                String[] biter = linje.split(", ");
                String navn = biter[0];
                String type = biter[1].toUpperCase();
                Double pris = Double.parseDouble(biter[2]);
                Double virkestoff = Double.parseDouble(biter[3]);
                if(type.equals("C")){
                    nyLegemiddel(navn,type,pris,virkestoff,0);
                } else {
                    int styrke = Integer.parseInt(biter[4]);
                    nyLegemiddel(navn,type,pris,virkestoff,styrke);
                }
                linje = fil.nextLine();
            }
            linje = fil.nextLine();

            while (linje.charAt(0) != '#'){
                String[] biter = linje.split(", ");
                String navn = biter[0];
                int kontrollID = Integer.parseInt(biter[1]);
                if(kontrollID == 0){nyLege(navn);}
                else{
                    nySpesialist(navn, kontrollID);
                }
                linje = fil.nextLine();
            }
            linje = fil.nextLine();

            while(fil.hasNextLine()){
                String[] biter = linje.split(", ");

                int legemiddelNummer = Integer.parseInt(biter[0]);
                Legemiddel legemiddel = null;
                for (Legemiddel legemiddel1 : legemiddelListe){
                    if(legemiddel1.hentId() == legemiddelNummer){
                        legemiddel = legemiddel1;
                    }
                }
                String navnLege = biter[1];
                Lege lege = null;
                for(Lege lege1 : legeListe){
                    if(lege1.hentNavn().equals(navnLege)){
                        lege = lege1;
                    }
                }
                int pasientID = Integer.parseInt(biter[2]);
                Pasient pasient = null;
                for(Pasient pasient1 : pasientListe){
                    if(pasient1.hentId() == pasientID){
                        pasient = pasient1;
                    }
                }

                int reit = Integer.parseInt(biter[3]);
                nyResept("Blaa",legemiddel,lege,pasient,reit);

                linje = fil.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
            valg();
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("1: Skrive ut en fullstendig oversikt.");
        System.out.println("2. Opprette ny lege.");
        System.out.println("3. Opprette ny pasient.");
        System.out.println("4. Opprette ny legemiddel.");
        System.out.println("5. Opprette ny resept.");
        System.out.println("6. Bruke den nye resepten.");
        System.out.println("7. Se totalt antall utskrevne resepter pa vanedannende legemidler.");
        System.out.println("8. Se totalt antall utskrevne resepter pa narkotiske legemidler.");
        System.out.println("9. Statistikk om mulig misbruk av narkotika.");
        System.out.println("0. EXIT");
        System.out.print("Skriv inn ditt valg: ");
    }

    public static void valg(){
        int input = Integer.parseInt(scanner.nextLine());
        while(input != 0){

        if (input == 1){
            skrivInfo();
        }

        else if (input == 2) {
            System.out.println("Hva er navnet til lege?: ");
            String navn = scanner.nextLine();

            System.out.println("Er legen spesialist? (Y eller N)");
            String janei = scanner.nextLine();

            if(janei.equals("Y")){
                  System.out.println("KontrollID til legen?");
                  int kontrollID = Integer.parseInt(scanner.nextLine());
                  nySpesialist(navn ,kontrollID);
                  System.out.println("Dr. " + navn + " er tilgjengelig i systemet.");
            } else {
                  nyLege(navn);
                  System.out.println("Dr. " + navn + " er tilgjengelig i systemet.");
            }
        }
        else if (input == 3){
            System.out.println("Hva er navnet til pasient?");
            String pasientNavn = scanner.nextLine();

            System.out.println("Hva er foedselsnummer?");
            String fnr = scanner.nextLine();

            nyPasient(pasientNavn, fnr);
            System.out.println(pasientNavn + " er tilgjengelig i systemet.");
        }
        else if (input == 4){
            System.out.println("Hva er navnet til legemiddel?");
            String navn = scanner.nextLine();

            System.out.println("Hvilken legemiddel?");
            String type = scanner.nextLine();

              System.out.println("Hva er prisen?");

              double pris = 0;
        try{
              pris= Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
              System.out.println("Feil");
              valg();
        }

            double virkestoff = 0;
            System.out.println("Hva er virkestoff: ");
        try{
            virkestoff = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Feil");
            valg();
        }
            int styrke = 0;
            if(type.equals("A")){
              System.out.println("Hva er styrke: ");
        try{
            styrke = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Feil");
            valg();
        }
            }
            else if (type.equals("B")){
                System.out.println("Hva er styrke: ");
            try{
                styrke = Integer.parseInt(scanner.nextLine());
              } catch (NumberFormatException e) {
                System.out.println("Feil");
                valg();
              }
            }
            nyLegemiddel(navn,type,pris,virkestoff,styrke);
        }

            else if (input == 5){
                System.out.println("En liste av legemidlene:");
            for(Legemiddel legemiddel1 : legemiddelListe){
                System.out.println(legemiddel1.hentNavn());
            }
            System.out.println("Skriv navnet paa legemiddelet du vil utstede:");
            String navn = scanner.nextLine();
            Legemiddel legemiddel = null;
            for (Legemiddel legemiddel1 : legemiddelListe){
                if(legemiddel1.hentNavn().equals(navn)){
                  legemiddel = legemiddel1;
                }

            }

            System.out.println("En liste av legene:");
            for(Lege lege1 :legeListe){
                System.out.println(lege1.hentNavn());
            }
            System.out.println("Skriv navnet til utskrivende lege:");
            String Navn = scanner.nextLine();
            Lege lege = null;
            for(Lege lege1 : legeListe){
                if(lege1.hentNavn().equals(Navn)){
                    lege = lege1;
                }
            }
            System.out.println("En liste av pasientene");
            for(Pasient pasient1: pasientListe){
              System.out.println(pasient1.hentNavn() + " foedselsnummer (" + pasient1.hentFnr() + ")");
            }
            System.out.println("Navnet til pasient: ");
            String pasientNavn = scanner.nextLine();
            Pasient pasient = null;
            for(Pasient pasient1: pasientListe){
              if(pasient1.hentNavn().equals(pasientNavn)){
                  pasient = pasient1;
              }
            }
            System.out.println("Velg typen for reseptet");
            System.out.println("Blaaresept");
            System.out.println("Hvitrespt");
            System.out.println("Militearresept");
            System.out.println("Presept");
            String type = scanner.nextLine();

            if(type.equals("P")){
              nyResept(type,legemiddel,lege,pasient,3);
            } else {
              System.out.println("Hva er reit: ");
              int reit = Integer.parseInt(scanner.nextLine());
                nyResept(type, legemiddel, lege, pasient, reit);
            }
            }
            else if(input == 6){
                System.out.println("En liste av pasientene:");
                for (Pasient pasient1: pasientListe){
                    System.out.println(pasient1.hentId() + pasient1.hentNavn());
                };
                System.out.println("Hva er ID til en pasient:");
                int pasientID = Integer.parseInt(scanner.nextLine());
                Pasient pasientResept = null;
                for(Pasient pasient1: pasientListe){
                    if (pasient1.hentId() == pasientID) {
                        pasientResept = pasient1;
                    }
                }

                System.out.println("En liste av reseptene:");
                Stabel<Resept> reseptliste = pasientResept.hentReseptListe();
                for (Resept resept1: resepterListe){
                  resept1.skrivInfo();
                }
                System.out.println("Skriv inn ID-en til reseptet du vil bruke:");
                int reseptId = Integer.parseInt(scanner.nextLine());
                brukResept(reseptId);
            }
            else if(input == 7){
                antVannResept();
            }
            else if (input == 8){
                antNarkResept();
            }
            else if (input == 9){
                MisbrukNarkotika();
            }
            menu();
            input = Integer.parseInt(scanner.nextLine());
        }
    }
    public static void skrivInfo(){
        for (Pasient pasient1 : pasientListe){
           System.out.println(pasient1);
        }
        for (Lege lege1: legeListe){
           System.out.println(lege1);
        }
        for (Legemiddel legemiddel1: legemiddelListe){
            System.out.println(legemiddel1);
        }
        for (Resept resept1: resepterListe){
            System.out.println(resept1);
        }
    }

    public static void nyLege(String navn){
        Lege nyLege = new Lege(navn);
        legeListe.leggTil(nyLege);
    }
    public static void nySpesialist(String navn, int kontrollID){
        Spesialist nySpesialist = new Spesialist(navn, kontrollID);
        legeListe.leggTil(nySpesialist);
    }

    public static void nyPasient(String navn, String fnr){
        Pasient nyPasient = new Pasient(navn, fnr);
        pasientListe.leggTil(nyPasient);
    }

    public static void nyLegemiddel(String navn, String type, double pris, double virkestoff, int styrke){
        if(type.equals("A")){
            PreparatA nyPreparatA = new PreparatA(navn,pris,virkestoff,styrke);
            legemiddelListe.leggTil(nyPreparatA);
            //System.out.println("Legemiddel " + nyPreparatA.hentNavn() + " er klar.");
        } else if(type.equals("B")){
            PreparatB nyPreparatB = new PreparatB(navn,pris,virkestoff,styrke);
            legemiddelListe.leggTil(nyPreparatB);
            //System.out.println("Legemiddel " + nyPreparatB.hentNavn() + " er klar.");
        } else if (type.equals("C")){
            PreparatC nyPreparatC = new PreparatC(navn,pris,virkestoff);
            legemiddelListe.leggTil(nyPreparatC);
            //System.out.println("Legemiddel " + nyPreparatC.hentNavn() + " er klar.");
        } else {
            System.out.println("Ugyldig. Gyldige er A, B eller C.");
        }
    }

    private static boolean sjekkGyldigResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient){
        boolean sjekk1 = false;
        boolean sjekk2 = false;
        boolean sjekk3 = false;

        for(Legemiddel legemiddel1: legemiddelListe){
            if(legemiddel1.hentNavn().equals(legemiddel.hentNavn())){
                sjekk1 = true;
            }
        }

        for(Lege lege1: legeListe){
            if(utskrivendeLege.hentNavn().equals(lege1.hentNavn())){
                sjekk2 = true;
            }
        }

        for(Pasient pasient1 : pasientListe){
            if(pasient1.hentNavn().equals(pasient.hentNavn())) {
                sjekk3 = true;
            }
        }

        return (sjekk1 && sjekk2 && sjekk3);
    }

    public static void nyResept(String type, Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        boolean gyldig = sjekkGyldigResept(legemiddel,utskrivendeLege,pasient);
        if(gyldig){
            if(type.equals("Blaa")){
            BlaaResept nyBla = new BlaaResept(legemiddel, utskrivendeLege, pasient, reit);
            utskrivendeLege.leggTilResept(nyBla);
            pasient.leggerResept(nyBla);
            resepterListe.leggTil(nyBla);
        }
        else if (type.equals("Hvitt")){
            HvitResept nyHvit = new HvitResept(legemiddel, utskrivendeLege, pasient, reit);
            utskrivendeLege.leggTilResept(nyHvit);
            pasient.leggerResept(nyHvit);
            resepterListe.leggTil(nyHvit);
        }
        else if (type.equals("Militear")){
            Militearresept nyM = new Militearresept(legemiddel, utskrivendeLege, pasient, reit);
            utskrivendeLege.leggTilResept(nyM);
            pasient.leggerResept(nyM);
            resepterListe.leggTil(nyM);
        }
        else if (type.equals("Presept")){
            PResept nyP = new PResept(legemiddel, utskrivendeLege, pasient, 3);
            utskrivendeLege.leggTilResept(nyP);
            pasient.leggerResept(nyP);
            resepterListe.leggTil(nyP);
        }
        else{
            System.out.println("Ugyldig. Gyldige er Blaa, Hvitt, Militear og Presept.");
        }
        }
    }
    public static void brukResept(int reseptId){
        for (Resept resept1: resepterListe){
          if(resept1.hentId()==reseptId){
            if(resept1.erBrukt()){
              System.out.println("Brukte resept paa " + resept1.hentLegemiddel().hentNavn() + ". Antall gjenvaerende reit: " + resept1.hentReit());
            } else {
              System.out.println("Ingen flere reit.");
            }
            return;
          }
        }
        System.out.println("Ugyldig!");
        valg();
    }
    public static void antVannResept(){
        int antall = 0;
        for(Resept resept1: resepterListe){
          if(resept1.hentLegemiddel() instanceof PreparatB){
            antall++;
          }
        }
        System.out.println("Det er totalt utskrevet " + antall + " vannedannende resepter.");
    }
    public static void antNarkResept(){
        int antall = 0;
        for(Resept resept1: resepterListe){
          if(resept1.hentLegemiddel() instanceof PreparatA){
            antall++;
          }
        }
        System.out.println("Det er totalt utskrevet " + antall + " narkotiske resepter.");
    }
    public static void MisbrukNarkotika(){
        Lenkeliste<Lege> narkoLeger = new Lenkeliste<Lege>();
        Lenkeliste<Pasient> narkoPasient = new Lenkeliste<Pasient>();

        for(Pasient pasient1: pasientListe){
            if(pasient1.antNarkotisk()>0){
                narkoPasient.leggTil(pasient1);
            }
        }
        for(Lege lege1:legeListe){
            if(lege1.antNarkotisk()>0){
                narkoLeger.leggTil(lege1);
            }
        }
        System.out.println("Antall pasienter med narkotiske resepter: " + narkoPasient.stoerrelse());
        System.out.println("Antall leger med narkotiske resepter: " + narkoLeger.stoerrelse());

        System.out.println("Pasienter med narkotiske resepter:");
        for(Pasient pasient1: narkoPasient){
            System.out.println(pasient1.hentNavn() + " har " + pasient1.antNarkotisk() + " resepter.");
        }
        System.out.println("Leger med narkotiske resepter:");
        for(Lege lege1: narkoLeger){
            System.out.println(lege1.hentNavn() + " har " + lege1.antNarkotisk() + " resepter.");
        }
    }
}
