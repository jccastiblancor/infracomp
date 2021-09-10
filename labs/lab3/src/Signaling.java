public class Signaling extends Thread{
    public static int variable = 0;
    private static Semaforo semaforo = new Semaforo(0);
    private boolean a;

    public Signaling(boolean a) {
        this.a = a;
    }

    public void run() {
        if (a) {
            this.a();
        } else {
            this.b();
        }
    }

    private void a() {
        int valor = variable;
        variable = valor + 100;
        System.out.println(variable);
        semaforo.v();
    }

    private void b() {
        semaforo.p();
        int valor = variable;
        variable = valor + 10;
        System.out.println(variable);
    }

}
