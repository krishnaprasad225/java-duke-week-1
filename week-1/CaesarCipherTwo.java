
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
  
    private String alphabet;
    private String   shiftedAlphabet1;
    private String  shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2){
     mainKey1=key1;
     mainKey2=key2;
     alphabet="abcdefghijklmnopqrstuvwxyz";
     shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
     shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
             
    }
    
    public String encrypt(String input){
    
      StringBuilder s = new StringBuilder(input);
     for(int i=0;i<s.length();i++){
         char e=s.charAt(i);
         String o=Character.toString(e);
         if(i%2==0){
             String ans=subencrypt(o,mainKey1);
             char m=ans.charAt(0);
             s.setCharAt(i,m);
             
            }
            else{
             String ans=subencrypt(o,mainKey2);
             char m=ans.charAt(0);
             s.setCharAt(i,m);
            }
        }
        //String p = new String(s);
     return s.toString();
    }
    
    
   private String subencrypt(String input,int key){
        char lol;
     StringBuilder s = new StringBuilder(input);
     String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     String req= alphabet.substring(key)+alphabet.substring(0,key);
     for(int i=0;i<s.length();i++){
         
         int count=0;
         char ch= s.charAt(i);
         if(Character.isLowerCase(ch)){
             
            count=1;
            ch= Character.toUpperCase(ch);
             }
             int index=alphabet.indexOf(ch);
             if(index!=-1){
                 lol=req.charAt(index);
                 if(count==1){
                     lol=Character.toLowerCase(lol);
                     s.setCharAt(i,lol);
                    }
                   else{
                     s.setCharAt(i,lol);
                    }
                 }
        
         }
 
     return s.toString();     
     }
    
    public String decrypt(String input){
    
     CaesarCipherTwo ce = new CaesarCipherTwo(26-mainKey1, 26-mainKey2);
     String decrypted = ce.encrypt(input);
     
     return decrypted;
    
    }
}
