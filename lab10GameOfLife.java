/*The final lab is the game of life, invented by mathematician John Conway in 1970. 
The aim of the HackerRank lab is to simulate the game of life for a specified number of moves and then count the number of live cells.*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class lab10GameOfLife {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[][] array=new String[20][20];
        String[][] array2=new String[20][20];

        String s2=sc.nextLine();
        long round=Integer.parseInt(s2);
        for(int i=0; i<20; i++ )
        {
            String s=sc.nextLine();
            for(int j=0; j<20; j++)
            {
                array[i][j]=s.charAt(j)+"";
                array2[i][j]="0";
            }
        }
        while(round>0)
        {
            for(int i=0; i<array.length; i++)
            {
                for(int j=0; j<array[i].length; j++)
                { 
                    //counting neighbours if statements
                    int lives=0;
                    if(i<19)
                    {
                        //bottomleft
                        if(j>0)
                        {
                            if(array[i+1][j-1].compareTo("1")==0)
                            {
                                lives++;
                            }
                        }
                        //bottom
                        if(array[i+1][j].compareTo("1")==0)
                        {
                            lives++;
                        }
                        //bottomright
                        if(j<19)
                        {
                            if(array[i+1][j+1].compareTo("1")==0)
                            {
                                lives++;
                            }
                        }
                    }
                    if(i>0)
                    {
                        //topleft
                        if(j>0)
                        {
                            if(array[i-1][j-1].compareTo("1")==0)
                            {
                                lives++;
                            }
                        }
                        //top
                        if(array[i-1][j].compareTo("1")==0)
                        {
                            lives++;
                        }
                        //topright
                        if(j<19)
                        {
                            if(array[i-1][j+1].compareTo("1")==0)
                            {
                                lives++;
                            }
                        }
                    }
                    //left
                    if(j>0)
                    {
                        if(array[i][j-1].compareTo("1")==0)
                        {
                            lives++;
                        }
                    }
                    //right
                    if(j<19)
                    {
                        if(array[i][j+1].compareTo("1")==0)
                        {
                            lives++;
                        }
                    }
                    

                    String c=array[i][j];
                    if(lives==3 && c.equals("0"))
                    {
                        array2[i][j]="1";
                    }
                    if((lives==2 || lives==3) && c.equals("1"))
                    {
                        array2[i][j]="1";
                    } 
                }
            }
            for(int x=0; x<20; x++ )
                {
                    for(int j=0; j<20; j++)
                    {
                        array[x][j]=array2[x][j];
                        array2[x][j]="0";
                    }
                }
        round--;
        }

        long count=0;
        for(int i=0; i<20; i++)
        {
            for(int j=0; j<20; j++)
            {
                if(array[i][j].equals("1"))
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}