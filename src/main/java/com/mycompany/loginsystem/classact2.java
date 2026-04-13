/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class classact2 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number:");
        int x = input.nextInt();
        if (x > 10){
            System.out.println("numberis big");
        }else {
            System.out.println("Number is small");
        }
    }
    
}
