public class SumAndAverage {
    public static void main(String[] arg)
    {
        if(arg.length!=3)
            System.out.println("Enter exact 3 numbers in command line argument");
        else
        {
            double a=Double.parseDouble(arg[0]);
            double b=Double.parseDouble(arg[1]);
            double c=Double.parseDouble(arg[2]);
            double sum=a+b+c;
            double average=sum/3;
            System.out.println("Sum of three no.s from command line argument is"+sum);
            System.out.println("Average of three no.s from command line argument is"+average);
        }
    }
}
