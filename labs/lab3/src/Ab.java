public class Ab extends Thread{
    public static int variable = 0;
    private static Semaforo semaforo = new Semaforo(1);
    private boolean a;
    private int numeroEjecuciones;

    public Ab(boolean a, int numeroEjecuciones){
        this.a = a;
        this.numeroEjecuciones = numeroEjecuciones;
    }

    public void run(){
        if (a){
            for (int i = 0; i<numeroEjecuciones; i++){
                this.a();
                //this.esperaAleatoria();
            }
        } else{
            for (int i = 0; i<numeroEjecuciones; i++) {
                this.b();
                //this.esperaAleatoria();
            }
        }
    }

    private void a(){
        semaforo.p();

        int valor = variable;
        this.esperaAleatoria();
        variable = valor + 1000;
        System.out.println(variable);
        semaforo.v();
    }

    private void b(){
        semaforo.p();
        variable +=1;
        System.out.println(variable);
        semaforo.v();
    }

    private void esperaAleatoria() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
