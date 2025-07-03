package filas.simples;


public class Atendimento {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Juliano", 8);
        Cliente c2 = new Cliente("Ana", 12);
        Cliente c3 = new Cliente("João", 7);

        Fila<Cliente> filaAtendimento = new Fila<>(8);

        filaAtendimento.enfileirar(c1);
        filaAtendimento.enfileirar(c2);
        filaAtendimento.enfileirar(c3);

        int tempoTotal = 0;
        int contaAtendimento = 0;
        while (!filaAtendimento.estaVazia()){
            Cliente cliente = filaAtendimento.desenfileirar();
            System.out.println((contaAtendimento + 1) + "º Atendimento.");
            System.out.println("Nome: " + cliente.nome);
            System.out.println("Tempo gasto: " + cliente.tempo);
            System.out.println();
            tempoTotal += cliente.tempo;
            contaAtendimento++;
        }
        System.out.println("Tempo total gasto: " + tempoTotal);
        System.out.println("Total de atendimentos: " + contaAtendimento);


    }
}
