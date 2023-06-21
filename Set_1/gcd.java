import java.util.Scanner;

public class gcd {
    static int g_c_d(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return g_c_d(a-b, b);
        return g_c_d(a, b-a);
    }
    public static void main(String[] args)
    {
        int n1,n2;
        Scanner ans=new Scanner(System.in);
        System.out.print("Enter number 1: ");
        n1=ans.nextInt();
        System.out.print("Enter number 2: ");
        n2=ans.nextInt();
        System.out.println("GCD of "+n1+" and "+n2+": "+g_c_d(n1,n2));
        ans.close();
    }
}
