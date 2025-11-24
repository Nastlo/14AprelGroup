package lesson05;
public class PrimitiveTypeConversion {
    public static void main(String[] args) {

        short s1 = 69;
        byte b1 = (byte) s1;
        System.out.println("short 69 → byte: " + b1);


        short s2 = 589;
        byte b2 = (byte) s2;
        System.out.println("short 589 → byte: " + b2);


        long l1 = 458;
        int i1 = (int) l1;
        System.out.println("long 458 → int: " + i1);


        long l2 = 52523635483L;
        int i2 = (int) l2;
        System.out.println("long 52523635483 → int: " + i2);


        double d1 = 5632.6;
        float f1 = (float) d1;
        System.out.println("double 5632.6 → float: " + f1);


        char c1 = 'D';
        int i3 = (int) c1;
        System.out.println("char 'D' → int: " + i3);


        int i4 = 123;
        char c2 = (char) i4;
        System.out.println("int 123 → char: " + c2);
    }
}
