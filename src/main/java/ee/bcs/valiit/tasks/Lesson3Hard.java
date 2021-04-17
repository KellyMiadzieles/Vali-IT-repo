package ee.bcs.valiit.tasks;

import javax.servlet.ServletOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("Arva numbrit 0 - 99");
            int guess = scanner.nextInt();
            count++; //väljas pool põhitsüklit on count
            if (guess > randomNumber) {
                System.out.println("Number on väiksem");
            } else if (guess < randomNumber) {
                System.out.println("Number on suurem");
            } else {
                System.out.println("Arvasid ära. Sul läks " + count + "korda.");
                System.out.println("Kas sa tahad uesti mängida 1 - jah, 0 - ei");
                int uuesti = scanner.nextInt();
                if (uuesti == 1) {
                    randomNumber = random.nextInt(100);
                    count = 0;
                } else {
                    break;
                }
            }
        }
    }
}

