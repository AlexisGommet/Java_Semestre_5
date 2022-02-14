/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author ROG
 */
public class LigneComptable {
    
    private static Scanner lectureClavier = new Scanner(System.in);
    private int motif;
    private int modepaye;
    private int sommecred;
    private int numcompteaff;
    private String dateop;
    private String strmotif;
    private String strmodepaye;
    //private boolean search = false;


    public int creerLigneComptable(Compte compte,ArrayList tabcomptable,ArrayList tabcompte){
        
        
        boolean tabsearch = false;
        System.out.println("\nVeuillez entrez le numéro de compte");
        int search = 0;

        while (!tabsearch) {          
            numcompteaff = lectureClavier.nextInt();
            for (int i = 0; i < tabcompte.size(); i++) {
                if(tabcompte.get(i) != null){
                    Compte co = new Compte();
                    co = (Compte)tabcompte.get(i);
                    if(!tabsearch){
                        if (numcompteaff == co.getnumcompte(i,tabcompte)){
                            tabsearch = true;
                            search = i;
                        }
                    }
                }
            }
            if (!tabsearch){
                System.out.println("\nCe numéro de compte n'existe pas");
                System.out.println("Veuillez entrez un numéro de compte à afficher");
            }
        }
            
        System.out.println("\nVeuillez renseignez la somme a créditer");
        sommecred = lectureClavier.nextInt();
        
//      débit ou crédit sans tableau de comptes        
//      compte.valcreditee = compte.valcreditee + sommecred;

//      débit ou crédit avec tableau de comptes  
//      tabcompte[search].valcreditee = tabcompte[search].valcreditee + sommecred;

        Compte co2 = new Compte();
        co2 = (Compte)tabcompte.get(search);
        co2.valcreditee = co2.valcreditee + sommecred;
        
        System.out.println("\nVeuillez renseignez la date de l'opération sous le format : jj/mm/aaaa");
        dateop = lectureClavier.next();
        
        System.out.println("\nVeuillez renseignez le motif de la modification");
        System.out.println("1. Salaire");
        System.out.println("2. Loyer");
        System.out.println("3. Alimentation");
        motif = lectureClavier.nextInt();

        while ((motif<1) | (motif>3)){
            System.out.println("\nMotif invalide");
            System.out.println("Veuillez renseignez un chiffre entre 1 et 3");
            motif = lectureClavier.nextInt();
        }
        System.out.println("\nVeuillez renseignez le mode de paiement");
        System.out.println("1. CB");
        System.out.println("2. Chèque");
        System.out.println("3. Virement");
        modepaye = lectureClavier.nextInt();

        while ((modepaye<1) | (modepaye>3)){
            System.out.println("\nMode de paiement invalide");
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
        return search;
        
//        écriture dans le tableau de Lignes Comptables et gestion du tableau si plein avec les 2 méthodes ci-dessous

//        ecriturelc(compte,tabcomptable);
//        if(!search){
//            tableauplein(compte,tabcomptable);
//      }
    }
    
    /*
    public void tableauplein(Compte compte,tabcomptable[]){
        
        try{
            for(int i = 0; i < tabcomptable.length; i++){
                for(int p = 0; p < tabcomptable[i].length ; p++){
                    tabcomptable[i][p] = tabcomptable [i+1][p];                   
                }    
            }
        }
        catch(ArrayIndexOutOfBoundsException e){}            
        tabcomptable[9][0] = String.valueOf(compte.numcompteaff);
        tabcomptable[9][1] = String.valueOf(sommecred);
        tabcomptable[9][2] = dateop;
        tabcomptable[9][3] = strmotif;
        tabcomptable[9][4] = strmodepaye;
    }
    
    
    public void ecriturelc(Compte compte,tabcomptable[]){
        
        
        search = false;
        for(int i = 0; i < tabcomptable.length ; i++){
            if(!search){
                if(tabcomptable[i][0] == null){
                    tabcomptable[i][0] = String.valueOf(compte.numcompteaff);
                    tabcomptable[i][1] = String.valueOf(sommecred);
                    tabcomptable[i][2] = dateop;
                    tabcomptable[i][3] = strmotif;
                    tabcomptable[i][4] = strmodepaye;
                    search = true;        
                }
            }    
        }
    }
    */
    
    
    public void afficherLigneComptable(){
        
        System.out.println("\nNuméro de compte: "+ numcompteaff);
        System.out.println("Somme créditée: "+ sommecred);
        System.out.println("Date de l'opération: "+ dateop);
        System.out.println("Motif de l'opération: "+ strmotif);
        System.out.println("Mode de paiement: "+ strmodepaye);
        
    }
    
    public void afficherLigneComptable2(ArrayList tabcompte,int search,int p){
        
        Compte lc3;
        lc3 = (Compte)tabcompte.get(search);
        LigneComptable lc2;
        lc2 = lc3.tabcomptable.get(p);

        
        if(lc2.numcompteaff == lc3.getnumcompte(search,tabcompte)){              
            System.out.println("Compte: "+lc2.numcompteaff+"  Somme créditée :"+lc2.sommecred+"  Date de l'opération: "+lc2.dateop+"  Motif: "+lc2.strmotif+"  Mode de paiement : "+lc2.strmodepaye);
        }      
    }       
}
