public class Ejercicio extends Thread{

    private int limite;
    private int sleep;
    private boolean par;

    public Ejercicio (boolean par,int limite, int sleep){
        this.par = par;
        this.limite = limite;
        this.sleep = sleep;
    }

    public void run() {
        try{
            int i = par ? 2: 1;
            while(i<this.limite){
                System.out.println(i);
                i = i + 2;
                Thread.sleep(this.sleep);
            }
        } catch (Exception e) {}

    }

    public static void main(String[] args){
        Ejercicio pares = new Ejercicio(true, 10, 500);
        Ejercicio impares = new Ejercicio(false, 10, 500);

        impares.start();
        pares.start();

    }
}
