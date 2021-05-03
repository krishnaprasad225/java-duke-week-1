
/**
 * Write a description of testCaesarCipher here.
 * 
 * @author krishna prasad peram
 * @version 03-May-2021
 */
 import edu.duke.*;
 import java.util.*;
public class TestCaesarCipher{

  public int[] countLetters(String s){
        String alpha= "abcdefghijklmnopqrstuvwxyz";
        int[] hmm = new int[26];
        for(int i=0; i<s.length(); i++){
             int p=alpha.indexOf( Character.toLowerCase(s.charAt(i)) );
             if(p!=-1){
                 hmm[p]+=1;
                }
        }
        return hmm;
    }
    
    public int indexOfMax(int[] values){
     int max=0;
     int ans=0;
     for(int i=0; i<values.length;i++){
        if(values[i]>max){
         max=values[i];
         ans=i;
        }

    }
    return ans;
   }
   
   public void simpleTests(){
       
       Scanner sc = new Scanner(System.in);
       FileResource fr = new FileResource();
       String message = fr.asString();
       System.out.println("Enter key : ");
       CaesarCipher cd = new CaesarCipher(sc.nextInt());
       String p = cd.encrypt(message);
      System.out.println("Encrypted String : "+p);
       String de = cd.decrypt(p);
       System.out.println("Decrypted String : "+de);
       
       
      String o = breakCaesarCipher(message);
      System.out.println("Breaking key and decrypted msg : "+o); 
    }
    
    public String breakCaesarCipher(String input){
     
        int k = getkey(input);
        System.out.println("key : "+k);
        CaesarCipher ce = new CaesarCipher(k);
        String lop = ce.decrypt(input);
        return lop;
        
    }
   
   public int getkey(String s){
 
        int maxDex = indexOfMax(countLetters(s));
        int dkey= maxDex-4;
        if(maxDex<4){
         dkey= 26 - (4-maxDex);
        }
        return dkey;    
        }
 }

