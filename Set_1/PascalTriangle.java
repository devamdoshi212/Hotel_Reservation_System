import java.util.Scanner;

public class PascalTriangle {
    static int fact(int n) {
        int f;

        for(f = 1; n > 1; n--){
            f *= n;
        }
        return f;
    }
    static int ncr(int n,int r) {
        return fact(n) / ( fact(n-r) * fact(r) );
    }
    public static void main(String args[]){
        int n, i, j;
        Scanner ans=new Scanner(System.in);
        System.out.print("Enter no. : ");
        n=ans.nextInt();

        for(i = 0; i <= n; i++)
        {
            for(j = 0; j <= n-i; j++){
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++){
                System.out.print(" "+ncr(i, j));
            }
            System.out.println();
        }
        ans.close();
    }
}
