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
public class LigneComptable {
    
    public static Scanner lectureClavier = new Scanner(System.in);
    public int motif;
    public int modepaye;
    public int sommecred;
    public String dateop;
    public String strmotif;
    public String strmodepaye;
    

    public void creerLigneComptable(Compte compte){
               
        System.out.println("Veuillez renseignez le numéro du compte");
        compte.numcompteaff = lectureClavier.nextInt();

        while (compte.numcompteaff != compte.numcompte){
            System.out.println("Ce numéro de compte n'existe pas");
            System.out.println("Veuillez entrez un numéro de compte valide");
            compte.numcompteaff = lectureClavier.nextInt();
        }

        System.out.println("Veuillez renseignez la somme a créditer");
        sommecred = lectureClavier.nextInt();
        compte.valcreditee = compte.valcreditee + sommecred;
        System.out.println("Veuillez renseignez la date de l'opération sous le format : jj/mm/aaaa");
        dateop = lectureClavier.next();
        System.out.println("Veuillez renseignez le motif de la modification");
        System.out.println("1. Salaire");
        System.out.println("2. Loyer");
        System.out.println("3. Alimentation");
        motif = lectureClavier.nextInt();

        while ((motif<1) | (motif>3)){
            System.out.println("Veuillez renseignez un chiffre entre 1 et 3");
            motif = lectureClavier.nextInt();
        }

        System.out.println("Veuillez renseignez le mode de paiement");
        System.out.println("1. CB");
        System.out.println("2. Chèque");
        System.out.println("3. Virement");
        modepaye = lectureClavier.nextInt();

        while ((modepaye<1) | (modepaye>3)){
            System.out.println("Veuillez renseignez un chiffre entre 1 et 3");
            modepaye = lectureClavier.nextInt();
        }                    

        if (motif == 1){
            strmotif = "Salaire";
        }
        if (motif == 2){
            strmotif = "Loyer";
        }
        if (motif == 3){
            strmotif = "Alimentation";
        }
        if (modepaye == 1){
            strmodepaye = "CB";
        }
        if (modepaye == 2){
            strmodepaye = "Chèque";
        }
        if (modepaye == 3){
            strmodepaye = "Virement";
        }        
        
    }
    public void afficherLigneComptable(Compte compte){
        
        System.out.println("Numéro de compte :"+ compte.numcompteaff);
        System.out.println("Somme créditée :"+ sommecred);
        System.out.println("Date de l'opération :"+ dateop);
        System.out.println("Motif de l'opération :"+ strmotif);
        System.out.println("Mode de paiement :"+ strmodepaye);
        System.out.println("");
        
    }
    
}
