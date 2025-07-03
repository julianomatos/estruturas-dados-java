package ordenacao;

public class Recursiva {

    public static int fatorial(int n){
        if ( n == 0 ){
            return 1;
        }else{
            return n * fatorial(n - 1);
        }
    }

    public static int fibonacci(int n){
        if (n <= 1){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
      //  System.out.println(fatorial(6));
        System.out.println(fibonacci(10));
    }

}
