public class Main {

    public static void main(String[] args) {
        int ejecuciones = 10;
        Ab a = new Ab(true, ejecuciones);
        Ab b = new Ab(false, ejecuciones);
        a.start();
        b.start();

        Signaling aS = new Signaling(true);
        Signaling bS = new Signaling(false);
        bS.start();
        aS.start();
    }
}
