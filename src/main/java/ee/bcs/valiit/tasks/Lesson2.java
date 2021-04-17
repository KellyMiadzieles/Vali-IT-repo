package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        //multiplyTable(5,5);
        //System.out.println(fibonacci(1));
        //System.out.println(evenNumbers(8));
        //System.out.println(min(0));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int arrayLength = inputArray.length;
        int[] newArray = new int[arrayLength];
        for (int i = arrayLength; i > 0; i--) {
            newArray[i - 1] = inputArray[arrayLength - i];
        }
        return newArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) { //evenNumbers on funktsiooni nimi
        int[] returnArray = new int[n]; //Arrayde puhul on vaja new int
        for (int i = 0; i < n; i++) {
            returnArray[i] = (i + 1) * 2;
        }
        return returnArray;
    }

    // int index = 0;
    // int number = 2;
    //while(index < n) {
    //returnArray[index] = number;
    //index++;
    //number = number + 2;
    //}


    // TODO, leia massiivi kõige väiksem element
    // kaks numbrit võrdlen oma vahel, leian kõige väiksema, kas 3 nr on väiksem teistest kahest
    //int[] on tüüp (ehk massiiv) x.length on nimetus, võib panna ka arrayNimi.length x-i asemel
    // i = 1 peab olema väiksem number (0 pole mõtet võrrelda iseendaga)
    // x on nagu 1,2,3,4,5, x[0] tähendab et x võtab 0 elemendi
    public static int min(int[] array) { // 4,2,6,1,9
        int minElement = array[0]; // 0 sest peab olema number millega võrrelda // min element = 4
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        return minElement;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int maxElement = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > maxElement) {
                maxElement = x[i];
            }
        }
        return maxElement;
    }

    // TODO, leia massiivi kõigi elementide summa
    // liita elemendid kokku
    // int[] input = (2, 4, 5, -2, -1);
    public static int sum(int[] x) {
        //first sum is array [x] 0 element
        int sum = x[0];
        // how many elements in array;
        int elements = x.length;
        // loop x element times
        for (int i = 1; i < elements; i++) {
            //new sum is old sum + new array int
            sum = sum + x[i];
        }

        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                System.out.print(j * i + " ");
            }
            System.out.println();
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        int n1 = 0; //üle eelmine nr
        int n2 = 1; // eelmine nr
        int nth = 2; // n-is elemes, praegune nr
        for (int i = 2; i <= n; i++) {
            nth = n1 + n2;
            n1 = n2;
            n2 = nth;
        }
        return nth;
    }


    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    // tehke tsükkel x -> y
    // kutsuge iga väärtuse korral välja meetodit getSeqLength
    // salvestage maha kõige suurem ja funktsiooni lõpus tagastage see
    public static int sequence3n(int x, int y) {
        int max = 0;
        for (int i = x; i <= y; i++) {
            if (getSeqLength(i) > max) {
                max = getSeqLength(i);
            }
        }
        return max;
    }

    public static int getSeqLength(int x) {
        int sequence = 1; //sequence mitmenda numbriga tegu
        while (x > 1) {
            x = nextElement(x); // x-iga tähistame jada väärtust (milline number parasjagu on)
            sequence++;
        }
        return sequence;
    }

    public static int nextElement(int x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return x * 3 + 1;
        }
    }

    public static int sequence3n(int a) {
        return 0;
    }
}








