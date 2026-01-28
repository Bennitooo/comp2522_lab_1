package ca.bcit.comp2522.bank;

/**
 * This class models the accounts of a bank.
 *
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class BankAccount
{
    private static final int ZERO_BALANCE              = 0;
    private static final int MIN_ACCOUNT_NUMBER_LENGTH = 6;
    private static final int MAX_ACCOUNT_NUMBER_LENGTH = 7;
    private static final int MIN_PIN_NUMBER_LENGTH     = 1000;
    private static final int MAX_PIN_NUMBER_LENGTH     = 9999;


    private final BankClient client;
    private final int        pin;
    private final String     accountNumber;
    private final Date       accountOpened;
    private final Date       accountClosed;
    private       double     balanceUsd;

    /**
     * This is a private validator to check if the client's pin.
     *
     * @param pin This is the client's pin
     */
    private static void validatePin(final int pin)
    {
        if (pin < MIN_PIN_NUMBER_LENGTH ||
            pin > MAX_PIN_NUMBER_LENGTH)
        {
            throw new IllegalArgumentException("Pin number must be 4 digits long");
        }
    }

    /**
     * This is a constructor for the client's Bank Account information.
     *
     * @param client This is the client taken from the BankClient class
     * @param accountNumber Client's account number
     * @param accountOpened When the account opened
     * @param accountClosed When the account closed (can be null)
     * @param initialBalanceUsd This is the account's initial balance in USD
     */
    public BankAccount(final BankClient client,
                       final int pin,
                       final String accountNumber,
                       final Date accountOpened,
                       final Date accountClosed,
                       final double initialBalanceUsd)
    {
        validateClient(client);
        validatePin(pin);
        validateAccountNumber(accountNumber);
        validateAccountOpened(accountOpened);
        validateInitialBalanceUsd(initialBalanceUsd);

        this.client        = client;
        this.pin           = pin;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.balanceUsd    = initialBalanceUsd;
    }

    /**
     * This is a private validator to chick if the client is null or not.
     *
     * @param client Client taken from the client class
     */
    private static void validateClient(final BankClient client)
    {
        if (client == null)
        {
            throw new IllegalArgumentException("Client cannot be null");
        }
    }

    /**
     * This is a private validator to check if the account number has 6 or 7 characters.
     *
     * @param accountNumber Client's account number
     */
    private static void validateAccountNumber(final String accountNumber)
    {
        if (accountNumber == null)
        {
            throw new IllegalArgumentException("Account number cannot be null");
        }

        final int length = accountNumber.length();
        if (length != MIN_ACCOUNT_NUMBER_LENGTH &&
            length != MAX_ACCOUNT_NUMBER_LENGTH)
        {
            throw new IllegalArgumentException("Account number must be 6 or 7 characters");
        }
    }

    /**
     * This is a private validator to check if the initial balance
     * is less than $0.
     *
     * @param initialBalanceUsd The initial amount of money in the bank account
     */
    private static void validateInitialBalanceUsd(final double initialBalanceUsd)
    {
        if (initialBalanceUsd < ZERO_BALANCE)
        {
            throw new IllegalArgumentException("Initial balance cannot be less than $0");
        }
    }

    /**
     * This is a private validator to check if the account opened.
     *
     * @param accountOpened When the account opened
     */
    private static void validateAccountOpened(final Date accountOpened)
    {
        if (accountOpened == null)
        {
            throw new IllegalArgumentException("Account opened cannot be null");
        }
    }

    /**
     * This is method to withdraw from a bank account.
     *
     * @param amountUsd This is how much you want to withdraw
     * @return How much money was withdrawn and the balance after withdrawing
     */
    public String withdraw(final double amountUsd)
    {
        if (amountUsd <= balanceUsd &&
            amountUsd > ZERO_BALANCE)
        {
            balanceUsd -= amountUsd;
            return "Withdrew: $" +
                    amountUsd +
                    " USD" +
                    "\nCurrent balance: $" +
                    balanceUsd +
                    " USD";
        }

        return "";
    }

    /**
     * This is an overloading method for the clients who have a pin to match with the account's pin
     *
     * @param amountUsd  This is how much you want withdraw
     * @param pinToMatch Pin to match with the account pin
     * @return Either the first withdraw method or an empty string
     */
    public String withdraw(final double amountUsd,
                           final int pinToMatch)
    {
       if (pinToMatch == this.pin)
       {
           return withdraw(amountUsd);
       }
       return "";
    }

    /**
     * Returns the details of a bank account
     * It returns an empty string if their account is still open.
     * If not it returns when their account closed, how much money
     * is in their account to begin with, and when they opened their
     * account.
     *
     * @return the details of a bank account
     */
    public String getDetails()
    {
        final String closedInfo;
        final String result;

        if (accountClosed == null)
        {
            closedInfo = "";
        }
        else
        {
            closedInfo = " and closed " +
                    accountClosed.getDayOfWeek() + " " +
                    accountClosed.getMonth() + " " +
                    accountClosed.getDay() + " " +
                    accountClosed.getYear();
        }

        result = client.getName().getFullName() + " had $" +
                balanceUsd + " USD in account #" +
                accountNumber + " which they opened on " +
                accountOpened.getDayOfWeek() + " " +
                accountOpened.getMonth() + " " +
                accountOpened.getDay() + ", " +
                accountOpened.getYear() +
                closedInfo + ".";

        return result;
    }
}

