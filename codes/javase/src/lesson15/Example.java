package lesson15;

public class Example {
    public static void main(String[] args) {

        String s1 = "Java";
        System.out.println(s1.length());

        String a = "Salam";
        String b = "Dunya";
        System.out.println(a.concat(b));

        char[] arr1 = {'J','A','V','A'};
        System.out.println(String.copyValueOf(arr1));

        char[] arr2 = {'A','B','C','D','E'};
        System.out.println(String.copyValueOf(arr2, 1, 3));

        String s2 = "Java";
        System.out.println(s2.charAt(2));

        String s3 = "test.java";
        System.out.println(s3.endsWith(".java"));

        String s4 = "java";
        String s5 = "java";
        System.out.println(s4.equals(s5));

        String s6 = "Java";
        String s7 = "java";
        System.out.println(s6.equalsIgnoreCase(s7));

        String s8 = "abcdef";
        char[] arr3 = new char[6];
        s8.getChars(1, 4, arr3, 2);
        System.out.println(arr3);

        String s9 = "hello";
        System.out.println(s9.indexOf("e"));

        String s10 = "12345";
        System.out.println(s10.matches("\\d+"));

        String s11 = "HelloWorld";
        String s12 = "World";
        System.out.println(s11.regionMatches(5, s12, 0, 5));

        String s13 = "Java";
        char[] arr4 = s13.toCharArray();
        System.out.println(arr4[0]);

        String s14 = "   ";
        System.out.println(s14.isBlank());

        String s15 = "";
        System.out.println(s15.isEmpty());

        String s16 = "Java";
        System.out.println(s16.replace("a", "o"));

        String s17 = "a,b,c";
        String[] arr5 = s17.split(",");
        System.out.println(arr5[0]);

        String s18 = "Hello";
        System.out.println(s18.startsWith("He"));

        String s19 = "Hello";
        System.out.println(s19.substring(1, 4));

        String s20 = "JAVA";
        System.out.println(s20.toLowerCase());

        String s21 = "java";
        System.out.println(s21.toUpperCase());

        String s22 = "Hello World";
        System.out.println(s22.contains("World"));

        String s23 = "  Java  ";
        System.out.println(s23.trim());

    }
}
