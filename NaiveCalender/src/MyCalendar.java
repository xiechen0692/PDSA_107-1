public interface MyCalendar {

    int getYear();
    
    int getMonth();
    
    int calculateFirstDayOfYear();
    int calculateLeapCount();
    int calculateFirstDayOfMonth();
    int getDayNumOfMonth();

    boolean isLeap();    
    
    void printCalendar();

}
