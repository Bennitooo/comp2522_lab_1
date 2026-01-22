package ca.bcit.comp2522.bank;

public class Main
{
    public static void main (final String [] args)
    {
        // Name n1 = new Name("Bennett", "Lazarro");
        // System.out.println(n1.getFirst());
        BankClient b1;
        b1 = new BankClient(new Name("Bennett", "Lazarro"), new Date(2025,9,2), new Date(2025,8,2), "562355");
        System.out.println(b1.getDetails());

        BankClient b2;
        b2 = new BankClient(new Name("Abdullah", "Munawar"), new Date(2025,9,2), new Date(2025,8,2), "562355", new Date(2025,9,2));
        System.out.println(b2.getDetails());
    }
}
