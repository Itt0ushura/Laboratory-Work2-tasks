package lw2mthds;

import java.nio.charset.StandardCharsets; //підключення бібліотек
import java.util.Arrays; //підключення бібліотек
import java.util.InputMismatchException; //підключення бібліотек
import java.util.Scanner; //підключення бібліотек

public class ElemCalculatorMthds {

    public static void SetArray(byte[] arr){ //Метод, який встановлює склад масиву
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8); //оголошення сканеру
        try { //блок "трай" який буде "ловити" нашу помилку(введено значення, що не відповідає типу byte)
            for (int i = 0; i < arr.length; i++) { //Заповнення масиву
                System.out.println("Element " + (i + 1)); //Заповнення масиву
                arr[i] = sc.nextByte(); //Заповнення масиву
            } //Заповнення масиву
            System.out.println(Arrays.toString(arr)); //Виведення масиву
        } catch (InputMismatchException e){ //якщо помилка трапилась, то виводимо прінт нижче
            System.err.println("Your element wasn't byte type");
        }
    }

    public static int SumWrong(int sum){ //Метод що кине в нас помилку, якщо ми ввели не правильний тип даних
        if(sum > 127 || sum <(-128)){ //якщо змінна суми виходить за межі типу даних Byte - кидаємо помилку
            throw new IllegalArgumentException("Byte type supports digits in range from -128 to 127, your is " + sum);
        }
        else {
            System.out.println("Sum of elems: " + sum); //якщо все гаразд - не кидаємо помилку і повертаємо суму
            return sum;
        }
    }
    public static int SumElems(byte[] arr){ //Блок, який сумує елементи массиву
        int sum = 0; //змінна суми
        for(int i = 0; i < arr.length; i++) { //цикл, який проводить суму елементів
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            Scanner ns = new Scanner(System.in, StandardCharsets.UTF_8); //створюємо сканер

            System.out.println("Enter length of array: ");
            byte numbers = ns.nextByte(); //встановлюємо розмір масиву

            byte[] m = new byte[numbers]; //створюємо масив з заданою кількістю елементів

            SetArray(m); //виконання методу зі створенням масиву

            SumWrong(SumElems(m)); //виконання методу з сумою елементів
        } catch (InputMismatchException e){ //кидаємо помилку в разі введення в якості кількості елементів масиву не тип Byte
            System.err.println("Input number of elements in byte format.");
        }
    }
}
