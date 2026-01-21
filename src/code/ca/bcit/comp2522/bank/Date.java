package ca.bcit.comp2522.bank;

/**
 * This class models the opening and closing dates of someone's bank account
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 * @version 1.0
 */
public class Date
{
    private static final int MINIMUM_YEAR = 1800;
    private static final int CURRENT_YEAR = 2026;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int DAY_ONE = 1;
    private static final int DAY_TWENTY_EIGHT = 28;
    private static final int DAY_TWENTY_NINE = 29;
    private static final int DAY_THIRTY = 30;
    private static final int DAY_THIRTY_ONE = 31;
    private static final int DIVIDE_BY_FOUR = 4;
    private static final int DIVIDE_BY_ONE_HUNDRED = 100;
    private static final int DIVIDE_BY_FOUR_HUNDRED = 400;
    private static final int DIVISIBLE = 0;
    private static final int MINIMUM_TEN = 10;

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private static final int EIGHTEEN_HUNDREDS = 1800;
    private static final int NINETEEN_HUNDREDS = 1900;
    private static final int TWO_THOUSANDS = 2000;
    private static final int CENTURY_DIVISOR = 100;
    private static final int ADD_SIX = 6;
    private static final int ADD_TWO = 2;
    private static final int NUM_OF_TWELVES = 12;
    private static final int NUM_OF_FOURS = 4;
    private static final int BASE_VALUE = 0;

    private static final int CODE_ZERO = 0;
    private static final int CODE_ONE = 1;
    private static final int CODE_TWO = 2;
    private static final int CODE_THREE = 3;
    private static final int CODE_FOUR = 4;
    private static final int CODE_FIVE = 5;
    private static final int CODE_SIX = 6;
    private static final int DAYS_IN_WEEK = 7;

    private final int year;
    private final int month;
    private final int day;

    /**
     * This is a constructor for the opening and closing dates in someone's bank account.
     * @param year This is the first parameter for a year
     * @param month This is the second parameter for a month
     * @param day This is the third parameter for a day
     */
    public Date(final int year, final int month, final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day, month, year);

