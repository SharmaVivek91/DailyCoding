class Trampoline<T> {
    public T get() { return null;}
    public Trampoline<T>  run() { return null;}
    T execute() {
        Trampoline<T>  trampoline = this;
        while (trampoline.get() == null) trampoline = trampoline.run();
        return trampoline.get();
    }
}

public class DayTwelve {
    public static Trampoline<Integer> factorial(final int n, final Integer product) {
        if(n > 1) {
            return new Trampoline<Integer>() {
                public Trampoline<Integer> run() {
                    return factorial(n - 1, product*(n));
                }
            };
        }
        else {
            return new Trampoline<Integer>() {
                 public Integer get() { 
                     return product; 
                    } 
                };
            }
        }
    public static void main( String [ ] args ) {
        System.out.println(factorial(10, 1).execute());
    }
}
