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
public class CompteEpargne extends Compte {
    

    private int taux; 
    private Scanner lectureClavier = new Scanner(System.in);
    
    private void controleTaux(){
        
      while (taux < 0){
            System.out.println("Taux invalide");
            System.out.println("Veuillez entrez un chiffre positif");
            taux = lectureClavier.nextInt();
        }  
    }
    
    public void CompteEpargne(int choixmenu,Compte compte){

        Compte(choixmenu);
        System.out.println("Veuillez entrez le taux de placement");
        taux = lectureClavier.nextInt();

        controleTaux();

        System.out.println("Type du compte :"+ strcompte);               
        System.out.println("Numéro de compte :"+ numcompte);
        System.out.println("Première valeur créditée :"+ valcreditee);       
        System.out.println("Taux de placement :"+ taux);
        compte.strcompte = strcompte;
        compte.numcompte = numcompte;
        compte.valcreditee = valcreditee;
    }
    
    public void Afficher_Compte(){       
        System.out.println("Taux de placement :"+ taux);      
    }
} 

