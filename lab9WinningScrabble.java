/* Given a list of letters look through a dictionary and figure out the best word that can be made using these letters for a game of scrabble. 
The longer the word the better the answer. */

import java.util.*;

public class lab9WinningScrabble {
    public static void main(String args[] ) throws Exception {
        Scanner myscanner = new Scanner(System.in);
        String letters = myscanner.nextLine();
        String array[] = new String[216555];
        for(int i=0;i<216555;i++){
            array[i]=myscanner.nextLine();
        }
        System.out.println(findLength(letters,array));
    }
        

    public static int findLength(String letters, String[] array){

        int max=0;
        int y=0;
        while(y<array.length)
        {
            String stars="";
            for(int j=0; j<array[y].length(); j++)
            {
                stars=stars+"*";
            }
            for(int j=0; j<letters.length(); j++)
            {
                String s=array[y];
                char b=letters.charAt(j);
                String b1=b+"";
                if(s.indexOf(b)!=-1)
                {
                    String n=s.replaceFirst(b1,"*");
                    array[y]=n;
                }
            }
            if(stars.compareTo(array[y])==0)
            {
                int len=array[y].length();
                if(len>max)
                {
                    max=len;
                }
            }
            y++;

        }
        return max; 
    }

}