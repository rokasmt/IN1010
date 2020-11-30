class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{
    public SortertLenkeliste(){
        super();
    }

    public void leggTil(T x){
        Node ny = new Node(x);
    if (first == null){
        first = ny;
        siste = ny;
    } else {
        Node temp = first;
        T nyData = ny.data;

    while(temp != null && nyData.compareTo(temp.data) > 0){
        temp = temp.neste;
    }

    if(temp == first){
        ny.neste = first;
        first.forrige = ny;
        first = ny;
    }

    else if (temp == null){
        ny.forrige = siste;
        siste.neste = ny;
        siste = ny;
    } else {
        Node tempForrige = temp.forrige;
        tempForrige.neste = ny;
        ny.forrige = tempForrige;
        ny.neste = temp;
        temp.forrige = ny;
    }
    }
}
    public T fjern() throws UgyldigListeIndeks{
        return fjern(stoerrelse() - 1);
    }
    public void sett(int pos, T x){
        throw new UnsupportedOperationException();
    }
    public void leggTil(int pos, T x){
        throw new UnsupportedOperationException();
    }
}
