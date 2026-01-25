package ca.bcit.comp2522.bank;

/**
 * This class models the opening and closing dates of someone's bank account.
 *
 * @author Bennett Lazarro Set D
 * @author Abdullah Munawar Set D
 *
 * @version 1.0
 */
public class Date
{
    private static final int MINIMUM_YEAR = 1800;
    private static final int CURRENT_YEAR = 2026;
    private static final int JANUARY_MONTH_NUM = 1;
    private static final int FEBRUARY_MONTH_NUM = 2;
    private static final int MARCH_MONTH_NUM = 3;
    private static final int APRIL_MONTH_NUM = 4;
    private static final int MAY_MONTH_NUM = 5;
    private static final int JUNE_MONTH_NUM = 6;
    private static final int JULY_MONTH_NUM = 7;
    private static final int AUGUST_MONTH_NUM = 8;
    private static final int SEPTEMBER_MONTH_NUM = 9;
    private static final int OCTOBER_MONTH_NUM = 10;
    private static final int NOVEMBER_MONTH_NUM = 11;
    private static final int DECEMBER_MONTH_NUM = 12;

    private static final int DAY_ONE = 1;
    private static final int SHORT_FEBRUARY_MONTH_NUM = 28;
    private static final int LONG_FEBRUARY_MONTH_NUM = 29;
    private static final int SHORT_MONTH = 30;
    private static final int LONG_MONTH = 31;
    private static final int YEAR_EVERY_LEAP_YEAR = 4;
    private static final int YEAR_EVERY_CENTURY = 100;
    private static final int YEAR_EVERY_FOUR_CENTURY = 400;
    private static final int DIVISIBLE = 0;
    private static final int MINIMUM_TEN = 10;

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private static final int YEAR_EIGHTEEN_HUNDREDS = 1800;
    private static final int YEAR_NINETEEN_HUNDREDS = 1900;
    private static final int YEAR_TWO_THOUSANDS = 2000;
    private static final int CENTURY_DIVISOR = 100;
    private static final int ADD_SIX = 6;
    private static final int ADD_TWO = 2;
    private static final int NUMBER_OF_COMPLETE_TWELVES = 12;
    private static final int NUMBER_OF_COMPLETE_FOURS = 4;
    private static final int BASE_VALUE = 0;

    private static final int MONTH_CODE_ZERO = 0;
    private static final int MONTH_CODE_ONE = 1;
    private static final int MONTH_CODE_TWO = 2;
    private static final int MONTH_CODE_THREE = 3;
    private static final int MONTH_CODE_FOUR = 4;
    private static final int MONTH_CODE_FIVE = 5;
    private static final int MONTH_CODE_SIX = 6;
    private static final int DAYS_IN_WEEK = 7;

    private final int year;
    private final int month;
    private final int day;

