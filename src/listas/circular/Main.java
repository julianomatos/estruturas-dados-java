package listas.circular;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListaCircular<String> times = new ListaCircular<>();

        times.inserirNoFim("Palmeiras");
        times.inserirNoFim("Flamengo");
        times.inserirNoFim("Cruzeiro");
        times.removerNoInicio();

        times.imprimir();
    }
}