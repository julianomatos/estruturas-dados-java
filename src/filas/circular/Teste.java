package filas.circular;

public class Teste {
    public static void main(String[] args) {

        FilaCircular<String> circular = new FilaCircular<>(5);

        circular.enfileirar("A");
        circular.enfileirar("B");
        circular.enfileirar("C");
        circular.desenfileirar();
        circular.enfileirar("D");
        circular.enfileirar("E");
        circular.enfileirar("F");

        circular.imprimirTodos();

        System.out.println(circular.espiar());
    }
}
