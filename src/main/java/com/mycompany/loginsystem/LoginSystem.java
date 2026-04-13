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
            return "Username is not correct , Must have _ and max 5 chars";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correct , Must have 8+ chars, capital letter,number,and a special character";
        }
        return "Username and password successfully captured. User registered!";
    }
     // login User by checking stored Username and password
    public static boolean loginUser(String username , String password, String storedUsername, String storedPassword) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
    
    //Show login message
    public static String returnloginStatus(boolean status) {
        if (status) {
            return "Login successful! Welcome back!";
        }
        else {
        return "Username or Password incorrect, please try again";
    }
}   
        //--------- Main Method ---------
        
        public static void main(String[] args) {
            
            String storedUsername = "";
            String storedPassword = "";
            String cellPhone;
            
            //---------Registration---------
            //Loop until valid username
            String username;
            while (true) {
                System.out.print("Enter Username (must contain '_' and max 5 chars): ");
                username = input.nextLine();
                if (checkUserName(username)) break;
                System.out.println("Invalid username. Example: user_");
            }
            
            //Loop until valid password
            String password;
            while (true) {
                System.out.print("Enter Password (8+ chars, 1 capital, 1 number, 1 special char): ");
                password = input.nextLine();
                if (checkPasswordComplexity(password)) break;
                System.out.println("Invalid password. Example: Password1!");
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
                String cellphone = null;
                if (checkCellPhoneNumber(cellphone)) {
                    System.out.println("Cell Phone Number successfully added");
                    break;
                }
                System.out.println("Invalid number. Must start with +27 followed by 9 digits. Example: +27234567890");
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
                    
                    status = LoginSystem.loginUser(loginUser, loginPass, storedUsername, storedPassword);
                    
                    System.out.println(LoginSystem.returnloginStatus(status));
                  
                    if (status) break; // End loop on successful login
                }
        }
}
