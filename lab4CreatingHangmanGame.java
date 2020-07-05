/* Creating a hangman game. A random word from a string array will be picked. 
Letter will be guessed by the user until the word is guessed or they run out of lives. */

import java.util.*;

public class lab4CreatingHangmanGame {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String [] array= {"Some", "words", "are", "difficult", "to", "guessed"};
        int m= (int)Math.floor(Math.random()*(array.length));
        String word= array[m].toLowerCase();
        System.out.println(word);
        String guess="";
        boolean found=false;
       
        for(int i=0; i<word.length(); i++)
        {
            guess+="-";
        }
        System.out.println(guess);
       
        int j=0;
        while(j<7)
        {
            String input=sc.nextLine();
            char letter=input.charAt(0);
           
            String result=check(guess,word,letter);
            if(guess.compareTo(result)==0)
            {
                j++;
            }
            else
            {
                guess=result;
            }
            if(guess.compareTo(word)==0)
            {
                found=true;
                j=7;
            }
        }
       
        if(found)
        {
            System.out.println(word+" has been found");
        }
        else
        {
            System.out.println(word+" was not found");
        }
    }
   
    public static String check(String guess, String word, char letter)
    {
        for(int i=0; i<word.length(); i++)
        {
            if(word.charAt(i)==letter)
            {
                guess=guess.substring(0,i)+letter+guess.substring(i+1);
            }
        }
        System.out.println(guess);
        return guess;
    }
   
}