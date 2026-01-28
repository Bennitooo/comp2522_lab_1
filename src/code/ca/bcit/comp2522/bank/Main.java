package ca.bcit.comp2522.bank;

/**
 * This is the main class.
 *
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class Main
{
    /**
     * This drives the program.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String [] args)
    {

        final Name n1;
        final Name n2;
        final Name n3;
        final Name n4;

        BankClient bC1;
        BankClient bC2;
        BankClient bC3;
        BankClient bC4;

        BankAccount bA1;
        BankAccount bA2;
        BankAccount bA3;
        BankAccount bA4;

        n1 = new Name("Albert", "Einstein");
        n2 = new Name("Nelson", "Mandela");
        n3 = new Name("Frida", "Kahlo");
        n4 = new Name("Jackie", "Chan");

        bC1 = new BankClient(n1,
                new Date(1879,3,14),
                new Date(1955,4,18),
                new Date(1900,1,1),
                "abc123");
        bC2 = new BankClient(n2,
                new Date(1918,7,18),
                new Date(2013,12,5),
                new Date(1994,5,10),
                "654321");
        bC3 = new BankClient(n3,
                new Date(1907,7,6),
                new Date(1954,7,13),
                new Date(1940,1,1),
                "frd123");
        bC4 = new BankClient(n4,
                new Date(1954,4,7),
                new Date(1980,10,1),
                "chan789");
        
        bA1 = new BankAccount(bC1,
                3141,
                "abc123",
                new Date(1900, 1, 1),
                new Date(1950, 10, 14),
                1000);
        bA2 = new BankAccount(bC2,
                4664,
                "654321",
                new Date(1994, 5, 10),
                null,
                2000);
        bA3 = new BankAccount(bC1,
                1907,
                "frd123",
                new Date(1940, 1, 1),
                new Date(1954, 7, 13),
                500);
        bA4 = new BankAccount(bC1,
                1954,
                "chan789",
                new Date(1980, 10, 1),
                null,
                3000);

        System.out.println(n1.getInitials() +
                "\n" +
                n1.getFullName() +
                "\n" +
                n1.getReverseName() +
                "\n" +
                bA1.getDetails() +
                "\n" +
                bC1.getDetails() +
                "\n" +
                bA1.withdraw(100, 3141) +
                "\n");
        System.out.println(n2.getInitials() +
                "\n" +
                n2.getFullName() +
                "\n" +
                n2.getReverseName() +
                "\n" +
                bA2.getDetails() +
                "\n" +
                bC2.getDetails() +
                "\n" +
                bA2.withdraw(200, 4664) +
                "\n");
        System.out.println(n3.getInitials() +
                "\n" +
                n3.getFullName() +
                "\n" +
                n3.getReverseName() +
                "\n" +
                bA3.getDetails() +
                "\n" +
                bC3.getDetails() +
                "\n" +
                bA3.withdraw(50, 1907) +
                "\n");
        System.out.println(n4.getInitials() +
                "\n" +
                n4.getFullName() +
                "\n" +
                n4.getReverseName() +
                "\n" +
                bA4.getDetails() +
                "\n" +
                bC4.getDetails() +
                "\n" +
                bA4.withdraw(500, 1954) +
                "\n");
    }
}
