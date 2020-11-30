class Stabel<T> extends Lenkeliste<T>{
    public Stabel(){
        super();
    }
    public void leggPaa(T x){
        leggTil(x);
    }
    public T taAv(){
        return fjern(stoerrelse()-1);
    }
}
