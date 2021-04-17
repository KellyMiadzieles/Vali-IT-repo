package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta, millist funktsiooni tahad kasutada: 1.min : 2.max : 3.abc : 4. isEven : 5. min3 : 6. max3");
        int num = scanner.nextInt();
        if (num == 1){
            System.out.println("Sisesta 2 täisarvu, mida tahad võrreda");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Min on: " + min(a, b));

        } else if (num == 2){
            System.out.println("Sisesta 2 täisarvu, millest soovid võrrelda");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Max on: " + max(a, b));
        } else if (num == 3) {
            System.out.println("Sisesta täisarv, millest soovid absoluutarvu");
            int a = scanner.nextInt();
            System.out.println("Sisesta number: " + abs(a));
        } else if (num == 4) {
            System.out.println("Sisesta arv, millest soovid paaris arvu ");
            int a = scanner.nextInt();
            System.out.println("Sisesta number: " + isEven(a));
        } else if (num == 5) {
            System.out.println("Sisesta arvud, millest soovid väiksemat väärtust");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("Min on: " + min3(a, b, c));
        } else if(num == 6) {
            System.out.println("Sisesta arvud, millest soovid suurimat väärtust");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("Max on: " + max3(a, b, c));
        } else {
            System.out.println("Valitud number ei olnud 1-6");
        }
    }


    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }


    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }


    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }


    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}

