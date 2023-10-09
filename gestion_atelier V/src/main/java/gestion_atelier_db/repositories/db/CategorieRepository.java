package gestion_atelier_db.repositories.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gestion_atelier_db.core.MyslDB;
import gestion_atelier_db.entities.Categorie;
import gestion_atelier_db.repositories.ICategorieRepository;

public class CategorieRepository extends MyslDB implements ICategorieRepository<Categorie>{
    private final String SQL_insert="INSERT INTO `Categorie` (`libelle`) VALUES (?);";
    private final String SQL_select="SELECT * FROM `Categorie`";
    private final String SQL_select_by_id="SELECT `id`, `libelle` FROM `Categorie` WHERE ?";

    @Override
    public Categorie insert(Categorie data) {
        this.ouvrirConnexionDB();
        try {
            ps=connex.prepareStatement(SQL_insert,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,data.getLibelle()); 
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnextionDb();

        return data;
    }

    @Override
    public Categorie update(Categorie data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Categorie> findAll() {
        Categorie categories=null;
        this.ouvrirConnexionDB();
        try{
            ps= connex.prepareStatement(SQL_select);
            ps.setString(0, SQL_select);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                categories = new Categorie(rs.getInt("id"),rs.getString("libelle"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnextionDb();
        return null;
    }

    @Override
    public Categorie findById(int id) {
        Categorie categorie=null;
        this.ouvrirConnexionDB();
        try{
            ps=connex.prepareStatement(SQL_select_by_id);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                categorie=new Categorie(
                    rs.getInt("id"),rs.getString("libelle")
                    );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnextionDb();
        return categorie;
    }

    @Override
    public Categorie delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Categorie indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }
    
}
