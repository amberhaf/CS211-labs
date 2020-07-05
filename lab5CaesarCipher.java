/* Alice’s public key is (24852977, 2744, 8414508). You eavesdrop on the line and
observe Bob send her the cipher (15268076, 743675). Extract the message by any
means. */

import java.math.BigInteger;
import java.util.Scanner;
public class lab5CaesarCipher {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String [] split=s1.split(" ");
        int p1= Integer.parseInt(split[0]);
        BigInteger p = BigInteger.valueOf(p1);
       
        int g= Integer.parseInt(split[1]);
        int c= Integer.parseInt(split[2]);

        String s2=sc.nextLine();
        String [] split2=s2.split(" ");
        int m1= Integer.parseInt(split2[0]);
        int n1= Integer.parseInt(split2[1]);

        BigInteger x = BigInteger.valueOf(0);
        BigInteger check = BigInteger.valueOf(c);
       
        for(BigInteger i=BigInteger.valueOf(0); i.compareTo(p)<0; i=i.add(BigInteger.valueOf(1)))
        {
            BigInteger big = BigInteger.valueOf(g);
            big = big.modPow(i,p);
            if(big.compareTo(check)==0)
            {
                x=i;
                break;
            }
        }
       
        BigInteger m = BigInteger.valueOf(m1);
        BigInteger z=p.subtract(BigInteger.valueOf(1));
        m=m.modPow(z.subtract(x),p);
         BigInteger n = BigInteger.valueOf(n1);
         n=n.multiply(m);
         n=n.mod(p);
         System.out.println(n);
         
    }
}