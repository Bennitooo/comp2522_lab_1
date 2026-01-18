package ca.bcit.comp2522.bank;

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

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private static final int NUM_OF_TWELVES = 12;
    private static final int NUM_OF_FOURS = 4;

    final int year;
    final int month;
    final int day;

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

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            if (day > DAY_THIRTY_ONE)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11)
        {
            if (day > DAY_THIRTY)
            {
                throw new IllegalArgumentException("Day is out of range");
            }
        }
        else
        {
            if (year % DIVIDE_BY_FOUR == 0)
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

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public String getYYYYMMDD()
    {
        return year + "-" + month + "-" + day;
    }

    public String getDayOfWeek()
    {

        int num_of_twelves = year/NUM_OF_TWELVES;
        int remainder = year - num_of_twelves;
        int num_of_fours = remainder/NUM_OF_FOURS;
        int add_days = month
                + num_of_twelves
                + remainder
                + num_of_fours;
    }

}
