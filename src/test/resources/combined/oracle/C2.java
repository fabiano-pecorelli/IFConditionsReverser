public class C2 {
    public void method(Number x, Number y, Number z) {
        if ((x % 2 != 0) || (--y + z++ == 5))  {
            System.out.println("x is even");
        } else {
            System.out.println("x is odd");
        }
        while(x-- <= 0) {
                System.out.println("x is positive");
        }
        if (x != 0) {
            System.out.println("x is zero");
        } else {
            if (x <= 0) {
                System.out.println("x is positive");
            } else {
                System.out.println("x is negative");
            }
        }
    }
}