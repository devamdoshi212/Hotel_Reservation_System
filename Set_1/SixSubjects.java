import java.util.Scanner;

public class SixSubjects {
    public static void main(String[] arg)
    {
        Scanner ans=new Scanner(System.in);
        double marks,Sum=0;
        for(int i=0;i<6;i++)
        {
            System.out.print("Enter marks of Subject "+(i+1)+": ");
            marks=ans.nextDouble();
            Sum+=marks;
        }
        double percent=(Sum*100)/600;
        System.out.println("Percentage: "+String.format("%.2f",percent)+"%");
        ans.close();
    }
}
