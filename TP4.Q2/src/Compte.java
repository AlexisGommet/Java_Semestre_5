/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.q2;


import java.util.*;
import java.lang.*;
import java.io.*;




/**
 *
 * @author ROG
 */

public class Compte implements Comparable<Compte>  {
    
    protected String strcompte;
    protected int choixcompte;
    protected int numcompte;
    protected int valcreditee;
    protected int numcompteaff;
    private boolean noms = false;
    private int taux;
    protected boolean ecriture = false;
    protected int emplacement = 0;
    protected int search = 0;
    ArrayList<LigneComptable> tabcomptable = new ArrayList<LigneComptable>();
    public Scanner lectureClavier = new Scanner(System.in);
    public CompteEpargne ce = null;
    public LigneComptable lc = null;
    

    
    public void CreerLigne(ArrayList tabcompte,Compte compte){
        int a;
        lc = new LigneComptable();
        a = lc.creerLigneComptable(this,tabcomptable,tabcompte);
        lc.afficherLigneComptable();
        tabcompte[a].tabcomptable.add(lc);
    }

    public void CreerCompteEpargne(int choixmenu,Compte[] tabcompte){
        ce = new CompteEpargne();
        ce.CompteEpargne(this,choixmenu,tabcompte);
    }
    
    public int getnumcompte(int search,Compte[] tabcompte){
        int i;
        i = tabcompte[search].numcompte;
        return i;
    }
    
    public int gettaux(int search,Compte[] tabcompte){
        int i;
        i = tabcompte[search].taux;
        return i;
    }
    
    
      
    public void Compte(int choixmenu,Compte[] tabcompte,Compte compte) {

        if(choixmenu == 1){
            System.out.println("");
            System.out.println("Veuillez choisir le type de compte");
            System.out.println("Courant ou joint");
            System.out.println("1. Courant");
            System.out.println("2. Joint");
            choixcompte = lectureClavier.nextInt();
            while((choixcompte<1) | (choixcompte>2)){
                System.out.println("");
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
      
        boolean tabsearch = true;
        System.out.println("");
        System.out.println("Veuillez entrez le numéro de compte");

        while (tabsearch) {
            tabsearch = false;
            numcompte = lectureClavier.nextInt();
            for (int i = 0; i < tabcompte.length; i++) {
                if(tabcompte[i] != null){
                    if (numcompte == tabcompte[i].getnumcompte(i,tabcompte)){
                        tabsearch = true;
                    }                  
                }
            }
            if (tabsearch){
                System.out.println("\nCe numéro de compte existe déjà");
                System.out.println("Veuillez entrez un numéro de compte valide");
            }
        }

        System.out.println("");
        System.out.println("Veuillez entrez la première valeur créditée");
        valcreditee = lectureClavier.nextInt();
        
        
        
        if(choixcompte != 3){
            ecriturecompte(tabcompte,compte,taux);
            System.out.println("");
            System.out.println("Type du compte: "+ strcompte);               
            System.out.println("Numéro de compte: "+ numcompte);
            System.out.println("Première valeur créditée: "+ valcreditee);
            tricompte(tabcompte);
            Collections.sort(tabcompte);
        }
        
        
    }
    
    public void ecriturecompte(Compte[] tabcompte,Compte compte,int taux){
        
        ecriture = false;
        for (int p = 0; p < tabcompte.length; p++){
            if(!ecriture){
                if(choixcompte != 3){
                    if(tabcompte[p] == null){
                        tabcompte[p] = compte;
                        ecriture = true;
                    }
                }
                else{
                    compte.taux = taux;
                    if(tabcompte[p] == null){
                        tabcompte[p] = compte;
                        ecriture = true;
                    }
                }
            }
        }
    }
    
    public void Compte(String strcompte,int choixcompte,int numcompte,
        int valcreditee,int numcompteaff,boolean noms,int taux,boolean ecriture,
        int emplacement,int search,ArrayList tabcomptable,
        Scanner lectureClavier,CompteEpargne ce,LigneComptable lc){
        
        this.strcompte = strcompte;
    }

    

   
    
    public void tricompte(Compte[] tabcompte){
        
        int max = tabcompte.length;
        boolean tri = false;

        
        try{
            while(!tri){
                tri = true;
                for(int i = 0; i < tabcompte.length ; i++){
                    if((tabcompte[i] != null) && (tabcompte[i+1] != null)){
                        if(tabcompte[i].numcompte > tabcompte[i+1].numcompte){                           
                            Object intermediaire;
                            intermediaire = tabcompte[i];
                            tabcompte[i] = tabcompte[i+1];
                            tabcompte[i+1] = (Compte)intermediaire;
                            tri = false;                                                        
                        }
                    }                                             
                }              
                max = max-1;
            }            
        }
        catch(ArrayIndexOutOfBoundsException e2){}
    }
    
    public void Afficher_Compte(Compte[] tabcompte,ArrayList tabcomptable,Compte compte){
        
        
        boolean tabsearch = false;
        System.out.println("");
        System.out.println("Veuillez entrez un numéro de compte à afficher");

        while (!tabsearch) {          
            numcompteaff = lectureClavier.nextInt();
            for (int i = 0; i < tabcompte.length; i++) {
                if(tabcompte [i] != null){
                   if (numcompteaff == tabcompte [i].numcompte) {
                        tabsearch = true;
                        search = i;
                    }
                }
            }
            if (!tabsearch){
                System.out.println("\nCe numéro de compte n'existe pas");
                System.out.println("Veuillez entrez un numéro de compte à afficher");
            }
        }

       
        System.out.println("");
        System.out.println("Type de compte: "+ tabcompte[search].strcompte);
        System.out.println("Numéro de compte: "+ tabcompte[search].numcompte);
        System.out.println("Solde: "+ tabcompte[search].valcreditee);
        if(tabcompte[search].strcompte == "Epargne"){
            System.out.println("Taux de placement: "+ tabcompte[search].gettaux(search,tabcompte));
        }
        noms = false;       
        for (int p = 0; p < tabcompte[search].tabcomptable.size(); p++){
            if(!noms){
                System.out.println("");
                System.out.println("Dernières lignes comptables enregistrées :\n"); 
                noms = true;
            }
            lc.afficherLigneComptable2(tabcompte,search,p);
        }
    }

    
    public int compareTo(Compte compte1) {     
        return this.numcompte - compte1.numcompte;
    }

class Sort implements Comparator<Compte>{ 
 

        public int compare(Compte a, Compte b){ 

            return a.numcompte - b.numcompte; 
        } 
    } 
