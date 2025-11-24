package lesson05;
public class PrimitiveTypeConversionHome {
    public static void main(String[] args) {
    	
        int i1 = 55;
        byte b1 = (byte) i1;
        System.out.println("int 55 → byte: " + b1);


        short s1 = 636;
        byte b2 = (byte) s1;
        System.out.println("short 636 → byte: " + b2);


        long l1 = 458;
        short s2 = (short) l1;
        System.out.println("long 458 → short: " + s2);


        long l2 = 92523635483L;
        int i2 = (int) l2;
        System.out.println("long 92523635483 → int: " + i2);


        double d1 = 65787.3;
        int i3 = (int) d1;
        System.out.println("double 65787.3 → int: " + i3);


        char c1 = 'q';
        int i4 = (int) c1;
        System.out.println("char 'q' → int: " + i4);


        int i5 = 266;
        char c2 = (char) i5;
        System.out.println("int 266 → char: " + c2);
    }
}
