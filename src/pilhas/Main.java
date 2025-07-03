package pilhas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pilha<String> nomes = new Pilha(5);



        nomes.empilhar("Adão");
        nomes.empilhar("Eva");

        nomes.empilhar("Adão 2");
        nomes.empilhar("Eva 2");
        nomes.empilhar("Adão 3");
        nomes.empilhar("Eva 3");

        System.out.println(nomes.desempilhar());
        System.out.println(nomes.desempilhar());

        nomes.empilhar("Joaquina");

        nomes.imprimir();

        Pilha<Integer> numeros = new Pilha(10);

        numeros.empilhar(5);
        numeros.empilhar(10);
        numeros.imprimir();

        Pilha<Character> caracteres = new Pilha<>(20);



    }
}