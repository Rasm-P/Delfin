/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin;

/**
 *
 * @author Ditlev
 */
public class LoginEncryption {
    
    public static void checkPassword() {
        
    }
        
public static String addSecurePassword(String pass) {
    for(int i = 0; i < pass.length();++i) {
      pass = pass.substring(i, pass.length()-pass.length()/2)+"fs5Sg6" + pass.substring(pass.length()/2, pass.length()-1)  + pass.substring(i, pass.length());
      pass = pass.replace("e", "afe2fDy");
      pass = pass.replace("E", "hgQg6SD");
      pass = pass.replace("A", "nhO?5=2");
      pass = pass.substring(i).replace(".", "*");
        
      return pass;
    }
    return pass;
}    
    public static void main(String[] args) {
        String secure = addSecurePassword("mypassword");
        System.out.println(secure);
        
    }
}
