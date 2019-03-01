import java.util.*;
import java.io.*;
import edu.princeton.cs.algs4.StdOut;
import java.text.DecimalFormat;
//Note:
//1. The judge system will construct an object by calling Calculator cct = new Calculator().
//2. We won't execute your main function in Calculator.java.
//3. You do not need to worry about the format of printing the Double value.
//4. All the numbers, operators, and brackets are seperated by 'single space', so you don't have to spend much time on parsing string.
//5. You only need to handle with the operator such as (+, -, *, /)

/**
 *
 * @author Lab228
 */
public class Calculator
{
    private static DecimalFormat df2 = new DecimalFormat("##.00");
    public Double ans (String e) 
    {

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String[] sArray=e.split(" ") ;
        for (int j=0;j<sArray.length;j++)
        {
            String s = sArray[j];
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals(")"))
            {
            String op = ops.pop(); 
            //System.out.println(op);    
                if (op.equals("+")) 
                {
                    double num1=vals.pop() + vals.pop();
                    //System.out.println(num1);
                    vals.push(num1);
                }
                else if (op.equals("*")) 
                {
                    double num2=vals.pop() * vals.pop();
                    //System.out.println(num2);
                    vals.push(num2);
                }
                else if (op.equals("-")) 
                {
                    double a=vals.pop();
                    double b=vals.pop();
                    //System.out.println(a);
                    //System.out.println(b);
                    double num3=b-a;
                    //System.out.println(num3);
                    vals.push(num3);
                }
                else if (op.equals("/")) 
                {
                    double c=vals.pop();
                    double d=vals.pop();
                    double num4= d / c;
                    //System.out.println(num4);
                    vals.push(num4);
                }
            }
            
            else 
            {
                //System.out.println(s);
                vals.push(Double.parseDouble(s));       
            }
        }
        double result=vals.pop();
        //System.out.println(result);
     //please replace the following null to the answer you calculated.
        return Double.parseDouble(df2.format(result));
        //return result;
    } 
    
    public static void main(String[] args) 
    {
        //String x="( ( ( 1 + ( 12 * 5 ) ) - ( 3 * 4 ) ) + ( 4 / 5 ) )";
        String x="( ( ( 200 / 20 ) + 5 ) - ( ( 5 * 4 ) - 50 ) )";
        Calculator cct = new Calculator();
        double a=cct.ans(x);
        System.out.println(a);
    }
}
