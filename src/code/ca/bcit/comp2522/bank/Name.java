package ca.bcit.comp2522.bank;

/**
 * This class models the full name in someone's bank account.
 *
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class Name
{
    private static final int    MAX_NAME_LENGTH = 99;
    private static final String FORBIDDEN_WORD  = "jason";
    private static final int    BEGIN_INDEX     = 0;
    private static final int    END_INDEX       = 1;

    private final String firstName;
    private final String lastName;

    /**
     * This is a constructor for the full name in someone's bank account.
     *
     * @param firstName This is the first name
     * @param lastName  This is the last name
     */
    public Name(final String firstName,
                final String lastName)
    {
        validateName(firstName,"First Name");
        validateName(lastName,"Last Name");

        this.firstName = firstName;
        this.lastName  = lastName;

    }

    /**
     * This method validates the full name of someone's bank account.
     * It checks if the name is null or blank,
     * if the name length is greater or equal to 45,
     * and if the name contains the word "admin".
     *
     * @param name      This is the name to validate
     * @param fieldName This is the type of name it is (either First Name or Last Name)
     */
    private static void validateName(final String name,
                                    final String fieldName)
    {
        if (name == null ||
            name.isBlank())
        {
            throw new IllegalArgumentException(fieldName +
                    " cannot be null or blank");
        }

        if (name.length() >= MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException(fieldName +
                    " must be fewer than " +
                    MAX_NAME_LENGTH +
                    " characters");
        }

        if (name.toLowerCase().contains(FORBIDDEN_WORD))
        {
            throw new IllegalArgumentException(fieldName +
                    " must not contain the word '" +
                    FORBIDDEN_WORD + "'");
        }

    }

    /**
     * Returns the recorded first name.
     *
     * @return the recorded first name.
     */
    public String getFirst()
    {
        return firstName;
    }

    /**
     * Returns the recorded last name.
     *
     * @return the recorded last name
     */
    public String getLast()
    {
        return lastName;
    }

    /**
     * Returns the initials of a person's name in their bank account.
     *
     * @return the initials
     */
    public String getInitials()
    {
        return "Initials: " +
                firstName.toUpperCase().charAt(BEGIN_INDEX) +
                "." +
                lastName.toUpperCase().charAt(BEGIN_INDEX) +
                ".";
    }

    /**
     * Returns the full name.
     *
     * @return the full name
     */
    public String getFullName()
    {
        return firstName.substring(BEGIN_INDEX, END_INDEX).toUpperCase() +
                firstName.substring(END_INDEX).toLowerCase() +
                " " +
                lastName.substring(BEGIN_INDEX, END_INDEX).toUpperCase() +
                lastName.substring(END_INDEX).toLowerCase();
    }

    /**
     * This method returns the reverse of the person's full name.
     *
     * @return the reverse of the person's name
     */
    public String getReverseName()
    {
        final String        originalString;
        final StringBuilder stringBuilder;
        final String        reversedString;

        originalString = firstName + " " + lastName;
        stringBuilder  = new StringBuilder(originalString);
        
        stringBuilder.reverse();
        
        reversedString = stringBuilder.toString();
        
        return "Reversed Name: " + reversedString;
    }
}
