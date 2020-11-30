class TestResepter {
    public static void main (String [] args){

        PreparatA legemiddelA = new PreparatA("Prezidol", 450, 75, 8);
        PreparatB legemiddelB = new PreparatB("Paralgin Forte", 65, 400, 5);
        PreparatC legemiddelC = new PreparatC("Ibux", 240, 200);

        Lege lege1 = new Lege("Dr. Cox");
        Spesialist spesialist1 = new Spesialist("Dr. Hillestad Lovold", 2);

        BlaaResept resept1 = new BlaaResept(legemiddelA, lege1, 2, 3);
        HvitResept resept2 = new HvitResept(legemiddelB, spesialist1, 3, 10000);
        Militearresept resept3 = new Militearresept(legemiddelC, lege1, 5, 10);
        PResept resept4 = new PResept(legemiddelB, spesialist1, 5, 3);


        // Tester hentId()
        if (resept1.hentId() == 0) {
            System.out.println("hentId() fungerer");
        } else {
            System.out.println("hentId() fungerer ikke");
        }
        // Tester hentLegemiddel()
        if (resept1.hentLegemiddel() == legemiddelA ) {
            System.out.println("hentLegemiddel() fungerer");
        } else {
            System.out.println("hentLegemiddel() fungerer ikke");
        }
        // Tester hentLege()
        if (resept1.hentLege() == lege1 ) {
            System.out.println("hentLege() fungerer");
        } else {
            System.out.println("hentLege() fungerer ikke");
        }
        // Tester pasientId()
        if (resept1.hentPasientId() == 2 ) {
            System.out.println("pasientId() fungerer");
        } else {
            System.out.println("pasientId() fungerer ikke");
        }
        // Tester hentReit()
        if (resept1.hentReit() == 3 ) {
            System.out.println("hentReit() fungerer");
        } else {
            System.out.println("hentReit() fungerer ikke");
        }
        // Tester om resept erBrukt()
        if (resept1.erBrukt() == true ) {
            System.out.println("erBrukt() fungerer");
        } else {
            System.out.println("erBrukt() fungerer ikke");
        }
        // Sjekker om farge til resept er blaa
        if (resept1.farge() == "blaa"){
            System.out.println("Farge er blaa");
        } else {
            System.out.println("Farge er ikke blaa");
        }
        // Sjekker om pris til resept er riktig
        if (resept2.prisAaBetale() == 65){
            System.out.println("Pris er riktig");
        } else {
            System.out.println("Pris er ikke riktig");
        }
    }
}
