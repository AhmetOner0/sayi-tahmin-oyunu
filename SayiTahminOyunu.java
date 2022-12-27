package patikadev;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class SayiTahminOyunu {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int number = (int) (Math.random() * 100);
        System.out.println(number);
        int selected;
        int right = 0;
        int[] wrong=new int[5];
        boolean isWin=false;
        boolean isWrong=false;

        while (right < 5) {
            System.out.println("tahmininizi giriniz: ");
            selected = inp.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("lütfen 0-100 arası sayı giriniz!");
                if (isWrong){
                    right++;
                    System.out.println("çok fazla hatalı giriş yaptınız!");
                    System.out.println("kalan hakkınız: "+ (5-right));
                }else {
                    isWrong=true;
                    System.out.println("tekrar hatalı sayı girerseniz hakkınızdan düşürülecektir!");
                }
                continue;
            }
            if (selected == number){
                System.out.println("tebrikler, doğru tahmin!!");
                isWin=true;
                break;
            }else
                //right++;
            wrong[right++]=selected;
            System.out.println("hatalı sayı girdiniz!");
            if (selected < number){
                    System.out.println(selected + " sayısı gizli sayıdan küçük");
                    System.out.println("kalan hakkınız: "+ (5-right));
                }
                else {
                    System.out.println(selected + " sayısı gizli sayıdan büyüktür");
                    System.out.println("kalan hakkınız: "+ (5-right));
                }
        }

        if (!isWin){
            System.out.println("kaybettiniz!");
            if (!isWrong){
                System.out.println("tahminleriniz: "+Arrays.toString(wrong));
            }
        }
    }
}
