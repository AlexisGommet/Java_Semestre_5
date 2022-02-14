/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import java.sql.*;

/**
 *
 * @author ROG
 */
public class DBManager {
    
    private static Connection connect;
    public static Statement state;
    private DBManager(){}

    /*Execute les requêtes de type SELECT*/

    public static ResultSet executeQuery(String sqlQuery) throws SQLException{
        try{
            if (!(connect instanceof Connection))

               initConnexion("org.apache.derby.jdbc.ClientDriver", "jdbc:derby://localhost:1527/Comptes_Bancaires","test","test");
               state = connect.createStatement();
               ResultSet rs = state.executeQuery(sqlQuery);
               return rs;
        }
        catch(SQLException e)
        {
            throw e;
        }
    }
    
    public static int updateQuery(String sqlQuery) throws SQLException{
        try{
            if (connect == null)
                          
                initConnexion("org.apache.derby.jdbc.ClientDriver "," jdbc:derby://localhost:1527/Comptes_Bancaires 3306/Comptes_Bancaires", "test", "test");

                DBManager.state = connect.createStatement();

                int result = state.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);

                connect.commit();

                return result;
            
        }

        catch(SQLException e){
            throw e;
        }
    }
    
    private static void initConnexion(String driver,String url, String login, String password) throws SQLException{
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url,login,password);
            connect.setAutoCommit(false);
            System.out.println("Connexion reussie");
        }

        catch (ClassNotFoundException e){
            System.out.println("erreur chargement pilote JDBC \n");
            System.exit(0);
        }
        catch (SQLException e){
            System.out.println("erreur connexion base de données \n"+e.getMessage());
            System.exit(0);
        }
    }
}



