import java.util.Scanner;

public class RupeesToDollar {
    public static void main(String[] arg)
    {
        Scanner ans = new Scanner(System.in);
        System.out.print("Enter Amount in Rupees: ");
        double rupee=ans.nextInt();
        double dollar=rupee/60;
        System.out.println(rupee+" equals to $"+String.format("%.2f", dollar));
        ans.close();
    }
}
