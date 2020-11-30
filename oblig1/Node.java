class Node {
    int antPros;
    int minne;

    public Node(int minne, int antPros){
            this.minne = minne;
            this.antPros = antPros;
            //System.out.println("Opprettet node. Minne: " + minne + " Ant.pros.: " + antPros);
        }

    public int antProsessorer(){
        return antPros;
    }

    public boolean nokMinne(int paakrevdMinne){
        if (minne >= paakrevdMinne) {
            return true;
        } else {
            return false;
        }
    }
}