    /**
     * This is a constructor for the opening and closing dates in someone's bank account.
     *
     * @param year This is the first parameter for a year
     * @param month This is the second parameter for a month
     * @param day This is the third parameter for a day
     */
    public Date(final int year, 
                final int month, 
                final int day)
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
     * 1) less than MINIMUM_YEAR OR
     * 2) greater than CURRENT_YEAR 
     *
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
     * represented as an int, less than 1 (JANUARY_MONTH_NUM) OR greater than 12 (DECEMBER_MONTH_NUM).
     *
     * @param month This is the parameter for a month
     */
    private static void validateMonth(final int month)
    {
        if (month < JANUARY_MONTH_NUM || month > DECEMBER_MONTH_NUM)
        {
            throw new IllegalArgumentException("Month is out of range");
        }
    }
    /**
     * This is a private validator method to check if the day is within
     * the valid range for the specific month and year.
     *
     * @param day The day of the month to validate
     * @param month The month value
     * @param year The year value
     */
    private static void validateDay(final int day,
                                    final int month,
                                    final int year)
    {
        if (day < DAY_ONE)
        {
            throw new IllegalArgumentException("Day is out of range");
        }

        if (month == JANUARY_MONTH_NUM ||
                month == MARCH_MONTH_NUM ||
                month == MAY_MONTH_NUM ||
                month == JULY_MONTH_NUM ||
                month == AUGUST_MONTH_NUM ||
                month == OCTOBER_MONTH_NUM ||
                month == DECEMBER_MONTH_NUM)
        {
            if (day > LONG_MONTH)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else if (month == APRIL_MONTH_NUM ||
                month == JUNE_MONTH_NUM ||
                month == SEPTEMBER_MONTH_NUM ||
                month == NOVEMBER_MONTH_NUM)
        {
            if (day > SHORT_MONTH)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else
        {
            if (year % YEAR_EVERY_LEAP_YEAR == DIVISIBLE &&
                    year % YEAR_EVERY_CENTURY != DIVISIBLE)
            {
                if (day > LONG_FEBRUARY_MONTH_NUM)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
            else if (year % YEAR_EVERY_FOUR_CENTURY == DIVISIBLE)
            {
                if (day > LONG_FEBRUARY_MONTH_NUM)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
            else
            {
                if (day > SHORT_FEBRUARY_MONTH_NUM)
                {
                    throw new IllegalArgumentException("Day is out of range");
                }
            }
        }
    }

    /**
     * Returns the date's day.
     *
     * @return the date's day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the date's month.
     *
     * @return the date's month
     */
    public String getMonth()
    {
        return switch (month) {
            case JANUARY_MONTH_NUM -> "January";
            case FEBRUARY_MONTH_NUM -> "February";
            case MARCH_MONTH_NUM -> "March";
            case APRIL_MONTH_NUM -> "April";
            case MAY_MONTH_NUM -> "May";
            case JUNE_MONTH_NUM -> "June";
            case JULY_MONTH_NUM -> "July";
            case AUGUST_MONTH_NUM -> "August";
            case SEPTEMBER_MONTH_NUM -> "September";
            case OCTOBER_MONTH_NUM -> "October";
            case NOVEMBER_MONTH_NUM -> "November";
            case DECEMBER_MONTH_NUM -> "December";
            default -> throw new IllegalStateException("An error occurred");
        };
    }

    /**
     * Returns the date's year.
     *
     * @return the date's year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the date formatted in YYYYMMDD.
     * It adds a 0 before the month if it is less than 10 (before October).
     * It adds a 0 before the day if it is less than 10.
     *
     * @return the date formatted in YYYYMMDD
     */
    public String getYYYYMMDD()
    {
        if (month < MINIMUM_TEN &&
                day < MINIMUM_TEN)
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
     * 1. It is divisible by YEAR_EVERY_LEAP_YEAR AND not divisible by YEAR_EVERY_CENTURY, OR
     * 2. It is divisible by YEAR_EVERY_FOUR_CENTURY
     * Examples:
     * - 2000: Divisible by YEAR_EVERY_FOUR_CENTURY-> Leap year
     * - 1900: Divisible by YEAR_EVERY_CENTURY but not YEAR_EVERY_FOUR_CENTURY -> Not a leap year
     * - 2004: Divisible by YEAR_EVERY_LEAP_YEAR and not by YEAR_EVERY_CENTURY -> Leap year
     * - 1977: Not divisible by YEAR_EVERY_LEAP_YEAR -> Not a leap year
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
     * If the year is greater or equal to YEAR_EIGHTEEN_HUNDREDS and less than YEAR_NINETEEN_HUNDREDS, we ADD_TWO
     * Similar to the 2000s adjustment, the 1800s require their own adjustment
     * factor (ADD_TWO instead of ADD_SIX) to align with the calendar cycle.
     * ----------------------------------------------------------------------------------
     * For our example we skip this adjustment
     * ----------------------------------------------------------------------------------
     * PHASE 2
     * ----------------------------------------------------------------------------------
     * Now we perform the main algorithm using the last two digits of he year and the
     * specific day and month
     * ----------------------------------------------------------------------------------
     * STEP 1: Extract the last two digits of the year
     * We take the year and use modulo CENTURY_DIVISOR to get just the last two digits.
     * For 1977:
     * yearsLeft = 1977 % CENTURY_DIVISOR = 77
     * ----------------------------------------------------------------------------------
     * STEP 2: Calculate the number of complete twelves
     * We divide the last two digits of the year by NUMBER_OF_COMPLETE_TWELVES and take only the whole number.
     * For 77:
     * numOfTwelves == 77 / NUMBER_OF_COMPLETE_TWELVES = 6
     * ----------------------------------------------------------------------------------
     * STEP 3: Calculate the remainder after removing the twelves
     * We find what's left over after removing all the complete groups of NUMBER_OF_COMPLETE_TWELVES.
     * For 77:
     * remainder = 77 % NUMBER_OF_COMPLETE_TWELVES = 5
     * "5" represents the "extra years" used in the next steps
     * ----------------------------------------------------------------------------------
     * STEP 4: Calculate the number of complete fours in the remainder
     * We divide the remainder by NUMBER_OF_COMPLETE_FOURS and take only the whole number.
     * For remainder of 5:
     * numOfFours = 5 / NUMBER_OF_COMPLETE_FOURS = 1
     * ----------------------------------------------------------------------------------
     * We add together:
     * - numberOfTwelves
     * - remainder
     * - numberOfFours
     * - day
     * - Our running sumOfDays
     * ----------------------------------------------------------------------------------
     * For October 31, 1977:
     * sumOfDays = 0 (Phase 1)
     * sumOfDays += 6 (numOfTwelves)
     * sumOfDays += 5 (remainder)
     * sumOfDays += 1 (numOfFours)
     * sumOfDays += 31 (day of month)
     * sumOfDays = 43
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
     * code = MONTH_CODE_ONE
     * sumOfDays += 1
     * sumOfDays = 43 + 1 = 44
     * ----------------------------------------------------------------------------------
     * STEP 7: Calculate the final day index using modulo 7
     * We take our total sum and find the remainder when divided by 7.
     * For our sum of 44:
     * day_index = 44 % 7 = 2
     * We use modulo 7 to because it represents 7 days in a week, so any number of days can be
     * reduced to a value from 0-6, representing the 7 possible days.
     * ----------------------------------------------------------------------------------
     * PHASE 3: Mapping the result to a day name
     * The dayIndex value (0-6) maps to actual day names as follows:
     * SATURDAY = "Saturday"
     * SUNDAY = "Sunday"
     * MONDAY = "Monday"
     * TUESDAY = "Tuesday"
     * WEDNESDAY = "Wednesday"
     * THURSDAY = "Thursday"
     * FRIDAY = "Friday"
     * For our example:
     * dayIndex = MONDAY
     * MONDAY maps to "Monday"
     * ----------------------------------------------------------------------------------
     * Verification: October 31, 1977 was indeed a Monday!
     * The final switch statement takes the dayIndex and returns the corresponding
     * day name as a String. If somehow an invalid index is produced, the default case returns
     * "An error occurred".
     * ----------------------------------------------------------------------------------
     *
     * @return String representation of the day of the week (e.g, "Monday")
     */
    public String getDayOfWeek()
    {
        final int yearsLeft;
        final int numberOfTwelves;
        final int remainder;
        final int numberOfFours;
        final int code = getMonthCode();
        final int dayIndex;

        int sumOfDays;

        sumOfDays = BASE_VALUE;

        if (month == JANUARY_MONTH_NUM ||
                month == FEBRUARY_MONTH_NUM)
        {
            if (year % YEAR_EVERY_LEAP_YEAR == DIVISIBLE &&
                    year % YEAR_EVERY_CENTURY != DIVISIBLE)
            {
                sumOfDays += ADD_SIX;
            }
            else if (year % YEAR_EVERY_FOUR_CENTURY == DIVISIBLE)
            {
                sumOfDays += ADD_SIX;
            }
        }

        if (year >= YEAR_TWO_THOUSANDS)
        {
            sumOfDays += ADD_SIX;
        }

        if (year >= YEAR_EIGHTEEN_HUNDREDS &&
                year < YEAR_NINETEEN_HUNDREDS)
        {
            sumOfDays += ADD_TWO;
        }

        yearsLeft = year % CENTURY_DIVISOR;

        numberOfTwelves = yearsLeft / NUMBER_OF_COMPLETE_TWELVES;
        remainder = yearsLeft % NUMBER_OF_COMPLETE_TWELVES;
        numberOfFours = remainder / NUMBER_OF_COMPLETE_FOURS;
        sumOfDays += numberOfTwelves + remainder + numberOfFours + day;

        sumOfDays += code;

        dayIndex = sumOfDays % DAYS_IN_WEEK;

        return switch (dayIndex) {
            case SATURDAY -> "Saturday";
            case SUNDAY -> "Sunday";
            case MONDAY -> "Monday";
            case TUESDAY -> "Tuesday";
            case WEDNESDAY -> "Wednesday";
            case THURSDAY -> "Thursday";
            case FRIDAY -> "Friday";
            default -> throw new IllegalStateException("An error occurred");
        };
    }

    /**
     * This returns the month's designated code
     *
     * @return Month's designated code
     */
    public int getMonthCode() {
        final int code;
        code = switch (month)
        {
            case JANUARY_MONTH_NUM, OCTOBER_MONTH_NUM -> MONTH_CODE_ONE;
            case FEBRUARY_MONTH_NUM, MARCH_MONTH_NUM, NOVEMBER_MONTH_NUM -> MONTH_CODE_FOUR;
            case APRIL_MONTH_NUM, JULY_MONTH_NUM -> MONTH_CODE_ZERO;
            case MAY_MONTH_NUM -> MONTH_CODE_TWO;
            case JUNE_MONTH_NUM -> MONTH_CODE_FIVE;
            case AUGUST_MONTH_NUM -> MONTH_CODE_THREE;
            case SEPTEMBER_MONTH_NUM, DECEMBER_MONTH_NUM -> MONTH_CODE_SIX;
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
        return code;
    }

}
