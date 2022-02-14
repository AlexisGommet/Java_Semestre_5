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
public class Compte {
    
    public String strcompte;
    public int choixcompte;
    public int numcompte;
    public int valcreditee;
    public int tauxplacement;
    public int numcompteaff;
    public boolean lignecree = false;
    public Scanner lectureClavier = new Scanner(System.in);
    public LigneComptable lc = new LigneComptable();

    
    public void CreerLigne(){
        lc.creerLigneComptable(this);
        lignecree = true;
        AfficherLigne();
    }
    
    public void AfficherLigne(){
        lc.afficherLigneComptable(this);
    }
    

    public void CreerCompte() {

    System.out.println("Veuillez choisir le type de compte");
    System.out.println("Courant, joint ou épargne");
    System.out.println("1. Courant");
    System.out.println("2. Joint");
    System.out.println("3. Epargne");
    choixcompte = lectureClavier.nextInt();

    while((choixcompte<1) | (choixcompte>3)){
        System.out.println("Veuillez entrez un nombre entre 1 et 3");
        choixcompte = lectureClavier.nextInt();
    }
    if (choixcompte == 1){
        strcompte = ("Courant");
    }
    if (choixcompte == 2){
        strcompte = ("Joint");
    }
    if (choixcompte == 3){
        strcompte = ("Epargne");
    }


    System.out.println("Veuillez renseignez le numéro du compte");
    numcompte = lectureClavier.nextInt(); 

    System.out.println("Veuillez entrez la première valeur créditée");
    valcreditee = lectureClavier.nextInt();

    if(choixcompte == 3){
        System.out.println("Veuillez entrez le taux de placement");
        tauxplacement = lectureClavier.nextInt();

        while ((tauxplacement>100) | (tauxplacement<1)){
            System.out.println("Veuillez entrez un chiffre entre 1 et 100");
            tauxplacement = lectureClavier.nextInt();
        }
    }

    System.out.println("Type du compte :"+ strcompte);               
    System.out.println("Numéro de compte :"+ numcompte);
    System.out.println("Première valeur créditée :"+ valcreditee);
    if (choixcompte == 3){
        System.out.println("Taux de placement :"+ tauxplacement);
    }

}
    public void Afficher_Compte(){

        System.out.println("Veuillez entrez un numéro de compte à afficher");
        numcompteaff = lectureClavier.nextInt();

        while(numcompteaff != numcompte){              
            System.out.println("Ce numéro de compte n'existe pas");
            System.out.println("Veuillez entrez un numéro de compte valide");
            numcompteaff = lectureClavier.nextInt();
        }

        System.out.println("Type de compte :"+ strcompte);
        System.out.println("Numéro de compte :"+ numcompteaff);
        System.out.println("Solde :"+ valcreditee);
        if(choixcompte == 3){
            System.out.println("Taux de placement :"+ tauxplacement);
        }
        if(lignecree == true){
            System.out.println("");
            System.out.println("Dernière ligne comptable enregistrée :");
            System.out.println("");
            AfficherLigne();
        }
    }
}
