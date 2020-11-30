class TestPreparat {
    public static void main (String [] args) {
        PreparatA legemiddelA = new PreparatA("Prezidol", 450, 75, 8);
        PreparatB legemiddelB = new PreparatB("ParalginForte", 65, 400, 5);
        PreparatC legemiddelC = new PreparatC("Ibux", 240, 200);

        System.out.println(legemiddelA);
        System.out.println(legemiddelB);
        System.out.println(legemiddelC);

        // Tester hentId()
        if (legemiddelA.hentId() == 0) {
            System.out.println("hentId() fungerer");
        } else {
            System.out.println("hentId() fungerer ikke");
        }
        // Tester hentNavn()
        if (legemiddelA.hentNavn() == "Prezidol") {
            System.out.println("hentNavn() fungerer");
        } else {
            System.out.println("hentNavn() fungerer ikke");
        }
        // Tester hentPris()
        if (legemiddelA.hentPris() == 450.0) {
            System.out.println("hentPris() fungerer");
        } else {
            System.out.println("hentPris() fungerer ikke");
        }
        // Tester hentVirkestoff()
        if (legemiddelA.hentVirkestoff() == 75.0) {
            System.out.println("hentVirkestoff() fungerer");
        } else {
            System.out.println("hentVirkestoff() fungerer ikke");
        }
        // Tester settNyPris()
        legemiddelA.settNyPris(300);

        if (legemiddelA.hentPris() == 300){
            System.out.println("settNyPris() fungerer");
        } else {
            System.out.println("settNyPris() fungerer ikke");
        }
        // Tester hentVanedannendeStyrke()
        if (legemiddelA.hentVanedannendeStyrke() == 8){
            System.out.println("hentVanedannendeStyrke() fungerer");
        } else {
            System.out.println("hentVanedannendeStyrke() fungerer ikke");
        }
        // Tester hentNarkotiskStyrke()
        if (legemiddelB.hentNarkotiskStyrke() == 5){
            System.out.println("hentNarkotiskStyrke() fungerer");
        } else {
            System.out.println("hentNarkotiskStyrke() fungerer ikke");
        }
    }
}
