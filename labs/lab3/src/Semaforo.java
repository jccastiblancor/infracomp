import java.util.LinkedList;

public class Semaforo {
    private int contador ;
    private LinkedList<Object> colaEspera ;

    public Semaforo(int contador) {
        this.contador = contador;
        colaEspera = new LinkedList<Object>();
    }

    public synchronized void p() {
        try {
            this.contador--;
            if (contador < 0){

                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void v() {
        this.contador++;
        if (contador <= 0){
            notify();
        }
    }
}
