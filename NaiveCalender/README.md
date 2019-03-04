# HW1: Java Programming: naive calendar
## In HW1, you are expected to learn:  
Java interface (https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)  
implementing a Java class static functions
## how to test class functions
No input file Functions in the interface MyCalendar
- int getYear(); // get the value of the private variable 'year'
- int getMonth(); // get the value of the private variable 'month'
- int getDayNumOfMonth(); // get the number of days of a month
- boolean isLeap(); // determine if a year is a leap year (https://en.wikipedia.org/wiki/Leap_year)
- void printCalendar(); // print the calendar of the month/year

Exception handling  
If the 'year' is not an positive, please use RuntimeException to print "Invalid year"  
If the 'month' is not valid, please use RuntimeException to print "Invalid month"  
Note:  
You are not requested to write a main function for your class: NaiveCalendar.java  
The judger will not execute your main function in NaiveCalendar.java

Example of printCalendar (2018/9):  
```
SUN MON TUE WED THU FRI SAT

                           1

   2   3   4   5   6   7   8

   9  10  11  12  13  14  15

  16  17  18  19  20  21  22

  23  24  25  26  27  28  29

  30
```
File to be submitted to the judge system:

You are requested to implement a Java class named NaiveCalendar. So, please submitted a file named: NaiveCalendar.java  
Note that your code must be in the default package; if you use a package statement, the autograder will not be able to assess your work.

Example file
```
Related links
https://docs.oracle.com/javase/tutorial/java/annotations/index.html
https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html
https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html
```
