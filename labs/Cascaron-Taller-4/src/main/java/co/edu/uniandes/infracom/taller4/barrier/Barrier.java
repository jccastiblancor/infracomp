package co.edu.uniandes.infracom.taller4.barrier;
import co.edu.uniandes.infracom.taller4.testhandler.Semaforo;
import co.edu.uniandes.infracom.taller4.testhandler.TestHandler;

public class Barrier extends TestHandler<BarrierMethods> implements BarrierInterface<BarrierMethods> {
    private static int compartida;
    private static Semaforo sem1 = new Semaforo(0);
    private static Semaforo sem2 = new Semaforo(0);
    private static Semaforo mutex = new Semaforo(1);

    public Barrier() {
        super();
    }

    @Override
    public void A(BarrierThread thread) {
        //TODO Completar el metodo A
        mutex.p();
        this.addEvents(BarrierMethods.A);
        int temp = compartida;
        compartida = temp + 1;
        mutex.v();
        sem1.v();

    }

    @Override
    public void B(BarrierThread thread) {
        //TODO Completar el metodo B
        mutex.p();
        this.addEvents(BarrierMethods.A);
        int temp = compartida;
        compartida = temp + 10;
        mutex.v();
        sem2.v();
    }

    @Override
    public void C(BarrierThread thread) {
        //TODO Completar el metodo C
        sem1.p();
        sem2.p();
        mutex.p();
        this.addEvents(BarrierMethods.C);
        int temp = compartida;
        compartida = temp + 100;
        mutex.v();
    }

    @Override
    public Semaforo[] getSemaphoresRef() {
        //TODO Instanciar y retornar el arreglo de semaforos

        Semaforo[] semaforos = {sem1, sem2};
        return semaforos;
    }

    public static void main(String[] args) {
        //TODO Completar el main y lanzar el programa
        Barrier barrera = new Barrier();
        BarrierThread A = new BarrierThread("A", barrera);
        BarrierThread B = new BarrierThread("B", barrera);
        BarrierThread C = new BarrierThread("C", barrera);

        A.start();
        B.start();
        C.start();
    }
}
