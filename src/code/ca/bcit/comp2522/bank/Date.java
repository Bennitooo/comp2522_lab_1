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

    private static final int CODE_ZERO = 0;
    private static final int CODE_ONE = 1;
    private static final int CODE_TWO = 2;
    private static final int CODE_THREE = 3;
    private static final int CODE_FOUR = 4;
    private static final int CODE_FIVE = 5;
    private static final int CODE_SIX = 6;
    private static final int DAYS_IN_WEEK = 7;

    final int year;
    final int month;
    final int day;

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

    private static void validateYear(final int year)
    {
        if (year < MINIMUM_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year is out of range");
        }
    }

    private static void validateMonth(final int month)
    {
        if (month < JANUARY || month > DECEMBER)
        {
            throw new IllegalArgumentException("Month is out of range");
        }
    }

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
    public int getMonth()
    {
        return month;
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
     * Returns the date's day of the week.
     * @return the date's day of the week
     */
    public String getDayOfWeek()
    {
        int sum_of_days;
        sum_of_days = 0;

        if (month == JANUARY || month == FEBRUARY)
        {
            if (year % DIVIDE_BY_FOUR == DIVISIBLE && year % DIVIDE_BY_ONE_HUNDRED != DIVISIBLE)
            {
                sum_of_days += ADD_SIX;
            }
            else if (year % DIVIDE_BY_FOUR == DIVISIBLE && year % DIVIDE_BY_FOUR_HUNDRED == DIVISIBLE)
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
        code = switch (month) {
            case JANUARY, OCTOBER -> CODE_ONE;
            case FEBRUARY, MARCH, NOVEMBER -> CODE_FOUR;
            case APRIL, JULY -> CODE_ZERO;
            case MAY -> CODE_TWO;
            case JUNE -> CODE_FIVE;
            case AUGUST -> CODE_THREE;
            case SEPTEMBER, DECEMBER -> CODE_SIX;
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
                return "An error occurred";
        }
    }

}
