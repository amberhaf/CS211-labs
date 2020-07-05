/* The goal is to insert all the words into the hash table and then find them all again
with the minimum number of collisions. You can use any hashing strategy you
like. The main method that reads in the data is provided (see Java 8 code stub).
There is also a HashTable class - you must use the check() method to check for a
collision when you are finding a word. Every time you make an unsuccessful
check() call (i.e. a collision), a counter ticks up. You have to keep this as low as
possible. You should just complete the fill() and find() methods. When you run the
code, it will output the number of collisions you have. If you see the word "error!"
it means that your find() method is not finding the words properly in the hash table. */

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class lab6HashTable{    
    
    public static void main (String[] args){
        Scanner myscanner = new Scanner(System.in);
        int items = myscanner.nextInt()-1;
        myscanner.nextLine();
        String[] contents = new String[items];
        for(int i=0;i<items;i++){
            contents[i]=myscanner.nextLine();
        }
        String hash = myscanner.nextLine();
        int size=99991;
        Solution mysolution = new Solution();
        String[] hashtable=mysolution.fill(size, contents);
        HashTable mytable = new HashTable(hashtable);

        Solution mysolution2 = new Solution(); //prevents cheating by using memory
        for(int i=0;i<items;i++){
            int rand = (int)(Math.random()*items);
            String temp = contents[i];
            contents[i]=contents[rand];
            contents[rand]=temp;
        }
        int total=0;
        for(int i=0;i<items;i++){
            int slot = mysolution2.find(size, mytable, contents[i]);
            if(!hashtable[slot].equals(contents[i])){
                System.out.println("error!");
            }
        }      
        System.out.println("Collisions: " + mytable.gettotal());
        try{
            System.out.println("Your Receipt: "+sha256(hash+mytable.gettotal()));
        }catch(NoSuchAlgorithmException e){};
    }
    
    public static String sha256(String input) throws NoSuchAlgorithmException {
        byte[] in = hexStringToByteArray(input);
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if(len%2==1){
            s=s+"@";
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
    
    
class HashTable{
    
    private String[] hashTable;
    private int total=0;

    public HashTable(String[] input){
        hashTable = input;
    }

    public boolean check(int slot, String check){
        if(hashTable[slot].equals(check)){
            return true;
        }else{
            total++;
            return false;
        }
    }
    
    public int gettotal(){
        return total;
    }
} 


      
class Solution{
      
    public int find(int size, HashTable mytable, String word){
        
        //fill this in so as to minimize collisions
        //takes in the HashTable object and the word to be found
        //the only thing you can do with the HashTable object is call "check"
        //this method should return the slot in the hashtable where the word is 

        //fill this in so as to minimize collisions
            int key=0;
            for(long i=0; i<word.length(); i++)
            {
                int j=(int)i;
            char character = word.charAt(j);
            int ascii = (int) character;
            key=(599*(key+size)+ascii)%size;
        }
        //int key = sum % 99991;
        boolean b=true;
       // System.out.println(key);
        while(b)
        {
            if(mytable.check(key, word))
            {
                b=false;
            }
            else
            {
                key+=size;
                key=(key*19)%size;
            }
        }
        return key;
    }
    
    public String[] fill(int size, String[] array){
        
        //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
        //this should add all the words into the hashtable using some system
        //then it should return the hashtable array
        String[] hashtable = new String[size];
        for(int i=0; i<size; i++)
        {
            hashtable[i]="";
        }
        for(String s:array){
            long key =0;
            for(long i=0; i<s.length(); i++)
            {
                int j=(int)i;
                char character = s.charAt(j);
                int ascii = (int) character;
                
                key=(599*(key+(long)size)+(long)ascii)%(long)size;
            }
            boolean b=true;
            while(b){
                if(hashtable[(int)key]=="")
                {
                    b=false;
                }
                else
                {
                    key+=(long)size;
                    key=(key*19)%(long)size;
                }
            }
            int k=(int)key;
            hashtable[k]=s;
           // System.out.println(key+" "+s1);
        }
        return hashtable;
    }  
}