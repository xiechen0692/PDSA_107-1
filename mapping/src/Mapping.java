import  java.io.FileReader;

import java.io.BufferedReader;
public class Mapping {

    public static void main(String[] args) throws Exception {

        // read file from args[0] in Java 7 style
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            //In in  = new In(args[0]);   
            // read a line
            String data = br.readLine();
            // store the first integer in variable readCount (number of reads)
            int readCount = Integer.parseInt(data);
            // initialization of a String array
            String[] readsArray = new String[readCount];
            String reference = new String();
            //put the line of txt into a array
            for (int i = 0; i < readCount; i++) {
                    readsArray[i] = br.readLine();
                }
            //前面三行已經讀完，然後讀取最後一行的內容作為reference
            reference = br.readLine();
            //
            int Length;
            //创建一个数组，里面记录每一个要mapping字符串的计数
            int[] count = new int[readCount];
            //先找出要mapping的字串長度
            for (int x = 0; x < readCount; x++) {
            Length = readsArray[x].length();
            for (int y = 0; y < reference.length()-Length+1; y++) {
            if (readsArray[x].equals(reference.substring(y, y+Length))) {
            count[x]++;
                    }
                }
            }
            br.close();
            //
//            for (int i=0;i<readCount;i++){
//                if(count[i]!=0){
//                System.out.printf("%d\n",count[i]);
//                }
//            }
             int count_1 = 0, count_2 = 0;
             for (int m = 0; m < readCount; m++) {
                    if (count[m] >= 1){
                        count_1++;
                    }
                    if (count[m] >= 2){
                        count_2++;
                    }
                }
                System.out.printf("%d\n%d\n", count_1, count_2);
            // printf in Java
            //System.out.printf("%d\n",readCount);
            
            /*  now you can write your own solution to hw0
             *  you can follow the instruction described below:
             *
             *  1. read the rest content of the file
             *  2. store the reads in variable readsArray
             *  3. store the reference sequence in variable reference
             *  4. compare every reads with reference sequence
             *  5. output how many reads can be mapped to the reference sequence
             *
             *  [note]
             *  you can use every data structure in standard Java packages (Java 8 supported)
             *  the packages in stdlib.jar and algs4.jar are also available for you to use
             *
             *  [hint]
             *  1. you can use String.contain() method when comparing strings.
             *  2. you should check whether Java pass the variable by references or by values.
             *  3. some data structure such as HashSet, HashMap, Arrays, ArrayList, Vector are very
             *     useful for solving problems.
             */
        
    }
}
