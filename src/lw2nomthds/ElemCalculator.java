package lw2nomthds;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ElemCalculator {
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in, StandardCharsets.UTF_8);
        byte num;
        int sum = 0;
        try {
            System.out.println("Enter length of array: ");
            num = ns.nextByte();
            byte[] m = new byte[num];
            for (int i = 0; i < m.length; i++) {
                System.out.println("Element " + (i + 1));
                m[i] = ns.nextByte();
                sum +=  m[i];
            }
            System.out.println("Array: " + Arrays.toString(m));
            if(sum > 127 || sum <(-128)){
                throw new IllegalArgumentException("Byte type supports digits in range from -128 to 127, your is " + sum);
            }
            System.out.println(sum);
        } catch(InputMismatchException e){
            System.out.println("Your element wasn't byte type");
        }
    }
}
