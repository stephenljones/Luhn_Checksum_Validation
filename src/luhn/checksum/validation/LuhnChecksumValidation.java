/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luhn.checksum.validation;

import java.util.Scanner;

/**
 *
 * @author stephenjones
 */
public class LuhnChecksumValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        startProgram();
      }
    
    public static void startProgram(){
        
        int selection;
        
        System.out.println("Choose from the following options: \n1. Find check bit for a number \n2. Validate number");
        
        Scanner in = new Scanner(System.in);
        
        selection = in.nextInt();
        
        if(selection == 1){
            
            startFindCheckBit();
        }
        
        else if(selection == 2){
            
            startValidateNumber();
        }
        
        else{
            
            System.out.println("Invalid selection. Please try again. \n");
            startProgram();
        }
        
    }

    public static void startValidateNumber(){
        
        String number;
         
         int sum = 0;
         int mod;
                  
        //user inputs number
        System.out.println("Enter a number to validate: ");
        
        //create new Scanner object
        Scanner in = new Scanner(System.in);
        
        //read user input
        number = in.next();
       
        sum = addSingle(number);
        
        System.out.println(validate(sum));
     }
    
    public static String validate(int number){
        
        int mod;
        String validate;
        
        mod = number % 10;
         
         if(mod == 0){
             validate = "Number is valid.";
         }
         else
             validate = "Number is not valid";
         
         return validate;
    }
    
    public static void startFindCheckBit(){
         
        String numberInput;
        int number;
        int checkBit;
        
        //user inputs number
        System.out.println("Enter a number between 0-9:");
        
        //create new Scanner object
        Scanner in = new Scanner(System.in);
        
        //read user input
        numberInput = in.next();
        
        //sums total of doubled numbers
        number = add(numberInput);
        
        //calculates check bit and adds it to doubled numbers
        checkBit = number + createCheckBit(number);
        
        //***THIS AND THE CHECK BIT SHOULD ALWAYS ADD UP TO NUMBER DIVISIBLE BY 10***
        System.out.println("Sum of numbers and check bit : " + checkBit);
    }
   
    public static int createCheckBit(int number){
        
        int num = number;
        int mod;
        
        mod = 10 - (num % 10);
        if(mod == 0 || mod == 10){
            
            System.out.println("Check bit is: 0");
        }
        else
            System.out.println("Check bit is: " + mod);
        
        return mod;
      }  

    //Calculates by doubling every other int beginning with first int on right
    public static int add(String number){
        
        int num = 0;
        int sum = 0;
        int numLength;    
        
        boolean twice = true;
        
        numLength = number.length();
                
        for(int i = numLength - 1; i >= 0; i--){
           
           if (twice){
                num = doubleInt((int) number.charAt(i) - 48);
                sum = sum + num;
                twice = false;
            }
            else{
                num = (int) number.charAt(i) - 48;
                sum = sum + num;
                twice = true;
            }
        
        }
            return sum;
}
    
    public static int doubleInt(int number){
        
        //doubles input number
        int doubleNumber = number * 2;
        
        //adds digits if doubled number is greater than 9
        //can't use this to create check bit because 5*2 is 10 and adds to 1 but mods to 0 
        if(doubleNumber > 9){
            
           doubleNumber = 1 + (doubleNumber % 10);
           
        }
           else
               doubleNumber = doubleNumber % 10;
         
        return doubleNumber;
    }
    
    public static int addSingle (String number){
        
        int num = 0;
        int sum = 0;
        int numLength;
        boolean twice = false;
        
        numLength = number.length();
                
        for(int i = numLength - 1; i >= 0; i--){
           
           if (twice){
                num = doubleInt((int) number.charAt(i) - 48);
                sum = sum + num;
                twice = false;
            }
           
            else{
                num = ((int) number.charAt(i) - 48);
                sum = sum + num;
                twice = true;
            }
           
        }
            return sum;
    }
    
    public static String validateNumber(int number){
        
        int num = number;
        int mod;
        String validate;
        
        mod = num % 10;
        
        if (mod == 0){
            
            validate = "This number is valid";
        }
        else
            validate = "This number is not valid";
        
        return validate;  
    }
}
