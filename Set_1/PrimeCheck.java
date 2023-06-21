import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] arg)
    {
        System.out.print("Enter number to check whether number is prime or not: ");
        Scanner ans=new Scanner(System.in);
        int n=ans.nextInt();
        ans.close();
        Boolean prime=true;
        int i;
        for(i=2;i<n;i++)
        {
            if(n%i==0)
            {
                prime=false;
                break;
            }
        }
        if(prime)
            System.out.println(n+" is a Prime Number");
        else
            System.out.println(n+" is not a Prime Number");
    }
}
