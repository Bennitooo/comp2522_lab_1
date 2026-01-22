package ca.bcit.comp2522.bank;

/**
 * This class models the clients of a bank
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class BankClient
{

    private static final int MIN_CLIENT_ID_LENGTH = 6;
    private static final int MAX_CLIENT_ID_LENGTH = 7;

    private final Name name;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    /**
     * This is a constructor for the clients of a bank.
     * @param name This is the first parameter for a name
     * @param birthDate This is the second parameter for a birthdate
     * @param deathDate This is the third parameter for a death date
     * @param signupDate This is the fourth parameter for a signup date
     * @param clientID This is the fifth parameter for a client id
     */
    public BankClient(final Name name, final Date birthDate, final Date deathDate, final Date signupDate, final String clientID)
    {
        validateClientID(clientID);
        
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /**
     * This is an overloading constructor for the clients of a bank who have not died.
     * @param name This is the first parameter for a name
     * @param birthDate This is the second parameter for a birthdate
     * @param signupDate This is the fourth parameter for a signup date
     * @param clientID This is the fifth parameter for a client id
     */
    public BankClient(final Name name, final Date birthDate, final Date signupDate, final String clientID)
    {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /**
     * This is a private validator method to check if the client id has 6 or 7 characters
     * @param clientID This is the parameter for a client id
     */
    private static void validateClientID(final String clientID)
    {
        if (clientID.length() < MIN_CLIENT_ID_LENGTH || clientID.length() > MAX_CLIENT_ID_LENGTH)
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
        String alive_status;
        alive_status = isAlive(deathDate);
        // return name.getFullName() + " (" + alive_status + ") was born on " + birthDate.getDayOfWeek() + ", " + birthDate.getMonth() + " " + birthDate.getDay() + ", " + birthDate.getYear() + "!";
        return name.getFullName() + " client #" + clientID + " (" + alive_status + ") joined the bank on " + signupDate.getDayOfWeek() + ", " + signupDate.getMonth() + " " + signupDate.getDay() + ", " + signupDate.getYear();
    }

    /**
     * Returns whether the bank client is alive or has died.
     * If the death date attribute for the client is null, then they are alive
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
     * Returns name.
     * @return name
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Returns birthdate.
     * @return birthdate.
     */
    public Date getBirthDate()
    {
        return birthDate;
    }

    /**
     * Returns death date.
     * @return death date
     */
    public Date getDeathDate()
    {
        return deathDate;
    }

    /**
     * Returns signup date
     * @return sign up date
     */
    public Date getSignupDate()
    {
        return signupDate;
    }

    /**
     * Returns client ID.
     * @return client ID
     */
    public String getClientID()
    {
        return clientID;
    }
}
