package ca.bcit.comp2522.bank;

public class BankAccount
{
    private static final int MIN_ACCOUNT_NUMBER_LENGTH = 6;
    private static final int MAX_ACCOUNT_NUMBER_LENGTH = 7;

    private final BankClient client;
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;
    private double balanceUsd;

    public BankAccount(final BankClient client, final String accountNumber, final Date accountOpened,
                       final Date accountClosed, final double initialBalanceUsd)
    {
        validateAccountNumber(accountNumber);

        this.client = client;
        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.balanceUsd = initialBalanceUsd;
    }

    private static void validateAccountNumber(final String accountNumber)
    {
        if (accountNumber == null)
        {
            throw new IllegalArgumentException("Account number cannot be null");
        }

        int length = accountNumber.length();
        if (length != MIN_ACCOUNT_NUMBER_LENGTH && length != MAX_ACCOUNT_NUMBER_LENGTH)
        {
            throw new IllegalArgumentException("Account number must be 6 or 7 characters");
        }
    }

    public void withdraw(final double amountUsd)
    {

    }
    public void withdraw(final double amountUsd, final int pinToMatch)
    {

    }
}
