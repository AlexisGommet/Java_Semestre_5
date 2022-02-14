/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.q2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ROG
 */
public class TP4Q2 {


    static public Scanner lectureClavier = new Scanner(System.in);
    static private int choixmenu = 0;
    static public Compte compte = null;
    static Compte[] tabcompte = new Compte [10];
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean check = false;
        

        
        while(!check){
            
            System.out.println("");
            System.out.println("1. Créer un compte simple");
            System.out.println("2. Créer un compte Epargne ");
            System.out.println("3. Créer une ligne comptable");
            System.out.println("4. Afficher un compte");
            System.out.println("5. Sortir");
            System.out.println("");
            System.out.println("Veuillez choisir l'action a effectuée");
            choixmenu = lectureClavier.nextInt();

            while((choixmenu<1) | (choixmenu>5)){
                System.out.println("");
                System.out.println("Choix invalide");
                System.out.println("Veuillez entrez un nombre entre 1 et 5");
                choixmenu = lectureClavier.nextInt();
            }

            switch(choixmenu){
                
                case 1:
                    
                    compte = new Compte();
                    compte.Compte(choixmenu,tabcompte,compte);
                    
                    break;
                    
                case 2:
                    
                    compte = new Compte();
                    compte.CreerCompteEpargne(choixmenu,tabcompte);
                    
                    break;
                    
                case 3:
                    
                    compte.CreerLigne(tabcompte,compte);
                    
                    break;
                    
                case 4:
                    
                    
                    compte.Afficher_Compte(tabcompte,compte.tabcomptable,compte);
                                     
                    break;              
                    
                case 5:
                    
                    System.out.println("Merci de votre visite, à la prochaine fois!");
                    check = true;
                    
                    break;

                
            }
        }
    }    
}

