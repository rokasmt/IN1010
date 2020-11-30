class Hovedprogram {
    public static void main(String[] args){
        Regneklynge abel = new Regneklynge("regneklynge.txt");

        System.out.println("Noder med minst 32GB: " + abel.noderMedNokMinne(32));
        System.out.println("Noder med minst 64GB:" + abel.noderMedNokMinne(64));
        System.out.println("Noder med minst 128GB: " + abel.noderMedNokMinne(128));
        System.out.println("");
        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall rack: " + abel.antRacks());


    }

}
