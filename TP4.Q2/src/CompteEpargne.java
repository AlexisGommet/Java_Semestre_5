/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.q2;
import java.util.Scanner;
/**
 *
 * @author ROG
 */
public class CompteEpargne extends Compte {
    

    private int taux = 0;
    private Scanner lectureClavier = new Scanner(System.in);

    
    private void controleTaux(){
        
      while (taux < 0){
            System.out.println("");
            System.out.println("Taux invalide");
            System.out.println("Veuillez entrez un chiffre positif");
            taux = lectureClavier.nextInt();
        }  
    }
    
    
    public void CompteEpargne(Compte compte,int choixmenu,Compte[] tabcompte){

        Compte(choixmenu,tabcompte,compte);
        System.out.println("Veuillez entrez le taux de placement");
        taux = lectureClavier.nextInt();

        controleTaux();
        
        ecriturecompte(tabcompte,compte,taux);
        
        System.out.println("");
        System.out.println("Type du compte: "+ strcompte);               
        System.out.println("Numéro de compte: "+ numcompte);
        System.out.println("Première valeur créditée: "+ valcreditee);       
        System.out.println("Taux de placement: "+ taux);
        compte.strcompte = strcompte;
        compte.numcompte = numcompte;
        compte.valcreditee = valcreditee;
        tricompte(tabcompte);
    }
} 

