public class RunnableThread implements Runnable {

    private int limite;
    private int sleep;
    private boolean par;

    public RunnableThread (boolean par,int limite, int sleep){
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
        Thread pares = new Thread(new RunnableThread(true, 10, 1));
        Thread impares = new Thread(new RunnableThread(false, 10, 1));

        impares.start();
        pares.start();

    }



}
