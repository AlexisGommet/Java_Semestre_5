/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import java.util.Scanner;
/**
 *
 * @author ROG
 */
public class CompteEpargne extends Compte {
    

    private Scanner lectureClavier = new Scanner(System.in);

    
    private void controleTaux(){
        
      while (taux < 0){
            System.out.println("\nTaux invalide");
            System.out.println("Veuillez entrez un chiffre positif");
            taux = lectureClavier.nextInt();
        }  
    }
     
    
    public void CompteEpargne(Compte compte,int choixmenu,boolean tableauvide){

        Compte(choixmenu,compte,tableauvide);
              
        controleTaux();
        
        ecriturecompte(compte);
        
        System.out.println("\nType du compte: "+ strcompte);               
        System.out.println("Numéro de compte: "+ numcompte);
        System.out.println("Première valeur créditée: "+ valcreditee);       
        System.out.println("Taux de placement: "+ taux);
        compte.strcompte = strcompte;
        compte.numcompte = numcompte;
        compte.valcreditee = valcreditee;
    }
} 

