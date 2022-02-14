/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;
import java.util.*;
/**
 *
 * @author ROG
 */
public class Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        int choixmenu; 
        int choixcompte;
        int numcompte = 0;
        int valcréditée;       
        int k =0;
        int numcompteaff = 0;
        int tauxplacement = 0;
        boolean tabsearch = false; 
        String strcompte = "rien";
        int sommecred = 0;
        String dateop;
        int motif;
        int modepaye;
        boolean check = false;
        int search = 0;
        
                
        Scanner lectureClavier = new Scanner(System.in);
        
        
        int[][] tabcompte = new int[10][5];
        String [][] tabcomptable = new String[10][6];
        
    while (check == false){
        
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
                tabsearch = false;
                for (int i = 0; i < tabcompte.length; i++) {
                    
                    while (tabsearch == false){
                        
                        if (tabcompte[i][4] == 0){
                            search = i;
                            tabsearch = true;
                            
                   }
                        
                               
                    }           
                }        
                    
                
                tabcompte [search][0] = choixcompte;
                
                System.out.println("Veuillez entrez le numéro de compte");
                numcompte = lectureClavier.nextInt();
                tabsearch = false;
                for (int i = 0; i < tabcompte.length; i++) {
                    
                    while (tabsearch == false){
                        
                        if (tabcompte[i][4] == 0){
                            search = i;
                            tabsearch = true;
                            
                   }
        
                    }           
                }        
                tabcompte [search][1] = numcompte;
                
                System.out.println("Veuillez entrez la première valeur créditée");
                valcréditée = lectureClavier.nextInt();
                for (int i = 0; i < tabcompte.length; i++) {
                    if (tabcompte[i][1] == numcompte){
                        
                        tabcompte [k][2] = valcréditée;
                        
                            if (tabcompte [k][0] != 3){
                                
                                tabcompte [k][4] = 1;   
                               
                }
                    }
                        
                            
                               
                
                   
                    
                }
                if (choixcompte == 3){
                    System.out.println("Veuillez entrez le taux de placement");
                    tauxplacement = lectureClavier.nextInt();
                
                
                   
                    
                    while ((tauxplacement>100) | (tauxplacement<1)){
                        System.out.println("Veuillez entrez un chiffre entre 1 et 100");
                        tauxplacement = lectureClavier.nextInt();
                    }
                
                for (int i = 0; i < tabcompte.length; i++) {
                    
                    if (tabcompte[i][0] != numcompte){
                        k = k+1;
                    }
                        else {
                            tabcompte [k][3] = tauxplacement;
                            tabcompte [k][4] = 1;   
                               
                }
                   
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
                
                tabsearch = false;
                System.out.println("Veuillez entrez un numéro de compte à afficher");
                
                
                while (tabsearch == false) {          
                    
                    numcompteaff = lectureClavier.nextInt();
                    for (int i = 0; i < tabcompte.length; i++) {
                    if (numcompte == tabcompte [i][1]) {
                        tabsearch = true;
                        search = i;
                        
                    
                }
                }
                  
                    if (tabsearch == false){
                    System.out.println("Ce numéro de compte n'existe pas");
                    System.out.println("Veuillez entrez un numéro de compte à afficher");
                    }
                }
                
                if (tabsearch == true){
                        System.out.println("Numéro de compte :"+ tabcompte [search][1]);
                        if (tabcompte [search][0] == 1){
                            System.out.println("Type de compte :Courant");
                }
                
                        if (tabcompte [search][0] == 2){
                            System.out.println("Type de compte :Joint");
                            
                        }
                        if (tabcompte [search][0] == 3){
                            System.out.println("Type de compte :Epargne");
                        }    
                
                        
                        System.out.println("Solde :"+ tabcompte [search][2]);
                        if (tabcompte [search][0] == 3){
                            System.out.println("Taux de placement :"+ tabcompte [search][3]);
                        
                        }
                }  
                
                break;
            case 3:
                
                tabsearch = false;
                System.out.println("Veuillez renseignez le numéro du compte");
                
                while (tabsearch == false) {          
                    
                    numcompteaff = lectureClavier.nextInt();
                    for (int i = 0; i < tabcompte.length; i++) {
                    if (numcompteaff == tabcompte [i][1]) {
                        tabsearch = true;
                        search = i;
                        
                    
                }
                }
                  
                    if (tabsearch == false){
                    System.out.println("Ce numéro de compte n'existe pas");
                    System.out.println("Veuillez entrez un numéro de compte à afficher");
                    }
                }
                
                
                
                System.out.println("Veuillez renseignez la somme a créditer");
                sommecred = lectureClavier.nextInt();
                System.out.println("Veuillez renseignez la date de l'opération");
                dateop = lectureClavier.nextLine();
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
                tabsearch = false;
                for (int i = 0; i < tabcomptable.length; i++) {
                    
                    while (tabsearch == false){
                        
                        if (tabcomptable[i][5] == String.valueOf(0)){
                            tabsearch = true;
                            search = i;
                        
                    }               
                    }
                    }
                tabcomptable [search][0] = String.valueOf(numcompteaff);
                tabcomptable [search][5] = String.valueOf(1);
                tabcomptable [search][1] = String.valueOf(sommecred);
                tabcompte [search][2] = tabcompte [search][2] + sommecred;
                tabcomptable [search][2] = dateop;
                if (motif == 1){
                tabcomptable [search][3] = "Salaire";
                }
                if (motif == 2){
                tabcomptable [search][3] = "Loyer";
                }
                if (motif == 3){
                tabcomptable [search][3] = "Alimentation";
                }
                if (modepaye == 1){
                tabcomptable [search][4] = "CB";
                }
                if (modepaye == 2){
                tabcomptable [search][4] = "Chèque";
                }
                if (modepaye == 3){
                tabcomptable [search][4] = "Virement";
                }
                
                break;
            case 4:
                
                check = true;
                break;        
                        
                        
                
                
        
                
          
                
        }       
                    
                        
                
                
        
    }                
    }
    
}
    
    

