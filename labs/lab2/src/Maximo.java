public class Maximo {
    int nThreads;
    int maximo;
    int cont;

    public Maximo (int numT){
        nThreads = numT;
        maximo = 0;
        cont = 0;
    }
    public synchronized int darMaximo(){
        return maximo;
    }

    public synchronized boolean cambiarMaximo(int n){
        if (n>maximo){
            maximo = n;
        }
        cont ++;
        return (cont == nThreads);

    }
}
