public class IntegrasjonsTest {
    public static void main(String[] args) {
    PreparatA legemiddelA = new PreparatA("Prezidol", 400, 75, 8);
    PreparatB legemiddelB = new PreparatB("ParalginForte", 65, 400, 5);
    PreparatC legemiddelC = new PreparatC("Ibux", 240, 200);

    System.out.println(legemiddelA);
    System.out.println(legemiddelB);
    System.out.println(legemiddelC);

    Lege lege1 = new Lege("Dr. Cox");
    Spesialist spesialist1 = new Spesialist("Dr. Hillestad Lovold", 2);

    BlaaResept reseptB = new BlaaResept(legemiddelA, lege1, 2, 3);
    HvitResept reseptH = new HvitResept(legemiddelB, spesialist1, 3, 10000);
    Militearresept reseptM = new Militearresept(legemiddelA, lege1, 1, 150);
    PResept reseptP = new PResept(legemiddelB, spesialist1, 4, 3);

    System.out.println(lege1);
    System.out.println(spesialist1);
    System.out.println(reseptB);
    System.out.println(reseptH);
    System.out.println(reseptM);


    // Tester om farge er blaa
    if (reseptB.farge() == "blaa"){
        System.out.println("Farge er blaa");
    } else {
        System.out.println("Farge er ikke blaa");
    }
    // Sjekker om blaa resept pris er riktig
    if (reseptB.prisAaBetale() == 100.0){
      System.out.println("Pris er riktig");
    } else {
      System.out.println("Pris er feil");
    }
    // Sjekker om PResept pris er riktig
    if (reseptP.prisAaBetale() == 0.0){
        System.out.println("Pris er riktig");
    } else {
        System.out.println("Pris er feil");
    }
    // Sjekker om militearresept pris er riktig
    if (reseptM.prisAaBetale() == 0){
      System.out.println("Pris er riktig");
    } else {
      System.out.println("Pris er feil");
    }
    // Sjekker om er det mulig aa bruke resept
    if (reseptB.erBrukt()){
        System.out.println("erBrukt() fungerer");
    } else {
        System.out.println("erBrukt() fungerer ikke.");
    }
    // Sjekker om er det mulig aa bruke resept
    if (reseptB.hentReit() == 2){
        System.out.println("Reit er riktig");
    } else {
        System.out.println("Reit er feil");
    }
}
}
