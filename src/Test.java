public class Test {
    public static void main(String[] args) {
        int x = 50;
        int y = 200;
        boolean result = false;

        result = (x<y &&  y++ < 200);
        System.out.println(result);


        result = (x<y || y<x);
        System.out.println(result);

        result = !(x>y);

        System.out.println(!(result));

        int a = 5;
        char b = 4;
        System.out.println(a>b);
        System.out.println(a >= b);
        System.out.println( a == b);

    }
}
