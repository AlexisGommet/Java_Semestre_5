/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int id_ligne;
    private String dateop;
    private String strmotif;
    private String strmodepaye;
    private int sommecred2;    
    
    public int getnumcompteaff(){
        return numcompteaff;
    }
    
    public int getsommecred2(){
        return sommecred2;
    }
    
    public int getmotif(){
        return motif;
    }
    
    public int getmodepaye(){
        return modepaye;
    }
    
    public int getsommecred(){
        return sommecred;
    }
    
    public String getdateop(){
        return dateop;
    }
    
    public String getstrmotif(){
        return strmotif;
    }
    
    public String getstrmodepaye(){
        return strmodepaye;
    }
    
    public int getid_ligne(){
        return id_ligne;
    }
      
    public void creerLigneComptable(Compte compte,int id_ligne2,boolean tableauvide){
        
        id_ligne = id_ligne2;       
        
        try{
            
            boolean tabsearch = false;
            System.out.println("\nVeuillez entrez le numéro de compte");

            while (!tabsearch) {          
                numcompteaff = lectureClavier.nextInt();
                if(!tableauvide)
                    compte.sqlquery(1);
                    while (compte.getresult().next()) {
                        if (numcompteaff == compte.getresult().getInt("NUMCOMPTE")){
                            tabsearch = true;
                        }
                    }          
                if (!tabsearch){
                    System.out.println("\nCe numéro de compte n'existe pas");
                    System.out.println("Veuillez entrez un numéro de compte à afficher");
                }
            }
            compte.getresult().close();
            compte.getstate().close();

            System.out.println("\nVeuillez renseignez la somme a créditer");
            sommecred = lectureClavier.nextInt();
            
            compte.sqlquery(4);
            sommecred2 = compte.getresult().getInt("VALCREDITEE")+ sommecred;
            compte.sqlquery(5);
            compte.getresult().close();
            compte.getstate().close();

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

            switch (motif) {
                case 1:
                    strmotif = "Salaire";
                    break;
                case 2:
                    strmotif = "Loyer";
                    break;
                case 3:
                    strmotif = "Alimentation";
                    break;
            }
            switch (modepaye) {
                case 1:
                    strmodepaye = "CB";
                    break;
                case 2:
                    strmodepaye = "Chèque";
                    break;
                case 3:
                    strmodepaye = "Virement";
                    break;
            }
            }
            catch (SQLException ex) {
                Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
            }
    }  

      
    public void afficherLigneComptable(){
        
        System.out.println("\nNuméro de compte: "+ numcompteaff);
        System.out.println("Somme créditée: "+ sommecred);
        System.out.println("Date de l'opération: "+ dateop);
        System.out.println("Motif de l'opération: "+ strmotif);
        System.out.println("Mode de paiement: "+ strmodepaye);
        
    }       
}