        this.year = year;
        this.month = month;
        this.day = day;
    }
    /**
     * This is a private validator method to check if the year is either:
     * 1) less than MINIMUM_YEAR (1800), OR
     * 2) greater than CURRENT_YEAR (2006)
     * @param year This is the parameter for a year
     */
    private static void validateYear(final int year)
    {
        if (year < MINIMUM_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year is out of range");
        }
    }

    /**
     * This is a private validator method to check if the month,
     * represented as an int, less than 1 (JANUARY) OR greater than 12 (DECEMBER).
     * @param month This is the parameter for a month
     */
    private static void validateMonth(final int month)
    {
        if (month < JANUARY || month > DECEMBER)
        {
            throw new IllegalArgumentException("Month is out of range");
        }
    }
    /**
     * This is a private validator method to check if the day is within
     * the valid range for the specific month and year.
     * @param day The day of the month to validate
     * @param month The month value
     * @param year The year value
     */
    private static void validateDay(final int day, final int month, final int year)
    {
        if (day < DAY_ONE)
        {
            throw new IllegalArgumentException("Day is out of range");
        }

        if (month == JANUARY || month == MARCH || month == MAY || month == JULY || month == AUGUST || month == OCTOBER || month == DECEMBER)
        {
            if (day > DAY_THIRTY_ONE)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER)
        {
            if (day > DAY_THIRTY)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else
        {
            if (year % DIVIDE_BY_FOUR == DIVISIBLE && year % DIVIDE_BY_ONE_HUNDRED != DIVISIBLE)
            {
                if (day > DAY_TWENTY_NINE)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
            else if (year % DIVIDE_BY_FOUR_HUNDRED == DIVISIBLE)
            {
                if (day > DAY_TWENTY_NINE)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
            else
            {
                if (day > DAY_TWENTY_EIGHT)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
        }
    }

    /**
     * Returns the date's day.
     * @return the date's day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the date's month.
     * @return the date's month
     */
    public String getMonth()
    {
        switch(month)
        {
            case JANUARY:
                return "January";
            case FEBRUARY:
                return "February";
            case MARCH:
                return "March";
            case APRIL:
                return "April";
            case MAY:
                return "May";
            case JUNE:
                return "June";
            case JULY:
                return "July";
            case AUGUST:
                return "August";
            case SEPTEMBER:
                return "September";
            case OCTOBER:
                return "October";
            case NOVEMBER:
                return "November";
            case DECEMBER:
                return "December";
            default:
                throw new IllegalStateException("An error occurred");
        }
    }

    /**
     * Returns the date's year.
     * @return the date's year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the date formatted in YYYYMMDD.
     * It adds a 0 before the month if it is less than 10 (before October)
     * It adds a 0 before the day if it is less than 10
     * @return the date formatted in YYYYMMDD
     */
    public String getYYYYMMDD()
    {
        if (month < MINIMUM_TEN && day < MINIMUM_TEN)
        {
            return year + "-0" + month + "-0" + day;
        }
        else if (month < MINIMUM_TEN)
        {
            return year + "-0" + month + "-" + day;
        }
        else if (day < MINIMUM_TEN)
        {
            return year + "-" + month + "-0" + day;
        }
        else
        {
            return year + "-" + month + "-" + day;
        }
    }

    /**
     * PURPOSE:
     * This method calculates and returns the day of the week (as a string) for the
     * current Date object using a mathematical algorithm. The algorithm is designed
     * primarily for dates in the 1900s, with special adjustments for the dates in the
     * 1800s and 2000s. This allows us to determine what day of the week any date
     * falls on without needing to reference an external calendar or lookup table.
     * ----------------------------------------------------------------------------------
     * RETURN VALUE:
     * Returns a String representing the day of the week:
     * "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", or "Friday"
     * If an unexpected error occurs, returns "An error occurred"
     * ----------------------------------------------------------------------------------
     * THE ALGORITHM:
     * PHASE 1: Apply special adjustments FIRST (before main calculation)
     * - Leap year adjustment for 2000s dates
     * - Century adjustment for 2000s dates
     * - Century adjustment for 1800s dates
     * PHASE 2: Perform the calculation
     * - Extract last two digits of year
     * - Calculate number of twelves
     * - Calculate remainder
     * - Calculate number of fours
     * - Add day of month
     * - Add month code
     * PHASE 3: Map the result to a day name
     * - Convert the numeric result (0-6) to the actual day name
     * ----------------------------------------------------------------------------------
     * We'll walk through each phase in detail using October 31, 1977 as our example.
     * ----------------------------------------------------------------------------------
     * PHASE 1
     * ----------------------------------------------------------------------------------
     * ADJUSTMENT A: Leap year adjustment for January/February
     * If the date is in January OR February, AND the year is a leap year, we add 6.
     * This is required because both months occur before the leap day (February 29).
     * This means they need special handling because they're affected differently
     * by the leap year cycle than the other months
     * ----------------------------------------------------------------------------------
     * Leap Year Rules:
     * A year is a leap if:
     * 1. It is divisible by 4 AND not divisible by 100, OR
     * 2. It is divisible by 400
     * Examples:
     * - 2000: Divisible by 400 -> Leap year
     * - 1900: Divisible by 100 but not 400 -> Not a leap year
     * - 2004: Divisible by 4 and not by 100 -> Leap year
     * - 1977: Not divisible by 4 -> Not a leap year
     * ----------------------------------------------------------------------------------
     * For our example we skip this adjustment
     * ----------------------------------------------------------------------------------
     * Adjustment B: Century adjustment for 2000s
     * If the year is 2000 or greater (year >= 2000), we add 6
     * It's because the Gregorian calendar has a 400-year cycle, and different centuries
     * required different adjustments to align with the actual day of the week pattern.
     * The 2000s require adding 6 to compensate for the century shift.
     * ----------------------------------------------------------------------------------
     * For our example we skip this adjustment
     * ----------------------------------------------------------------------------------
     * Adjustment C: Century adjustment for 1800s
     * If the year is between 1800 and 1899, we add 2
     * Similar to the 2000s adjustment, the 1800s require their own adjustment
     * factor (2 instead of 6) to align with the calendar cycle.
     * ----------------------------------------------------------------------------------
     * For our example we skip this adjustment
     * ----------------------------------------------------------------------------------
     * PHASE 2
     * ----------------------------------------------------------------------------------
     * Now we perform the main algorithm using the last two digits of he year and the
     * specific day and month
     * ----------------------------------------------------------------------------------
     * STEP 1: Extract the last two digits of the year
     * We take the year and use modulo 100 to get just the last two digits.
     * For 1977:
     * years_left = 1977 % 100 = 77
     * ----------------------------------------------------------------------------------
     * STEP 2: Calculate the number of complete twelves
     * We divide the last two digits of the year by 12 and take only the whole number.
     * For 77:
     * num_of_twelves == 77 / 12 = 6
     * ----------------------------------------------------------------------------------
     * STEP 3: Calculate the remainder after removing the twelves
     * We find what's left over after removing all the complete groups of 12.
     * For 77:
     * remainder = 77 % 12 = 5
     * "5" represents the "extra years" used in the next steps
     * ----------------------------------------------------------------------------------
     * STEP 4: Calculate the number of complete fours in the remainder
     * We divide the remainder by 4 and take only the whole number.
     * For remainder of 5:
     * num_of_fours = 5 / 4 = 1
     * ----------------------------------------------------------------------------------
     * We add together:
     * - The number of twelves
     * - The remainder
     * - The number of fours
     * - The day of the month
     * - Our running sum_of days
     * ----------------------------------------------------------------------------------
     * For October 31, 1977:
     * sum_of_days = 0 (Phase 1)
     * sum_of_days += 6 (num_of_twelves)
     * sum_of_days += 5 (remainder)
     * sum_of_days += 1 (num_of_fours)
     * sum_of_days += 31 (day of month)
     * sum_of_days = 43
     * ----------------------------------------------------------------------------------
     * STEP 6: Add the month code
     * Each month has a specific code that must be added. These codes account for the
     * different number of days in each month and how that affects the day of
     * the week progressing throughout the year.
     * ----------------------------------------------------------------------------------
     * The month codes follow the pattern "jfmamjjasond" = 144025036146
     * ----------------------------------------------------------------------------------
     * The code is determined using a switch statement expression that matches the month
     * and returns the corresponding code value.
     * ----------------------------------------------------------------------------------
     * For October:
     * code = 1
     * sum_of_days += 1
     * sum_of_days = 43 + 1 = 44
     * ----------------------------------------------------------------------------------
     * STEP 7: Calculate the final day index using modulo 7
     * We take our total sum and find the remainder when divided by 7.
     * For our sum of 44:
     * day_index = 44 % 7 = 2
     * We use modulo 7 to because it represents 7 days in a week, so any number of days can be
     * reduced to a value from 0-6, representing the 7 possible days.
     * ----------------------------------------------------------------------------------
     * PHASE 3: Mapping the result to a day name
     * The day_index value (0-6) maps to actual day names as follows:
     * 0 = Saturday
     * 1 = Sunday
     * 2 = Monday
     * 3 = Tuesday
     * 4 = Wednesday
     * 5 = Thursday
     * 6 = Friday
     * For our example:
     * day_index = 2
     * 2 maps to "Monday"
     * ----------------------------------------------------------------------------------
     * Verification: October 31, 1977 was indeed a Monday!
     * The final switch statement takes the day_index and returns the corresponding
     * day name as a String. If somehow an invalid index is produced, the default case returns
     * "An error occurred".
     * ----------------------------------------------------------------------------------
     *
     * @return String representation of the day of the week (e.g, "Monday")
     */
    public String getDayOfWeek()
    {
        int sum_of_days;
        sum_of_days = BASE_VALUE;

        if (month == JANUARY || month == FEBRUARY)
        {
            if (year % DIVIDE_BY_FOUR == DIVISIBLE && year % DIVIDE_BY_ONE_HUNDRED != DIVISIBLE)
            {
                sum_of_days += ADD_SIX;
            }
            else if (year % DIVIDE_BY_FOUR_HUNDRED == DIVISIBLE)
            {
                sum_of_days += ADD_SIX;
            }
        }

        if (year >= TWO_THOUSANDS)
        {
            sum_of_days += ADD_SIX;
        }

        if (year >= EIGHTEEN_HUNDREDS && year < NINETEEN_HUNDREDS)
        {
            sum_of_days += ADD_TWO;
        }

        int years_left;
        years_left = year % CENTURY_DIVISOR;

        int num_of_twelves;
        int remainder;
        int num_of_fours;

        num_of_twelves = years_left / NUM_OF_TWELVES;
        remainder = years_left % NUM_OF_TWELVES;
        num_of_fours = remainder / NUM_OF_FOURS;
        sum_of_days += num_of_twelves + remainder + num_of_fours + day;

        int code;
        code = switch (month)
        {
            case JANUARY, OCTOBER -> CODE_ONE;
            case FEBRUARY, MARCH, NOVEMBER -> CODE_FOUR;
            case APRIL, JULY -> CODE_ZERO;
            case MAY -> CODE_TWO;
            case JUNE -> CODE_FIVE;
            case AUGUST -> CODE_THREE;
            case SEPTEMBER, DECEMBER -> CODE_SIX;
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
        sum_of_days += code;

        int day_index;
        day_index = sum_of_days % DAYS_IN_WEEK;

        switch(day_index)
        {
            case SATURDAY:
                return "Saturday";
            case SUNDAY:
                return "Sunday";
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            case FRIDAY:
                return "Friday";
            default:
                throw new IllegalStateException("An error occurred");
        }
    }

}
