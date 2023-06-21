public class TypeCasting {
    public static void main(String[] arg)
    {
        System.out.println("Widening Type Casting of 5");
        int n=5;
        System.out.println("int value of 5: "+n);
        float f=n;
        System.out.println("float value of 5: "+f);
        double d=n;
        System.out.println("double value of 5: "+d);

        System.out.println("Narrowing Type Casting of 12.6875");
        double dd=12.6875;
        System.out.println("double value of 12.6875: "+dd);
        float ff=(float)dd;
        System.out.println("float value of 12.6875: "+ff);
        int nn=(int)dd;
        System.out.println("int value of 12.6875: "+nn);
    }
}
