package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {
    public static void main(String[] args) {
        //exercise1(1);
        //System.out.println(Arrays.toString(decreasingArray(6)));

        //System.out.println(Arrays.toString(sampleArray()));
    }

    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static void exercise1(int n) {
        int i = 0;
        while (i <= n) {
            i++;
            System.out.println(i);
        }
    }
    /* for(int i = 1; i <= n; i++) {
    System.out.println(n);
    }

     */

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        return new int[]{1, 2, 3, 4, 5}; // annaks mälu ning mida oleks vaja tagastada
    }

    //        int[] array = new int[5]; (määrasin rea pikkuseks 5)
    //        for(int i = 0; i < array.length; i++) {
    //            array[i] = i+1;
    //        }
    //        return array;


    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int[n]; //n on number (muutuja nimi) (n = selle suurusega rida, nt 5, 87)
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        if (n >= 0) {
            int[] array = new int[n + 1];
            for (int i = n; i >= 0; i--) {
                array[n - i] = i;
            }
            return array;
        } else {
            int[] array = new int[n * (-1) + 1];
            int i = n;
            while (i <= 0) {
                array[n * (-1) + i] = i;
                i++;
            }
            return array;
        }
    }


    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = 3;
        }
        return array;
    }
}
