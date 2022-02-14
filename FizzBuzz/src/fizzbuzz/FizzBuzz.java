/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fizzbuzz;
import static java.lang.Math.floor;

/**
 *
 * @author ROG
 */
public class FizzBuzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double i = 1.00;
        double a = 1.00;
        double j = 1.00;
        boolean entier_a = false;
        boolean entier_j = false;
        boolean both = false;
        boolean écriture = false;
        
        while(i<=100){
            écriture = false;
            a = i;
            a = a/3;
        
            if(floor(a) == a) {
                entier_a= true;
            }    
            else {
                entier_a = false;
            }
            j = i;
            j = j/5;
        
            if(floor(j) == j) {
                entier_j= true;
            }    
            else {
                entier_j = false;
            }
            if(entier_a | entier_j == false){
                both = false;
            }
            if(entier_a & entier_j == true){
                System.out.println("FizzBuzz");
                écriture = true;
                both = true;     
            }
            if(entier_a == true){
                if(both == false){
                    System.out.println("Fizz");
                    écriture = true;
                }
            }
            if(entier_j == true){
                if(both == false){
                    System.out.println("Buzz");
                    écriture = true;
                }
            }
            if((entier_a == false) & (entier_j == false)){
                System.out.println(i);
                écriture = true;
            }
            if(écriture == false){
                System.out.println(i);
            }
            i++;
        }    
    }  
}
    

