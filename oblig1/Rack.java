import java.util.ArrayList;

class Rack {

    ArrayList<Node> noder;
    int noderPerRack;

    public Rack(int noderPerRack) {
        this.noderPerRack = noderPerRack;
        noder = new ArrayList <Node> ();
    }

    public void settInn(int minne, int antPros) {
        noder.add(new Node(minne, antPros));
    }

    public boolean erFull(){
        if(noderPerRack <= noder.size()) {
            //System.out.println("Rack inneholder " + noder.size() + " noder, og er full.");
            return true;
        } else{
            //System.out.println("Rack inneholder " + noder.size() + " og er ikke full.");
            return false;
        }
    }

    public int getAntNoder(){
        return noder.size();
    }

    public int antProsessorer() {
        int antProsessorer = 0;

        for (Node node:noder) {
            if (node!= null){
                antProsessorer += node.antProsessorer();
            }
        }
        return antProsessorer;
    }

    public int noderMedNokMinneRack (int paakrevdMinne) {
        int antNoderMedNokMinne = 0;

        for(Node node:noder) {
            if (node!= null) {
                if (node.nokMinne(paakrevdMinne)) {
                    antNoderMedNokMinne++;
                }
            }
        }
        return antNoderMedNokMinne;
    }
}
