package ee.bcs.valiit.tasks;

import ee.bcs.valiit.klassid.Account;

import javax.servlet.ServletOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    //HashMap<String, Account> accountBalanceMap = new HashMap<>();

    public static HashMap<String, Double> accountBalanceMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Insert command");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            } else if (line.equalsIgnoreCase("createAccount")) {
                // TODO 1
                // Add command: "createAccount ${accountNr}"
                // this has to store accountNr with 0 balance
                System.out.println("Please enter account number");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter initial balance");
                Double balance = scanner.nextDouble();
                scanner.nextLine();
                accountBalanceMap.put(accountNr, balance);
            } else if (line.equalsIgnoreCase("getBalance")) {
                // TODO 2
                // Add command: "getBalance ${accountNr}"
                // this has to display account balance of specific account
                System.out.println("Please enter account number");
                String accountNr = scanner.nextLine();
                System.out.println("Your account balance is: " + accountBalanceMap.get(accountNr));
            } else if (line.equalsIgnoreCase(("depositMoney"))) {
                // TODO 3
                // Add command: "depositMoney ${accountNr} ${amount}
                // this has to add specified amount of money to account
                // You have to check that amount is positive number
                System.out.println("Please enter account nr");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter amount");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    Double currentBalance = accountBalanceMap.get(accountNr);
                    Double newBalance = currentBalance + amount;
                    accountBalanceMap.put(accountNr, newBalance);
                } else {
                    System.out.println("Sisestatud summa peab olema positiivne number");
                }
            } else if (line.equalsIgnoreCase("withdrawMoney")) {
                // TODO 4
                // Add command: "withdrawMoney ${accountNr} ${amount}
                // This has to remove specified amount of money from account
                // You have to check that amount is positive number
                // You may not allow this transaction if account balance would become negative
                System.out.println("Please enter account nr");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter amount");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    Double currentBalance = accountBalanceMap.get(accountNr);
                    Double newBalance = currentBalance - amount;
                    if (newBalance >= 0) {
                        accountBalanceMap.put(accountNr, newBalance);
                    } else {
                        System.out.println("Kontol pole piisavalt raha");
                    }
                } else {
                    System.out.println("Sisestatud summa peab olema positiivne number");
                }
            } else if (line.equalsIgnoreCase("transferMoney")) {
                // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                // This has to remove specified amount from fromAccount and add it to toAccount
                // Your application needs to check that toAccount is positive
                // And from account has enough money to do that transaction
                System.out.println("Please enter from account nr");
                String fromAccountNr = scanner.nextLine();
                System.out.println("Please enter to account nr");
                String toAccountNr = scanner.nextLine();
                System.out.println("Please enter amount");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    double fromAccountBalance = accountBalanceMap.get(fromAccountNr);
                    if (fromAccountBalance < amount) {
                        System.out.println("Kontol pole piisavalt raha");
                    } else {
                        double toAccountBalance = accountBalanceMap.get(toAccountNr);
                        accountBalanceMap.put(fromAccountNr, fromAccountBalance - amount);
                        accountBalanceMap.put(toAccountNr, toAccountBalance + amount);
                    }
                    // TODO 5
                    // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                    // This has to remove specified amount from fromAccount and add it to toAccount
                    // Your application needs to check that toAccount is positive
                    // And from account has enough money to do that transaction
                } else {
                    System.out.println("Summa peab olema positiivne number");
                }
            }
        }
    }
}

