package vetores;

public class Vetor {
    private String[] elementos;
    private int quantidade;

    public Vetor(int capacidade){
        elementos = new String[capacidade];
        quantidade = 0;
    }

    public void adicionar(String e){
        if(quantidade < elementos.length) {
            elementos[quantidade] = e;
            quantidade++;
        }else{
            System.out.println("Não foi possível inserir "
                    + e + " .Vetor Cheio");
        }
    }

    public void alterar(String e, int indice){
        if(indice >=0 && indice < quantidade){
            elementos[indice] = e;
        }else{
            System.out.println("Indice inválido.");
        }
    }

    public void remover(int indice){
        if(indice >=0 && indice < quantidade) {
            for (int i = indice; i < quantidade; i++) {
                elementos[i] = elementos[i + 1];
            }
            quantidade--;
        }else{
            System.out.println("Índice inválido.");
        }
    }

    public void aumentarCapacidade(){
        String[] novoVetor = new String[elementos.length * 2];
        for (int i = 0; i < quantidade; i++){
            novoVetor[i] = elementos[i];
        }
        elementos = novoVetor;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < quantidade -1;i++){
            str += elementos[i] + ",";
        }
        str += elementos[quantidade - 1] + "]";
        return str;
    }
}
