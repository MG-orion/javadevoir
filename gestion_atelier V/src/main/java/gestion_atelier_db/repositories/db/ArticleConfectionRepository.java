package gestion_atelier_db.repositories.db;

import java.sql.SQLException;
import java.util.ArrayList;

import gestion_atelier_db.core.MyslDB;
import gestion_atelier_db.entities.ArticleConfection;
import gestion_atelier_db.repositories.IArticleConfectionRepository;

public class ArticleConfectionRepository extends MyslDB implements IArticleConfectionRepository<ArticleConfection>{

    private final String SQL_insert="INSERT INTO `ArticleConfection` (`libelle`, `prix`, `qte`) VALUES (?, ?, ?);"; 

    @Override
    public ArticleConfection insert(ArticleConfection data) {

        this.ouvrirConnexionDB();
        try {
            ps=connex.prepareStatement(SQL_insert); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.fermerConnextionDb();

        return null;
    }

    @Override
    public ArticleConfection update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<ArticleConfection> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ArticleConfection findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ArticleConfection delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArticleConfection indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    
}
