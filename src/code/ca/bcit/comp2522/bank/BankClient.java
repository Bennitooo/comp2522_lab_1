package ca.bcit.comp2522.bank;

/**
 * This class models the clients of a bank.
 *
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class BankClient
{
    private static final int MIN_CLIENT_ID_LENGTH = 6;
    private static final int MAX_CLIENT_ID_LENGTH = 7;

    private final Name   name;
    private final Date   birthDate;
    private final Date   deathDate;
    private final Date   signupDate;
    private final String clientID;

    /**
     * This is an overloading constructor for the clients of a bank who have not died.
     *
     * @param name       This is the name of the bank client
     * @param birthDate  This is the date of birth of the client
     * @param signupDate This is when the client opened the account
     * @param deathDate  This is the date of death of the client
     * @param clientID   This is the client's ID
     */
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date signupDate,
                      final Date deathDate,
                      final String clientID)
    {
        validateClientID(clientID);
        
        this.name       = name;
        this.birthDate  = birthDate;
        this.signupDate = signupDate;
        this.clientID   = clientID;
        this.deathDate  = deathDate;
    }

    /**
     * This is an overloading constructor for the clients of a bank who have not died.
     * @param name       This is the name of the bank client
     * @param birthDate  This is the date of birth of the client
     * @param signupDate This is when the client opened the account
     * @param clientID   This is the client's ID
     */
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date signupDate,
                      final String clientID)
    {
        validateClientID(clientID);

        this.name       = name;
        this.birthDate  = birthDate;
        this.signupDate = signupDate;
        this.clientID   = clientID;
        this.deathDate  = null;
    }

    /**
     * This is a private validator method to check if the client id has 6 or 7 characters
     * @param clientID This is the parameter for a client id
     */
    private static void validateClientID(final String clientID)
    {
        if (clientID.length() < MIN_CLIENT_ID_LENGTH ||
            clientID.length() > MAX_CLIENT_ID_LENGTH)
        {
            throw new IllegalArgumentException("The clientID isn't the right length");
        }
    }

    /**
     * Returns the details of a bank client.
     * It returns their full name, client id, alive status, and when they joined the bank
     * @return the details of a bank client
     */
    public String getDetails()
    {   
        final String aliveStatus;

        aliveStatus = isAlive(deathDate);
        // return name.getFullName() + " (" + aliveStatus + ") was born on " + birthDate.getDayOfWeek() + ", " + birthDate.getMonth() + " " + birthDate.getDay() + ", " + birthDate.getYear() + "!";
        return name.getFullName() +
                " client #" +
                clientID +
                " (" +
                aliveStatus +
                ") joined the bank on " +
                signupDate.getDayOfWeek() +
                ", " +
                signupDate.getMonth() +
                " " +
                signupDate.getDay() +
                ", " +
                signupDate.getYear();
    }

    /**
     * Returns whether the bank client is alive or has died.
     * If the death date attribute for the client is null, then they are alive.
     *
     * @return whether the bank client is alive or has died
     */
    private static String isAlive(final Date deathDate)
    {
        if (deathDate == null)
        {
            return "alive";
        }
        else
        {
            // return "died " + deathDate.getDayOfWeek() + ", " + deathDate.getMonth() + " " + deathDate.getDay() + ", " + deathDate.getYear();
            return "not alive";
        }
    }

    /**
     * Returns the name of the bank client.
     *
     * @return the name of the bank client
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Returns the birthdate of the bank client.
     *
     * @return the birthdate of the bank client
     */
    public Date getBirthDate()
    {
        return birthDate;
    }

    /**
     * Returns the death date of the bank client.
     * @return the death date of the bank client
     */
    public Date getDeathDate()
    {
        return deathDate;
    }

    /**
     * Returns the signup date of the bank client.
     * @return the signup date of the bank client
     */
    public Date getSignupDate()
    {
        return signupDate;
    }

    /**
     * Returns the client ID of the bank client.
     * @return the client ID of the bank client
     */
    public String getClientID()
    {
        return clientID;
    }
}
