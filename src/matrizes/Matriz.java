package matrizes;

public class Matriz {
    private int[][] matriz;


    public Matriz(int[][] matriz){
        this.matriz = matriz;
    }

    public int retornaMenor(){
        int menor = 10000000;

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] < menor){
                    menor = matriz[i][j];
                }
            }
        }

        return menor;
    }
}
