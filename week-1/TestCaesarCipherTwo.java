import edu.duke.FileResource;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class TestCaesarCipherTwo {
   
    private String halfOfString(String message, int start){
      String lol="";
      
      if(start==0){
        
        for(int i=0; i<message.length(); i+=2){
         lol=lol + message.charAt(i);
        }
        
        }
        
        else{
         for(int i=0; i< (message.length()/2); i++ ){
             lol=lol + message.charAt(2*i+1);
            }
        }
        
      return lol;  
    }
    
    
    private int[] countLetters(String s){
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
    
     private int getkey(String s){
 
        int maxDex = indexOfMax(countLetters(s));
        int dkey= maxDex-4;
        if(maxDex<4){
         dkey= 26 - (4-maxDex);
        }
        return dkey;
    }
    
    
     private int indexOfMax(int[] values){
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
      
       CaesarCipherTwo cc = new CaesarCipherTwo(7,13);
        
       System.out.println(cc);
       
       
    }
    
   private String breakCaesarCipher(String input){
      
      
      String s1 = halfOfString(input,0);
      String s2 = halfOfString(input,1);
      int k1 = getkey(s1);
      int k2 = getkey(s2);
      System.out.println("key1 : "+k1+", key 2 : "+k2);
      CaesarCipherTwo cd = new CaesarCipherTwo(k1,k2);
      String decrypted = cd.decrypt(input);
      //System.out.println("Decrypted String : "+decrypted);
      return decrypted;
    }
}
