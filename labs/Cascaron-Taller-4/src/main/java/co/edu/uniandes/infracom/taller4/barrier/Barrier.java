package co.edu.uniandes.infracom.taller4.barrier;
import co.edu.uniandes.infracom.taller4.testhandler.Semaforo;
import co.edu.uniandes.infracom.taller4.testhandler.TestHandler;

public class Barrier extends TestHandler<BarrierMethods> implements BarrierInterface<BarrierMethods> {
    private static int compartida;
    public Barrier() {
        super();
    }

    @Override
    public void A(BarrierThread thread) {
        //TODO Completar el metodo A

        int temp = compartida;
        compartida = temp + 1;

    }

    @Override
    public void B(BarrierThread thread) {
        //TODO Completar el metodo B
        int temp = compartida;
        compartida = temp + 10;
    }

    @Override
    public void C(BarrierThread thread) {
        //TODO Completar el metodo C
        int temp = compartida;
        compartida = temp + 100;
    }

    @Override
    public Semaforo[] getSemaphoresRef() {
        Semaforo sem1 = new Semaforo(0);
        Semaforo sem2 = new Semaforo(0);
        Semaforo[] semaforos = {sem1, sem2};
        return semaforos;
    }

    public static void main(String[] args) {
        //TODO Completar el main y lanzar el programa
    }
}
