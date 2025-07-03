package vetores;

public class Teste {
    public static void main(String[] args) {
        Vetor meuVetor = new Vetor(5);
        meuVetor.adicionar("ABC");
        meuVetor.adicionar("ABC");
        meuVetor.adicionar("XYZ");
        meuVetor.alterar("DDD", 1);
        //meuVetor.aumentarCapacidade();
        System.out.println(meuVetor);
        meuVetor.remover(2);
        System.out.println(meuVetor);


    }
}
