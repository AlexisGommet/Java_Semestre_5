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
public class TP5 {


    static public Scanner lectureClavier = new Scanner(System.in);
    static private int choixmenu = 0;
    static public Compte compte = null;
    static public int id_ligne = 0;
    static public boolean tableauvide = true;

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {       
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Comptes_Bancaires";
            String user = "test";
            String passwd = "test";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement state = conn.createStatement();
            state.executeUpdate("truncate table COMPTE"); 
            state.executeUpdate("truncate table LIGNECOMPTABLE");
            state.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(TP5.class.getName()).log(Level.SEVERE, null, ex);
        }    

        
        boolean check = false;
        

        
        while(!check){
            
            System.out.println("\n1. Créer un compte simple");
            System.out.println("2. Créer un compte Epargne ");
            System.out.println("3. Créer une ligne comptable");
            System.out.println("4. Afficher un compte");
            System.out.println("5. Sortir");
            System.out.println("\nVeuillez choisir l'action a effectuée");
            choixmenu = lectureClavier.nextInt();

            while((choixmenu<1) | (choixmenu>5)){
                System.out.println("\nChoix invalide");
                System.out.println("Veuillez entrez un nombre entre 1 et 5");
                choixmenu = lectureClavier.nextInt();
            }
                        

            switch(choixmenu){
                
                case 1:
                    
                    compte = new Compte();
                    compte.Compte(choixmenu,compte,tableauvide);
                    if(tableauvide){
                        tableauvide = false;
                    }
                    
                    break;
                    
                case 2:
                    
                    compte = new Compte();
                    compte.CreerCompteEpargne(choixmenu,tableauvide);
                    if(tableauvide){
                        tableauvide = false;
                    }
                    
                    break;
                    
                case 3:
                    
                    id_ligne++;
                    compte.CreerLigne(compte,id_ligne,tableauvide);
                    
                    break;
                    
                case 4:
                    
                    
                    compte.Afficher_Compte(compte);
                                     
                    break;              
                    
                case 5:
                    
                    System.out.println("\nMerci de votre visite, à la prochaine fois!");
                    check = true;
                    
                    break;

                
            }
        }
    }    
}

