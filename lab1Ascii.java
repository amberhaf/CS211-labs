/* This programming exercise is the first part of creating a Huffman
encoding program. You will continue it next week. Write a Java
program which takes in a line from the user (using Scanner) and then
outputs
i. The sentence in ASCII
ii. Each letter in the sentence and its frequency */

public class lab1Ascii {
    public static void main(String args[]) {
        String sentence="This sentence will be converted to ascii.";
        String array[]= new String [256];
        int count[]= new int [256];
       
        for(int i=0; i<256; i++)
        {
            array[i]=Integer.toBinaryString(i);
        }
       
        for(int i=0; i<sentence.length(); i++)
        {
            int n=(int)sentence.charAt(i);
            String m=Integer.toBinaryString(n);
           
            for(int j=0; j<256; j++)
            {
                if(array[j].compareTo(m)==0)
                {
                    count[j]=count[j]+1;
                }
            }
        }

            for(int j=0; j<256; j++)
            {
                     int decimal=Integer.parseInt(array[j],2);
               System.out.println((char)decimal+": "+count[j]);
            }

    }
}