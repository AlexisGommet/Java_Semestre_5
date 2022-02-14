/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;


import java.util.*;






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
//  String [][] tabcomptable = new String[10][5];
//  Compte[] tabcompte = new Compte[10];
    public Scanner lectureClavier = new Scanner(System.in);
    public CompteEpargne ce = null;
    public LigneComptable lc = null;
    

    
    public void CreerLigne(ArrayList tabcompte,Compte compte){
        int a;
        lc = new LigneComptable();
        a = lc.creerLigneComptable(this,tabcomptable,tabcompte);
        lc.afficherLigneComptable();
        Compte co3;
        co3 = (Compte)tabcompte.get(a);
        co3.tabcomptable.add(lc);
    }

    public void CreerCompteEpargne(int choixmenu,ArrayList tabcompte){
        ce = new CompteEpargne();
        ce.CompteEpargne(this,choixmenu,tabcompte);
    }
    
    public int getnumcompte(int search,ArrayList tabcompte){
        int i;
        Compte a;
        a = (Compte)tabcompte.get(search);
        i = a.numcompte;
        return i;
    }
    
    public int gettaux(int search,ArrayList tabcompte){
        int i;
        Compte a;
        a = (Compte)tabcompte.get(search);
        i = a.taux;
        return i;
    }
   
      
    public void Compte(int choixmenu,ArrayList tabcompte,Compte compte) {

        if(choixmenu == 1){
            System.out.println("\nVeuillez choisir le type de compte");
            System.out.println("Courant ou joint");
            System.out.println("1. Courant");
            System.out.println("2. Joint");
            choixcompte = lectureClavier.nextInt();
            while((choixcompte<1) | (choixcompte>2)){
                System.out.println("\nChoix de compte invalide");
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
        System.out.println("\nVeuillez entrez le numéro de compte");

        while (tabsearch) {
            tabsearch = false;
            numcompte = lectureClavier.nextInt();
            for (int i = 0; i < tabcompte.size(); i++) {
                if(tabcompte.get(i) != null){
                    Compte a;
                    a = (Compte)tabcompte.get(i);
                    if (numcompte == a.getnumcompte(i,tabcompte)){
                        tabsearch = true;
                    }                  
                }
            }
            if (tabsearch){
                System.out.println("\nCe numéro de compte existe déjà");
                System.out.println("Veuillez entrez un numéro de compte valide");
            }
        }

        System.out.println("\nVeuillez entrez la première valeur créditée");
        valcreditee = lectureClavier.nextInt();
              
        if(choixcompte != 3){
            ecriturecompte(tabcompte,compte,taux);
            System.out.println("\nType du compte: "+ strcompte);               
            System.out.println("Numéro de compte: "+ numcompte);
            System.out.println("Première valeur créditée: "+ valcreditee);
            Collections.sort(tabcompte);
        }              
    }
    
    public void ecriturecompte(ArrayList tabcompte,Compte compte,int taux){
        
        if(choixcompte == 3){
            compte.taux = taux;
        }
        tabcompte.add(compte);
    }
      
    public void Afficher_Compte(ArrayList tabcompte,ArrayList tabcomptable,Compte compte){
        
        
        boolean tabsearch = false;
        System.out.println("\nVeuillez entrez un numéro de compte à afficher");

        while (!tabsearch) {          
            numcompteaff = lectureClavier.nextInt();
            for (int i = 0; i < tabcompte.size(); i++) {
                if(tabcompte.get(i) != null){
                    Compte a;
                    a = (Compte)tabcompte.get(i);
                    if (numcompteaff == a.numcompte) {
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

        Compte s;
        s = (Compte)tabcompte.get(search);
        System.out.println("\nType de compte: "+ s.strcompte);
        System.out.println("Numéro de compte: "+ s.numcompte);
        System.out.println("Solde: "+ s.valcreditee);
        if(s.strcompte == "Epargne"){
            System.out.println("Taux de placement: "+ s.gettaux(search,tabcompte));
        }
        noms = false;       
        for (int p = 0; p < s.tabcomptable.size(); p++){
            if(!noms){
                System.out.println("\nDernières lignes comptables enregistrées :\n"); 
                noms = true;
            }
            LigneComptable lc4 = new LigneComptable();
            lc4.afficherLigneComptable2(tabcompte,search,p);
        }
        
//      Affichage Lignes Comptables sans tableau de comptes

 /*     noms = false;
        for (int p = 0; p < tabcomptable.length; p++){
            if(!noms){
                System.out.println("");
                System.out.println("Dernières lignes comptables enregistrées :\n"); 
                noms = true;
            }
            System.out.println("Compte: "+tabcomptable[p][0]+"  Somme créditée :"+tabcomptable[p][1]+"  Date de l'opération: "+tabcomptable[p][2]+"
            Motif: "+tabcomptable[p][3]+"  Mode de paiement : "+tabcomptable[p][4]);
        }*/
 
 //      Affichage Lignes Comptables avec tableau de comptes

 /*     noms = false;
        Compte c1;
        c1 = tabcompte[search];
        for (int p = 0; p < c1.tabcomptable.length; p++){
            if(!noms){
                System.out.println("");
                System.out.println("Dernières lignes comptables enregistrées :\n"); 
                noms = true;
            }
            System.out.println("Compte: "+c1.tabcomptable[p][0]+"  Somme créditée :"+c1.tabcomptable[p][1]+"  Date de l'opération: "+c1.tabcomptable[p][2]+"
            Motif: "+c1.tabcomptable[p][3]+"  Mode de paiement : "+c1.tabcomptable[p][4]);
        }*/
    }
 
    @Override
    public int compareTo(Compte compte1) {     
        return this.numcompte - compte1.numcompte;
    }
}
/*
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

*/