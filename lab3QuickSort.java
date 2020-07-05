/* The goal is to sort a long list of words by special order. The special
order is as follows. All the words are sorted by the 'greatest' character in
that word which should come first. 'Greatest'
means furthest along in the alphabet. 
For words that have the same greatest character (e.g. "salt" and "table",
which both feature a 't' as their greatest character), these should be sorted
REVERSE alphabetically. */

public class lab3QuickSort{
    public static void main(String [] args)
    {
    String [] array= {"one","two","three","four", "five","six","seven","eight","nine","ten",""};
    
    
    array=quickSort(array, 0, array.length-1);
    
    for(int j=0; j<array.length; j++)
    {
    System.out.println(array[j]);
    }
    
    }
    
            public static String[] quickSort(String[] array, int start, int end)
            {
           
                if(start==end)
                {
                return array;
                }
           
                   int i = start;
                   int j = end;
           
                   if (j - i >= 1)
                   {
                       String pivot = array[i];
                       int pivotA = aschii(pivot);
                     
                       
                       while (j > i)
                       {
                       
                            System.out.println("pivoting");
                           while (aschii(array[i])<=pivotA  && i < end && j > i){
                               i++;
                           }
                           while (aschii(array[j])>=pivotA  && j > start && j >= i){
                               j--;
                           }
                           
                           if (j > i || (j==i && array[j].compareTo(array[i]) > 0)) {   
                               swap(array, i, j);
                           }
                       }
                       swap(array, start, j);
                       quickSort(array, start, j - 1);
                       quickSort(array, j + 1, end);
                     
                   }
                    return array;
            }
    
       private static void swap(String[] a, int i, int j)
       {
            String temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    
       }
       
       private static int aschii(String s)
       {
            int maxaschii =0;
           
            for(int i=0; i<s.length(); i++)
            {
            int n=(int)s.charAt(i);
            String m=Integer.toBinaryString(n);
            int decimal=Integer.parseInt(m,2);
           
                if(decimal>maxaschii)
                {
                    maxaschii=decimal;
                }
            }
            return maxaschii;
       }
    
    }