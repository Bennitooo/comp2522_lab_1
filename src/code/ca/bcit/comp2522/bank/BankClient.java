package ca.bcit.comp2522.bank;

public class BankClient
{
    private final Name name;
    private final Date birthDate;
    private final Date deathDate;
    private final Date signupDate;
    private final String clientID;

    public BankClient(final Name name, final Date birthDate, final Date deathDate, final Date signupDate, final String clientID)
    {
        validateClientID(clientID);
        
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    private static void validateClientID(final String clientID)
    {
        if (clientID.length() < 6 || clientID.length() > 7)
        {
            throw new IllegalArgumentException("The clientID isn't the right length");
        }
    }

    public BankClient(final Name name, final Date birthDate, final Date signupDate, final String clientID)
    {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    public String getDetails()
    {   
        String alive_status;
        alive_status = isAlive(deathDate);
        // return name.getFullName() + " (" + alive_status + ") was born on " + birthDate.getDayOfWeek() + ", " + birthDate.getMonth() + " " + birthDate.getDay() + ", " + birthDate.getYear() + "!";
        return name.getFullName() + " client #" + clientID + " (" + alive_status + ") joined the bank on " + signupDate.getDayOfWeek() + ", " + signupDate.getMonth() + " " + signupDate.getDay() + ", " + signupDate.getYear();
    }

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
}
