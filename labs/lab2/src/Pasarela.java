public class Pasarela {
    int derecha;
    int izquierda;

    public Pasarela (){
    }

    /**
     *
     * @param direccion true para derecha false para izquierda
     */
    public synchronized void entrar(boolean direccion){
        if (direccion) { // camina hacia la derecha
            try {
                while (izquierda > 0) {
                    wait();
                }
                System.out.println("entra persona con direccion: derecha");
                derecha++;
            } catch (Exception ignored) {

            }
        } else { // camina hacia la izquierda
            try {
                while (derecha > 0) {
                    wait();
                }
                System.out.println("entra persona con direccion: izquierda");
                izquierda++;
            } catch (Exception ignored) {

            }
        }
    }

    public synchronized void salir(boolean direccion){
        System.out.println("sale persona con direccion:" + (direccion? "derecha": "izquierda"));
        if (direccion) { // camina hacia la derecha
            derecha--;
        } else {  // camina hacia la izquierda
            izquierda--;
        }
        notifyAll();
    }
}
