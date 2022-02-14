/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_java;


import java.util.Scanner;

/**
 *
 * @author ROG
 */
public class TP1_JAVA {
    
    /**
     * @param args the command line arguments
     */
   
// 2ème méthode pour AfficherCompte avec variable de classe
//    
//  int static numcompteaff;
//  int static numcompte;
//  String static strcompte;
//  int static valcréditée;
//  int static tauxplacement;
//  int static choixcompte;

 //public static void Afficher_Compte(){
 //       
 //       Scanner lectureClavier = new Scanner(System.in);
 //       System.out.println("Veuillez entrez un numéro de compte à afficher");
 //       numcompteaff = lectureClavier.nextInt();
 //                   
 //       while(numcompteaff != numcompte){              
 //           System.out.println("Ce numéro de compte n'existe pas");
 //           System.out.println("Veuillez entrez un numéro de compte valide");
 //           numcompteaff = lectureClavier.nextInt();
 //       }
 //                   
 //       System.out.println("Type de compte :"+ strcompte);
 //       System.out.println("Numéro de compte :"+ numcompteaff);
 //       System.out.println("Solde :"+ valcréditée);
 //       if (choixcompte == 3){
 //           System.out.println("Taux de placement :"+ tauxplacement);
 //       }
 //       
 //   }
    
    static Scanner lectureClavier = new Scanner(System.in);
    
    public static int Menu_Principal(){
        
        
        int choixmenu1; 
        System.out.println("1. Créer un compte");
        System.out.println("2. Afficher un compte");
        System.out.println("3. Créer une ligne comptable");
        System.out.println("4. Sortir");
        System.out.println("Veuillez choisir l'action a effectuée");
        choixmenu1 = lectureClavier.nextInt();

        while((choixmenu1<1) | (choixmenu1>4)){
                
            System.out.println("Veuillez entrez un nombre entre 1 et 4");
            choixmenu1 = lectureClavier.nextInt();
        }
        return choixmenu1;
    }
    
   
    public static void Afficher_Compte(int numcompteaff,int numcompte,String strcompte,int valcréditée,int tauxplacement, int choixcompte){
        
   
        System.out.println("Veuillez entrez un numéro de compte à afficher");
        numcompteaff = lectureClavier.nextInt();
                    
        while(numcompteaff != numcompte){              
            System.out.println("Ce numéro de compte n'existe pas");
            System.out.println("Veuillez entrez un numéro de compte valide");
            numcompteaff = lectureClavier.nextInt();
        }
                    
        System.out.println("Type de compte :"+ strcompte);
        System.out.println("Numéro de compte :"+ numcompteaff);
        System.out.println("Solde :"+ valcréditée);
        if (choixcompte == 3){
            System.out.println("Taux de placement :"+ tauxplacement);
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
    
    
        int choixmenu;
        int choixcompte = 0;
        int numcompte = 0;
        int valcréditée = 0;       
        int numcompteaff = 0;
        int tauxplacement = 0; 
        String strcompte = "";
        int sommecred = 0;
        int motif;
        int modepaye;
        String dateop;
        String strmotif;
        String strmodepaye;
        boolean check = false;
        
                     
        while (check == false){

            choixmenu = Menu_Principal();
                    
            switch(choixmenu){


                case 1:


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
                    valcréditée = lectureClavier.nextInt();
                    
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
                    System.out.println("Première valeur créditée :"+ valcréditée);
                    if (choixcompte == 3){
                        System.out.println("Taux de placement :"+ tauxplacement);
                    }
                    break;

                case 2:
                    
                    Afficher_Compte(numcompteaff,numcompte,strcompte,valcréditée,tauxplacement,choixcompte);
                    
//                  2ème méthode  
//                  Afficher_Compte();
                 
                    break;
                    
                case 3:

                    System.out.println("Veuillez renseignez le numéro du compte");
                    numcompteaff = lectureClavier.nextInt();

                        while (numcompteaff != numcompte){
                            System.out.println("Ce numéro de compte n'existe pas");
                            System.out.println("Veuillez entrez un numéro de compte valide");
                            numcompteaff = lectureClavier.nextInt();
                        }

                    System.out.println("Veuillez renseignez la somme a créditer");
                    sommecred = lectureClavier.nextInt();
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

                    break;
                    
                case 4:
                    
                    check = true;
                    
                    break;                                 

            }        
        }                
    }
    
}
