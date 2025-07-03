package matrizes;

public class Teste {
    public static void main(String[] args) {
        int[][] minhaMatriz = {
                {1, 2, 3},
                {4, 5, 9},
                {8, -10, 8}
        };
        Matriz m1 = new Matriz(minhaMatriz);

        System.out.println(m1.retornaMenor());
    }
}
