public class SumOfPattern {
    public static void main(String[] arg)
    {
        int [][] a={{1},{2,2},{3,3,3},{4,4,4,4}};
        int [][] b={{4},{3,3},{2,2,2},{1,1,1,1}};
        int [][] Sum= new int[4][4];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                Sum[i][j]=a[i][j]+b[i][j];
            }
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(Sum[i][j]);
            }
            System.out.println();
        }
    }
}
