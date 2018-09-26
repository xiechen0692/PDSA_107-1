public class NaiveCalendar implements MyCalendar {

    private static final int[] DAYS_OF_MONTH = {0, 31, 28, 31, 30, 31, 30, 
        31, 31, 30, 31, 30, 31};
    private static final String[] WEEK_DAY = {"SUN", "MON", "TUE", "WED", 
        "THU", "FRI", "SAT"};
    private static final int FIRST_DAY_OF_YEAR_ONE = 1;

    private int year;
    private int month;
    private int dayNumOfMonth;
    private boolean leap;
    private int leapCount;
    private int firstDayOYear;
    private int firstDayOfMonth;

    public NaiveCalendar(int year, int month) { // constructor
        if (year <= 0 || month < 1 || month > 12) {
            if (year<=0)//Show how to use the RuntimeException for the unconsideration problem, year first 
            {    
            RuntimeException e = new RuntimeException("Invalid year");// todo
            throw e;
            }
            else 
            {
            RuntimeException e2 = new RuntimeException("Invalid month");// todo
            throw e2;
            }
        }

        this.year = year;
        this.month = month;

        leap = calculateLeap();
        dayNumOfMonth = calculateDayNumOfMonth();
        
        leapCount = calculateLeapCount();
        firstDayOYear = calculateFirstDayOfYear();
        firstDayOfMonth = calculateFirstDayOfMonth();
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getDayNumOfMonth() {
        return dayNumOfMonth;
    }

    @Override
    public boolean isLeap() {
        return leap;
    }
   
    private boolean calculateLeap() {
    if ((year%4==0 && year%100!=0) || (year%400==0)){
        return true;
    }
    else
        return false;
}
    
       
    public int calculateLeapCount() 
    {
        int count=0;
        for (int x = 1; x < year + 1; x++) 
        { //note 1900! = leap year
            if ((x % 4 == 0 && x % 100 != 0) || (x % 400 == 0))
            {
                count++;
            } 
        }   
        return count;// todo	
    }
    
    private int calculateDayNumOfMonth() {
        int dayNum = DAYS_OF_MONTH[month];
        
        if (month == 2 && leap) {
            dayNum++;
        }
        
        return dayNum;
    }

    public int calculateFirstDayOfYear() 
    {
        if (year==1)
        {
            return 1;
        }
        if (leap==true)
        {    
            int Total_days1=365*(year-1)+leapCount;
            return (Total_days1+1)%7;
        }
        else
        {
              int Total_days2=365*(year-1)+leapCount+1;     
            return (Total_days2+1)%7;
		// todo:considerate two situation because the caculation of the countofleapyear
        }        
    }

    public int calculateFirstDayOfMonth() {
        int sumdays=0;
        if (month == 1) {
            return firstDayOYear;
        }
        if (month == 2) {
            return (firstDayOYear + DAYS_OF_MONTH[1]) % 7;
        }
        else
            if (leap==true)
            {
                for (int i=0;i<month;i++)
                {
                    sumdays=sumdays+DAYS_OF_MONTH[i];         
                }
                sumdays++;
                return firstDayOYear + sumdays% 7;
            }
            else
                for (int i=0;i<month;i++)
                {
                    sumdays=sumdays+DAYS_OF_MONTH[i];         
                }
                return firstDayOYear + sumdays% 7;
//		 todo: consider about the second month of the leap year
			
    }
    
    @Override
    public void printCalendar() {

        for (String day : WEEK_DAY) {
            System.out.print(formatEntry(day));
        }
        System.out.println();
        int spaces=firstDayOfMonth-1;

        for (int i = 1; i <= spaces; i++)
        {
            System.out.print("    "); 
            //print out the first line of spaces 
        }
        for (int j = 1; j <= dayNumOfMonth; j++)
        {
  
            String temp1 = "   " + Integer.toString(j);
            String temp2 = "  " + Integer.toString(j);
            if (j<=9)
            {
                System.out.printf(temp1);
            }
            else
            {
                System.out.printf(temp2);
            }    
            if (((j + spaces) % 7 == 0) || (j == dayNumOfMonth)) System.out.println();
        }
        
		/*  todo: use function formatEntry and System.out.print to print the calendar
			System.out.print(formatEntry("")); // get "    "
			System.out.print(formatEntry(String.valueOf(10))); // get "  10" 
		*/

        System.out.println();
        
    }

    private static String formatEntry(String entry) {
        return String.format("%1$4s", entry);
    }
}