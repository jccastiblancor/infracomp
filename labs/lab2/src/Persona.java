import java.util.Random;

public class Persona extends Thread{

    private static Pasarela pasarela;

    public void desfila(boolean direccion){
        try {
            System.out.println("desfila persona con direccion:" + (direccion? "derecha": "izquierda"));
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Random rand = new Random();
        Integer r = rand.nextInt()% 2;

        pasarela.entrar(Math.abs(r) == 1);
        desfila(Math.abs(r) == 1);
        pasarela.salir(Math.abs(r) == 1);
    }

    public static void main(String[] args){
        int n = 10;
        pasarela = new Pasarela();
        for (int i=0; i<n; i++){
            new Persona().start();
        }
    }

}
