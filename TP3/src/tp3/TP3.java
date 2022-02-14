/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.util.Scanner;

/**
 *
 * @author ROG
 */
public class TP3 {


    static public Scanner lectureClavier = new Scanner(System.in);
    static private int choixmenu = 0;
    static public Compte compte = new Compte();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean check = false;
        

        
        while(!check){
            
            
            System.out.println("1. Créer un compte simple");
            System.out.println("2. Créer un compte Epargne ");
            System.out.println("3. Afficher un compte");
            System.out.println("4. Sortir");
            System.out.println("Veuillez choisir l'action a effectuée");
            choixmenu = lectureClavier.nextInt();

            while((choixmenu<1) | (choixmenu>4)){

                System.out.println("Veuillez entrez un nombre entre 1 et 4");
                choixmenu = lectureClavier.nextInt();
            }

            switch(choixmenu){
                
                case 1:
                    
                    compte.Compte(choixmenu);
                    
                    break;
                    
                case 2:
                    
                    compte.CreerCompteEpargne(choixmenu,compte);
                    
                    break;
                    
                case 3:
                    
                    
                    compte.Afficher_Compte();
                                     
                    break;              
                    
                case 4:
                    
                    System.out.println("Merci de votre visite, à la prochaine fois!");
                    check = true;
                    
                    break;

                
            }
        }
    }    
}
