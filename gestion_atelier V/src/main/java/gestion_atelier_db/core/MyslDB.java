package gestion_atelier_db.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyslDB implements IDatabase {
    protected Connection connex;
    protected PreparedStatement ps;

    @Override
    public void ouvrirConnexionDB() {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connex=DriverManager.getConnection("jdbc:mysql://localhost:8009/atelier_java", "root", "");
        } catch (SQLException e){
            e.printStackTrace();
        }
         catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void fermerConnextionDb() {
        if(connex!=null){
            try {
                connex.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
