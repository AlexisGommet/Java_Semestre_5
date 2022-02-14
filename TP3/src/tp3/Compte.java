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
public class Compte {
    
    protected String strcompte;
    protected int choixcompte;
    protected int numcompte;
    protected int valcreditee;
    protected int numcompteaff;
    public Scanner lectureClavier = new Scanner(System.in);
    public CompteEpargne ce = null;

    public void CreerCompteEpargne(int choixmenu,Compte compte){
        ce = new CompteEpargne();
        ce.CompteEpargne(choixmenu,compte);
    }
      
    public void Compte(int choixmenu) {

    if(choixmenu == 1){
        System.out.println("Veuillez choisir le type de compte");
        System.out.println("Courant ou joint");
        System.out.println("1. Courant");
        System.out.println("2. Joint");
        choixcompte = lectureClavier.nextInt();
        while((choixcompte<1) | (choixcompte>2)){
            System.out.println("Choix de compte invalide");
            System.out.println("Veuillez entrez 1 ou 2");
            choixcompte = lectureClavier.nextInt();
        }
    }

    if (choixcompte == 1){
        strcompte = ("Courant");
    }
    if (choixcompte == 2){
        strcompte = ("Joint");
    }
    if(choixmenu == 2){
        strcompte = ("Epargne");
        choixcompte = 3;
    }

    System.out.println("Veuillez renseignez le numéro du compte");
    numcompte = lectureClavier.nextInt(); 

    System.out.println("Veuillez entrez la première valeur créditée");
    valcreditee = lectureClavier.nextInt();
    
    if(choixcompte != 3){
        System.out.println("Type du compte :"+ strcompte);               
        System.out.println("Numéro de compte :"+ numcompte);
        System.out.println("Première valeur créditée :"+ valcreditee);
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
        if(strcompte == "Epargne"){
            ce.Afficher_Compte();
        }
    }
}
