package ca.bcit.comp2522.bank;

/**
 * This class models the full name in someone's bank account
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class Name
{
    private static final int MAX_NAME_LENGTH = 45;
    private static final String FORBIDDEN_WORD = "admin";
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;
    private final String first_name;
    private final String last_name;

    /**
     * This is a constructor for the full name in someone's bank account.
     * @param first_name This is the first parameter for a first name
     * @param last_name This is the second parameter for a last name
     */
    public Name(final String first_name, final String last_name)
    {
        validateName(first_name,"First Name");
        validateName(last_name,"Last Name");
        this.first_name = first_name;
        this.last_name = last_name;

    }

    /**
     * This method validates the full name of someone's bank account.
     * It checks if the name is null or blank,
     * if the name length is greater or equal to 45,
     * and if the name contains the word "admin".
     * @param name This is the first parameter for validating a name
     * @param field_name This is the second parameter for validating a name
     */
    public void validateName(final String name, final String field_name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException(field_name
                    + " cannot be null or blank");
        }

        if (name.length() >= MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException(field_name
                    + " must be fewer than "
                    + MAX_NAME_LENGTH
                    + " characters");
        }

        if (name.toLowerCase().contains(FORBIDDEN_WORD))
        {
            throw new IllegalArgumentException(field_name
                    + " must not contain the word '"
                    + FORBIDDEN_WORD + "'");
        }

    }

    /**
     * Returns the recorded first name.
     * @return the recorded first name.
     */
    public String getFirst()
    {
        return first_name;
    }

    /**
     * Returns the recorded last name.
     * @return the recorded last name
     */
    public String getLast()
    {
        return last_name;
    }

    /**
     * Returns the initials of a person's name in their bank account.
     * @return the initials
     */
    public String getInitials()
    {
        return "Initials: " + first_name.toUpperCase().charAt(BEGIN_INDEX)
                + "."
                + last_name.toUpperCase().charAt(BEGIN_INDEX)
                + ".";
    }

    /**
     * Returns the full name.
     * @return the full name
     */
    public String getFullName()
    {
        return first_name.substring(BEGIN_INDEX, END_INDEX).toUpperCase()
                + first_name.substring(END_INDEX).toLowerCase()
                + " "
                + last_name.substring(BEGIN_INDEX, END_INDEX).toLowerCase()
                + last_name.substring(END_INDEX);
    }

    /**
     * This method returns the reverse of the person's full name.
     * @return the reverse of the person's name
     */
    public String getReverseName()
    {
        String original_string;
        StringBuilder sb;
        String reversed_str;
        original_string = first_name + " " + last_name;
        sb = new StringBuilder(original_string);
        sb.reverse();
        reversed_str = sb.toString();
        return "Reversed Name: " + reversed_str;
    }
}
