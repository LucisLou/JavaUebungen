package Uebung1;

public class WorkingWithStrings {

    public static void main(String[] args) {
        String hello = " Hello World! ";

        System.out.println(hello + hello.length());
        // .length() prints out the length of the String.

        System.out.println(hello.toUpperCase());
        // .toUpperCase() does just as its name indicates; it converts the whole string into upper case.

        System.out.println(hello.toLowerCase());
        // .toLowerCase() is like .toUpperCase, but the exact opposite.

        System.out.println(hello.replaceAll("\\bWorld\\b", "Codersbay"));
        // \\b is a word boundary, although it's not necessary here as there's only one instance of "Hello" in this string, it's good to include for testing purposes.

        System.out.println(hello.substring(1));
        // .substring() prints out only the chars after the given index, in this case after the first which is the first space in " Hello World! ".

        System.out.println("-------------");

        for (int i = 0; i < 15; i++) {
            System.out.println(hello);
        }
        //prints out hello 15 times.

    }
}
