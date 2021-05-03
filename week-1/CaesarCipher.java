
/**
 * Write a description of CaesarCipher here.
 * 
 * @author krishna 
 * @version 3/5/21
 */

import edu.duke.*;
public class CaesarCipher {
   
    private String alphabet ;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        mainKey=key;
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet= alphabet.substring(key)+ alphabet.substring(0,key);
      
    }
    
    public String  encrypt(String input){
    
        int count=0;
        StringBuilder s = new StringBuilder(input);
        for(int i=0; i<s.length();i++){
         count=0;
         char e =  s.charAt(i);
         if(Character.isUpperCase(e)){
            count=1;
            }
         int idx = alphabet.indexOf(Character.toUpperCase(e));
         if(idx!=-1){
            
             char d = shiftedAlphabet.charAt(idx);
             if(count==1){
                 s.setCharAt(i,d);
                }
              else{
                 s.setCharAt(i,Character.toLowerCase(d));
                }
             
             
             
            }
            
        }
        return s.toString();
    }
    
    public String decrypt(String input){
    
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }
    
    


}
 
