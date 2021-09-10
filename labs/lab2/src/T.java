import java.util.Random;

public class T extends Thread{
    private static Identificar objId ;
    private static Maximo m ;
    private static int [][] mat ;

    public T (){
    }

    private static int[][] crearMatriz(int n){
        int[][] randomMatrix = new int [n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Integer r = rand.nextInt()% 100;
                randomMatrix[i][j] = Math.abs(r);
            }
        }
        return randomMatrix;
    }
    public void run() {
        int locMax = 0 ;
        int id = objId.darNumId () ;
        for (int j=0; j<mat[id].length; j++){
            if (mat[id][j] > locMax) {
                locMax = mat[id][j];
            }
        }
        if (m.cambiarMaximo(locMax)){
            System.out.println("Max: " + m.darMaximo ()) ;
        }

    }

    public static void main(String[] args){
        int n = 10;
        objId = new Identificar();
        m = new Maximo(n);
        mat = crearMatriz(n);
        for (int i=0; i<n; i++){
            new T().start() ;
        }


    }
}
