class Fibonacci {
    public static double of(int num) {
        double a = 1, b = 1, c = 0;
        if(num == 1 || num == 2) return a;
        for (int i = 3; i <= num; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

public class AgileHomework {
    public static void main(String[] args)  {
        for(int i = 1 ;i <= 200; i++)
            System.out.printf("第%d次Fibonacci数:%.0f\n",i,Fibonacci.of(i));
    }
}




  




