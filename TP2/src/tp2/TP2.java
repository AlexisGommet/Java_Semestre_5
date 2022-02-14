/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.Scanner;

/**
 *
 * @author ROG
 */
public class TP2 {


    static public Scanner lectureClavier = new Scanner(System.in);
    static public int choixmenu = 0;
    static public Compte compte = new Compte();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean check = false;
        
        

        
        while(check == false){
            
            
            System.out.println("1. Créer un compte");
            System.out.println("2. Afficher un compte");
            System.out.println("3. Créer une ligne comptable");
            System.out.println("4. Sortir");
            System.out.println("Veuillez choisir l'action a effectuée");
            choixmenu = lectureClavier.nextInt();

            while((choixmenu<1) | (choixmenu>4)){

                System.out.println("Veuillez entrez un nombre entre 1 et 4");
                choixmenu = lectureClavier.nextInt();
            }

            switch(choixmenu){
                
                case 1:
                    
                    compte.CreerCompte();
                    
                    break;
                    
                case 2:
                    
                    compte.Afficher_Compte();
                    
                    break;
                
                case 3:
                    
                    compte.CreerLigne();
                    
                    break;
                    
                case 4:
                    
                    System.out.println("Merci de votre visite, à la prochaine fois!");
                    check = true;
                    
                    break;

                
            }
        }
    }    
}
