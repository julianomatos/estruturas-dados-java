package listas.simplesLigada;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaLigada<String> listaCidades = new ListaLigada<>();

        listaCidades.inserirNoFim("Torres");
        listaCidades.inserirNoFim("Capão da Canoa");
        listaCidades.inserirNoFim("Terra de Areia");
        listaCidades.inserirNoInicio("A");
        String cidade = listaCidades.removerDaPosicao(3);
        System.out.println(cidade);

        //listaCidades.exibir();

//        listaCidades.removerPorValor("Capao da Canoa");
//        listaCidades.exibir();

    }
}