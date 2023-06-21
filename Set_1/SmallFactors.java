import java.util.Scanner;

public class SmallFactors {
    static int Prime(int n)
    {
        int temp=1;
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                temp=0;
                break;
            }
        }
        return temp;
    }
    public static void main(String[] agr)
    {
        int n;
        System.out.print("Enter number to display smallest factors in increasing order: ");
        Scanner ans=new Scanner(System.in);
        n=ans.nextInt();
        ans.close();
        int j=0,te=1,i=2;
        int m=n;
        int a[]=new int[100];
        while(te<n)
        {
            if(Prime(i)==1)
            {
                while(m%i==0)
                {
                    a[j++]=i;
                    te*=i;
                    m=m/i;
                }
            }
            i++;
        }

        for(i=0;i<j;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
