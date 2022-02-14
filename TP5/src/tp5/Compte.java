/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private boolean noms = false;
    protected int taux;
    protected boolean ecriture = false;
    protected int emplacement = 0;
    protected int search = 0;
    private ResultSet result;
    private Statement state;
    public Scanner lectureClavier = new Scanner(System.in);
    CompteEpargne ce = null;
    LigneComptable lc = null;

    public void CreerLigne(Compte compte, int id_ligne, boolean tableauvide) {
        lc = new LigneComptable();
        lc.creerLigneComptable(this, id_ligne, tableauvide);
        lc.afficherLigneComptable();
        sqlquery(6);
    }

    public void CreerCompteEpargne(int choixmenu, boolean tableauvide) {
        ce = new CompteEpargne();
        ce.CompteEpargne(this, choixmenu, tableauvide);
    }

    public ResultSet getresult() {
        return result;
    }

    public Statement getstate() {
        return state;
    }

    public ResultSet sqlquery(int query) {

        ResultSet sqlquery = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Comptes_Bancaires";
            String user = "test";
            String passwd = "test";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            state = conn.createStatement();
            switch (query) {
                case 1:
                    result = state.executeQuery("SELECT * FROM COMPTE");                   
                    break;
                case 2:
                    state.executeUpdate("INSERT INTO COMPTE (NUMCOMPTE,STRCOMPTE,CHOIXCOMPTE,VALCREDITEE) VALUES (" + numcompte + ",'" + strcompte + "'," + choixcompte + "," + valcreditee + ")");
                    break;
                case 3:                  
                    state.executeUpdate("INSERT INTO COMPTE (NUMCOMPTE,STRCOMPTE,CHOIXCOMPTE,VALCREDITEE,TAUX) VALUES (" + numcompte + ",'" + strcompte + "'," + choixcompte + "," + valcreditee + "," + this.taux + ")");
                    break;
                case 4:
                    result = state.executeQuery("SELECT * FROM COMPTE WHERE NUMCOMPTE=" + lc.getnumcompteaff() + "");
                    result.next();
                    break;
                case 5:
                    state.executeUpdate("UPDATE COMPTE SET VALCREDITEE = " + lc.getsommecred2() + " WHERE NUMCOMPTE = " + lc.getnumcompteaff() + "");
                    break;
                case 6:
                    state.executeUpdate("INSERT INTO LIGNECOMPTABLE (STRMOTIF,STRMODEPAYE,DATEOP,MOTIF,MODEPAYE,SOMMECRED,NUMCOMPTE,ID_LIGNE) VALUES ('" + lc.getstrmotif() + "','" + lc.getstrmodepaye() + "','" + lc.getdateop() + "'," + lc.getmotif() + "," + lc.getmodepaye() + "," + lc.getsommecred() + "," + lc.getnumcompteaff() + "," + lc.getid_ligne() + ")");
                    break;
                case 7:
                    result = state.executeQuery("SELECT * FROM LIGNECOMPTABLE WHERE NUMCOMPTE=" + numcompteaff + "");
                    break;
                case 8:
                    result = state.executeQuery("SELECT * FROM COMPTE WHERE NUMCOMPTE=" + numcompteaff + "");
                    result.next();
                    break;
            }
            sqlquery = result;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ((query == 2) | (query == 3) | (query == 5) | (query == 6)) {
            return null;
        }
        return sqlquery;
    }

    public void Compte(int choixmenu, Compte compte, boolean tableauvide) {

        try {                   
            
            if (choixmenu == 1) {
                System.out.println("\nVeuillez choisir le type de compte");
                System.out.println("Courant ou joint");
                System.out.println("1. Courant");
                System.out.println("2. Joint");
                choixcompte = lectureClavier.nextInt();
                while ((choixcompte < 1) | (choixcompte > 2)) {
                    System.out.println("\nChoix de compte invalide");
                    System.out.println("Veuillez entrez 1 ou 2");
                    choixcompte = lectureClavier.nextInt();
                }
            }

            if (choixcompte == 1) {
                strcompte = ("Courant");
            }
            if (choixcompte == 2) {
                strcompte = ("Joint");
            }
            if (choixmenu == 2) {
                strcompte = ("Epargne");
                choixcompte = 3;
            }

            boolean tabsearch = true;
            System.out.println("\nVeuillez entrez le numéro de compte");

            while (tabsearch) {
                tabsearch = false;
                numcompte = lectureClavier.nextInt();
                if (!tableauvide) {
                    sqlquery(1);
                    while (result.next()) {
                        if (numcompte == result.getInt("NUMCOMPTE")) {
                            tabsearch = true;
                        }
                    }                   
                }
                if (tabsearch) {
                    System.out.println("\nCe numéro de compte existe déjà");
                    System.out.println("Veuillez entrez un numéro de compte valide");
                }
            }

            if (!tableauvide) {
                result.close();
                state.close();
            }

            System.out.println("\nVeuillez entrez la première valeur créditée");
            valcreditee = lectureClavier.nextInt();
            
            if (choixcompte == 3) {
                System.out.println("\nVeuillez entrez le taux de placement");
                taux = lectureClavier.nextInt();
            }

            if (choixcompte != 3) {               
                ecriturecompte(compte);
                System.out.println("\nType du compte: " + strcompte);
                System.out.println("Numéro de compte: " + numcompte);
                System.out.println("Première valeur créditée: " + valcreditee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ecriturecompte(Compte compte) {
        try{
            if (choixcompte == 3) {
                sqlquery(3);
            }
            else{
                sqlquery(2);
            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Afficher_Compte(Compte compte) {

        try {
            boolean tabsearch = false;
            System.out.println("\nVeuillez entrez un numéro de compte à afficher");

            while (!tabsearch) {
                numcompteaff = lectureClavier.nextInt();
                sqlquery(1);
                while (result.next()) {
                    if (numcompteaff == result.getInt("NUMCOMPTE")) {
                        tabsearch = true;
                    }
                }
                if (!tabsearch) {
                    System.out.println("\nCe numéro de compte n'existe pas");
                    System.out.println("Veuillez entrez un numéro de compte à afficher");
                }
            }
            result.close();
            state.close();
            
            sqlquery(8);
            System.out.println("\nType de compte: " + result.getString("STRCOMPTE"));
            System.out.println("Numéro de compte: " + result.getInt("NUMCOMPTE"));
            System.out.println("Solde: " + result.getInt("VALCREDITEE"));

            if (result.getString("STRCOMPTE") == "Epargne") {
                System.out.println("Taux de placement: " + result.getInt("TAUX"));
            }
            result.close();
            state.close();

            noms = false;
            sqlquery(7);           
            while (result.next()) {
                if (!noms) {
                    System.out.println("\nDernières lignes comptables enregistrées :\n");
                    noms = true;
                }
                System.out.println("Compte : "+result.getInt("NUMCOMPTE")+"                   Somme créditée : "+result.getInt("SOMMECRED")+"                   Date de l'opération : "+result.getString("DATEOP")+" Motif : "+result.getString("STRMOTIF")+" Mode de paiement : "+result.getString("STRMODEPAYE")+"");
            }
            result.close();
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
