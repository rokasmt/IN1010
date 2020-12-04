import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T>{

    Node first;
    Node siste;

    public class Node {
        Node neste = null;
        Node forrige = null;
        T data;
        Node(T x) {
        this.data = x;
    }
    }
    public int stoerrelse(){
        int teller = 0;
        Node temp = first;
    while (temp != null){
        teller ++;
        temp = temp.neste;
    }
    return teller;
    }
    public Node hentNode(int pos) throws UgyldigListeIndeks{
        if(pos > stoerrelse()-1 || pos < 0){
            throw new UgyldigListeIndeks(-1);
    } else {
        int teller = 0;
        Node temp = first;
    while (teller != pos){
        temp = temp.neste;
        teller++;
    }
    return temp;
    }
    }
    public void leggTil(int pos, T x) throws UgyldigListeIndeks{
        Node ny = new Node(x);

        if (pos > stoerrelse() || pos < 0){
            throw new UgyldigListeIndeks(-1);
        } else if (stoerrelse() == 0){
            first = ny;
            siste = ny;
        } else if(pos == 0){
            ny.neste = first;
            first.forrige = ny;
            first = ny;
        } else if (pos == stoerrelse()){
            ny.forrige = siste;
            siste.neste = ny;
            siste = ny;
        } else {
            Node temp = hentNode(pos);
            Node tempForrige = temp.forrige;
            ny.forrige = tempForrige;
            tempForrige.neste = ny;
            ny.neste = temp;
            temp.forrige = ny;
        }
    }
    public boolean erTom() {
        return first == null;
    }
    public void leggTil(T x){
        Node nyNode = new Node(x);
    if(erTom()){
        first = nyNode;
        siste = nyNode;
    }else{
        Node temp = siste;
        siste.neste = nyNode;
        siste = nyNode;
        nyNode.forrige = temp;
    }
    }
    public void sett(int pos, T x){
        Node ny = new Node(x);
        Node temp = hentNode(pos);
        temp.data = x;
    }
    public T fjern(int pos) throws UgyldigListeIndeks{
        Node fjern = hentNode(pos);
        T datafjern = fjern.data;

    if (stoerrelse() == 0){
        throw new UgyldigListeIndeks(-1);
    }
    else if (stoerrelse() == 1) {
        first = null;
        siste = null;
    }
    else if (pos == 0){
        Node fjernneste = fjern.neste;
        first = fjernneste;
        fjernneste.forrige = null;
    }
    else if (pos == stoerrelse()-1){
        Node fjernForrige = fjern.forrige;
        siste = fjernForrige;
        fjernForrige.neste = null;
    } else {
        Node fjernForrige = fjern.forrige;
        Node fjernNeste = fjern.neste;
        fjernForrige.neste = fjernNeste;
        fjernNeste.forrige = fjernForrige;
    }
    return datafjern;
    }
    public T fjern() throws UgyldigListeIndeks{
        if(first == null){
            throw new UgyldigListeIndeks(-1);
    } else {
        Node temp = first;
        T datafjern = temp.data;
        first = temp.neste;
    return datafjern;
    }
    }
    public T hent(int pos){
         return hentNode(pos).data;
    }
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }
    private class LenkelisteIterator implements Iterator<T>{
    private int indeks = 0;

    public boolean hasNext(){
      return indeks < stoerrelse();
    }
    public T next(){
        if(hasNext()){
            return(hentNode(indeks++).data);
    } else {
        throw new UgyldigListeIndeks(indeks);
    }
    }
    public void remove(){};
    }

}