// TODO 1
// Add command: "createAccount ${accountNr}"
// this has to store accountNr with 0 balance
            /*if (kasutajasisend.equals("createAccount")) {
                String suvalineKontonumber = "EE44";
                String nimi = "Kelly";
                double j????k = 139.2;
                Account suvalineAccount = new Account(nimi, j????k);

                String teinesuvalineKontonumber = "EE22";
                String teinenimi = "Pille";
                double teinej????k = 1.2;
                Account teinesuvalineAccount = new Account(teinenimi, teinej????k);

                accountBalanceMap.put(suvalineKontonumber, suvalineAccount);
            }


            if (kasutajasisend.startsWith("createAccount ")) { //kontrollin kasutaja sisendit, kas kasutajasisend algab createAccount-iga
                String esimeneLahendusKontoNr = kasutajasisend.replace("createAccount ", ""); //saame konto nr asendades kasutajasisendis olevat createAccounti t??hja Stringiga
                System.out.println(esimeneLahendusKontoNr);
                //String teineLahendusKontoNr = kasutajasisend.substring("createAccount ".length());
                //System.out.println(teineLahendusKontoNr);
                String tundmatuNimi = "tundmatu";
                double kontoJ????k = 0.0;
                Account algKonto = new Account(tundmatuNimi, kontoJ????k);
                System.out.println("Loodi uus konto nimega " + tundmatuNimi + ", mille kontoj????k " + kontoJ????k);
                accountBalanceMap.put(esimeneLahendusKontoNr, algKonto);
                System.out.println(accountBalanceMap.size());

            }

            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific account
            if (kasutajasisend.startsWith("getBalance ")) {
                String kontoNr = kasutajasisend.replace("getBalance ", "");
                Account k??situdKonto = accountBalanceMap.get(kontoNr);
                System.out.println(k??situdKonto.balance);
            }
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            if (kasutajasisend.startsWith("depositMoney ")) {
                String kontoNrJaAmount = kasutajasisend.replace("depositMoney ", "");
                int t??hikuIndex = kontoNrJaAmount.indexOf(" ");
                String kontoNr = kontoNrJaAmount.substring(0, t??hikuIndex); // kontonr eraldi (otsisin kontonr)
                String amount = kontoNrJaAmount.substring(t??hikuIndex, kontoNrJaAmount.length()); // amount eraldi (otsisin konto amounti)
                Account kontoMilleleRahaLisatakse = accountBalanceMap.get(kontoNr);
                if (Integer.parseInt(amount) > 0) {
                    double uusKontoJ????k = kontoMilleleRahaLisatakse.balance + Integer.parseInt(amount);
                    kontoMilleleRahaLisatakse.balance = uusKontoJ????k;
                } else {
                    System.out.println("You can only deposit positive amount");
                }
                System.out.println(kontoNrJaAmount);
            }
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            if (kasutajasisend.startsWith("withdrawMoney ")) {
                String kontoNrJaAmount = kasutajasisend.replace("withdrawMoney", "");
                int t??hikuIndex = kontoNrJaAmount.indexOf(" ");
                String kontoNr = kontoNrJaAmount.substring(0, t??hikuIndex);
                String amount = kontoNrJaAmount.substring(t??hikuIndex, kontoNrJaAmount.length());
                Account kontoMilleltRahaV??etakse = accountBalanceMap.get(kontoNr);
                if (Integer.parseInt(amount) > 0) {
                    double uusKontoJ????k = kontoMilleltRahaV??etakse.balance - Integer.parseInt(amount);
                    if (uusKontoJ????k >= 0) {
                        kontoMilleltRahaV??etakse.balance = uusKontoJ????k;
                    }
                } else {
                    System.out.println("You can only deposit positive amount");
                }
            }
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction
            if (kasutajasisend.startsWith("transfer")) {
                String fromAccountToAccountJaAmount = kasutajasisend.replace("transfer ", "");
                int esimeseT??hikuIndex = fromAccountToAccountJaAmount.indexOf(" ");
                String fromAccountKontoNr = fromAccountToAccountJaAmount.substring(0, esimeseT??hikuIndex);
                int teiseT??hikuIndex = fromAccountToAccountJaAmount.lastIndexOf(" ");
                String toAccountKontoNr = fromAccountToAccountJaAmount.substring(esimeseT??hikuIndex, teiseT??hikuIndex);
                String amount = fromAccountToAccountJaAmount.substring(teiseT??hikuIndex, fromAccountToAccountJaAmount.length());
                Account kontoMilleltRahaV??etakse = accountBalanceMap.get(fromAccountKontoNr); //olemas konto millelt raha v??etakse
                Account kontoMilleleRahaL??heb = accountBalanceMap.get(toAccountKontoNr);
                double amountDoubleKujul = Double.parseDouble(amount);
                if (amountDoubleKujul < kontoMilleltRahaV??etakse.balance) {
                    double uusKontoJ????k = kontoMilleltRahaV??etakse.balance - amountDoubleKujul;
                    kontoMilleltRahaV??etakse.balance = uusKontoJ????k;
                    double teiseKontoUusJ????k = kontoMilleleRahaL??heb.balance + amountDoubleKujul;
                    kontoMilleleRahaL??heb.balance = teiseKontoUusJ????k;
                } else {
                    System.out.println("Tehing eba??nnestus. Kontol pole piisavalt raha");
                }
            } else {
                System.out.println("Unknown command");

            }

        }

             */






