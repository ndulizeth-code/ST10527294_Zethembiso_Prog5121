/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
public class LoginSystem {
    static Scanner input = new Scanner(System.in);
    //------------------ Static Methods ------------------
    
    //Check if username contains"_"and max 5 characters
    public static boolean checkUserName(String username){
        return username.contains("_") && username.length() <= 5;
    }
    //Check if password has atleast 8 characters,capital letter,number, and special character
    public static boolean checkPasswordComplexity(String password){
        String regex ="^(?=.*k[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }
    //Check if cellphonenumber is valid (27+ folowed by 9 digits)
    public static boolean checkCellPhoneNumber(String number) {
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, number);
    }
    
    // Register user and validate username and password
    public static String registerUser(String username,String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted;please ensure that the password contains at least eight chgaracters,a capital letter,a number,and a special character";
        }
        return "username and password correct";
    }
     // login User by checking stored Username and password
    public static boolean loginUser(String username , String password, String storedUsername, String storedPassword) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
    
    //Show login message
    public static String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome<user first name>,<user last name>it is great to see you again";
        }
        else {
        return "Username or password incorrect,please try again.";
    }
}   
        //--------- Main Method ---------
        
        public static void main(String[] args) {
            
            String storedUsername ="";
            String storedPassword ="";
            String cellPhone;
            
            //---------Registration---------
            //Loop until valid username
            String username;
            while (true) {
                System.out.print("Enter Username (must contain '_' and max 5 chars): ");
                username = input.nextLine();
                if (checkUserName(username)) {
                    System.out.println("Username successfully captured");
                    break;
                } else {
                System.out.println("Username is not corrctly formatted,please ensure that your username contains an underscore and no more that five characters in length");
            }
            
            //Loop until valid password
            String password;
            while (true) {
                System.out.print("Enter Password (must have 8+ chars, 1 capital, 1 number, 1 special char): ");
                password = input.nextLine();
                if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted,please ensure that the password contains at at least eight characters,a capital letter, a number and a special character");
            }
            
            //Register user
            String registerMessage = LoginSystem.registerUser(username, password);
            System.out.println(registerMessage);
            storedUsername = username;
            storedPassword = password;
            
            //Loop until valid cell Phone
            while (true) {
                System.out.print("Enter CellPhone (+27 and followed by 9 digits): ");
                cellPhone = input.nextLine();
                if (checkCellPhoneNumber(cellPhone)) {
                    System.out.println("Cell Phone Number successfully added");
                    break;
                } else {
                System.out.println("Cell phone number incorectly formatted or does not contain international code");
            }    
                //--------- Lgin Section ---------
                System.out.println("\nlogin");
                
                String loginUser;
                String loginPass;
                boolean status;
                
            while (true) {
                    System.out.print("Enter Username: ");
                    loginUser = input.nextLine();
                    
                    System.out.print("Enter Password: ");
                    loginPass = input.nextLine();
                    
                 status = LoginSystem.loginUser(loginUser, loginPass , storedUsername , storedPassword);
                  
                 System.out.println(LoginSystem.returnLoginStatus(status));
                  
                    if (status) break; // End loop on successful login
                }
        }
        }
            }
        }
}
            
