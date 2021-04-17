package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Lesson3 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(sort(new int[]{5, 2, 7, 3, 4})));
        //System.out.println(evenFibonacci(2));
        //System.out.println(factorial(5));
        //System.out.println(morseCode("hello"));
        //System.out.println(reverseString("Kelly"));
    }


    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) { // x parameetri nimetus // factorial meetodi nimetus
        int factorial = x;
        for (int i = 1; i < x; i++) {
            factorial = factorial * i; // factorial *= i;
        }
        return factorial;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String reversedString = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            reversedString += a.charAt(i);
        }
        return reversedString;
    }


    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    // TODO sorteeri massiiv suuruse järgi. //väiksemast suuremaks// TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
            // 2 9 1 7
            // 2 1 7 9
            // 1 2 7 9
            for(int j = 1; j < a.length; j++) {
                for (int i = 1; i < a.length; i++) {
                    if (a[i - 1] > a[i]) {
                        int tmp = a[i];
                        a[i] = a[i - 1];
                        a[i - 1] = tmp;
                    }
                }
            }
            return a;
        }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x // nt kui vastus on 10 (siis 2+8)
        int n1 = 0;  //defineerin muutuja üks, mis esindab jadas n(n-1)
        int n2 = 1;  // defineerin muutuja kaks, mis eindab jadas b(n-2)
        int nthEven = 0;
        if (x == 0) {
            return x; //tagasta null, juhul, kui x on null
        }
        while (n1 + n2 <= x) {
            int sum = n1 + n2; //leian n1 ja n2 summa
            n1 = n2; // n1 panen n2 väärtuse
            n2 = sum; // nth väärtuseks saab n2
            if (n2 % 2 == 0) {
                nthEven += n2;
            }
        }
        return nthEven;
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        Map<String, String> morseCode = new HashMap<>();
        morseCode.put("s", "...");
        morseCode.put("o", "---");
        morseCode.put("h", "....");
        morseCode.put("e", ".");
        morseCode.put("l", ".-..");

        //assertEquals(".... . .-.. .-.. ---", Lesson3.morseCode("hello"));
        //        assertEquals("... --- ...", Lesson3.morseCode("sos"));

        String morsetõlge = ""; //muutuja kuhu sisse me ehitame morse stringi kokku
        for (int i = 0; i < text.length(); i++) {
            String l = text.substring(i, i + 1);
            morsetõlge += morseCode.get(l) + " ";
        }
        return morsetõlge.trim(); //muutuja trim
    }
}
