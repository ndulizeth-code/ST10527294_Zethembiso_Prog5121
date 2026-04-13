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
public class java1 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age");
        int age = input.nextInt();
        if (age>=18){
            System.out.println("you can vote");
        }else {
            System.out.println("you cannot vote");
        }
              
    }
    
}
