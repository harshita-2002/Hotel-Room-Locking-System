/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charvi
 */
//import java.util.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    static String s;
    static int num;
    static char arr[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int gcd(int a, int b) 
    { 
        // Everything divides 0  
        if (a == 0) 
          return b; 
        if (b == 0) 
          return a; 
        // base case 
        if (a == b) 
            return a; 
        // a is greater 
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
    } 
    
    public static int[] con(String n)
    {      //This basically converts the name of the person to array of capital letters
                                             // like if input name is charvi---it returns: [C H A R V I]
        int number=0;
        int num[]=new int[n.length()];
        char te[]=new char[n.length()];
        for(int i=0;i<n.length();i++){
            te[i]=n.charAt(i);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<te.length;j++){
                if(te[j]==arr[i]){
              num[j]=i;
                }
            }
        }  
        return num;
    }
    
    public static String encmsg(int ar[]){
        String dec="";
        char charr[]=new char[ar.length];
        for(int i=0;i<ar.length;i++){
            charr[i]=arr[ar[i]];
            dec=dec+Character.toString(charr[i]);
        }
        return dec;
    }
    
    
    public static int[] kg(String a)
    {                         // this method basically generates two keys based on our name as 9 and last letter of our name's number
        int key[]=new int[2];
        try{
            char temp=a.charAt(0);
            char temp1=a.charAt(a.length()-1);
            key[0]=9;//because there should be multiplicative inverse of mod 26 so we should take any number
            for(int i=0;i<arr.length;i++){
                if(temp1==arr[i]){
                    key[1]=i;
                }
            }
            System.out.println("\n\nEncrytion keys for this name\n"+key[0]+" "+key[1]+"\nWe are taking 9 as default key from the keys a,b\n and b will be number of the last letter of the name given\n");
        }
        catch(Exception e){ System.out.println("Enter valid name");System.exit(0);}
        return key;
    }
    
    public static int[] enc(int a[],int k[]){ //encrypting my name to some other numbersusing affine cipher
        int dec[]=new int[a.length];            
        for(int i=0;i<a.length;i++){
            dec[i]=((k[0]*a[i])+k[1])%26;
        }
        return dec;
    }
    
    public static int[] decr(int a[],int k[]){
        int dec[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(a[i]<k[1]){
                dec[i]=(k[0]*(a[i]-k[1]))%26;
                dec[i]=dec[i]+26;
            }
            else{
                dec[i]=(k[0]*(a[i]-k[1]))%26;
            }
        }
        return dec;
    }
    
    public static int modInverse(int a, int m) 
    { 
        a = a % m; 
        for (int x = 1; x < m; x++) 
           if ((a * x) % m == 1) 
              return x; 
        return 1; 
    }
}
