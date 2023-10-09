package gestion_atelier_db.repositories;

import java.util.ArrayList;

import gestion_atelier_db.entities.Categorie;

public interface ICategorieRepository<base> {
     Categorie insert(base data);
     Categorie update(base data);
     ArrayList<Categorie> findAll();
     Categorie findById(int id);
     Categorie delete(int id) ;
    Categorie indexOf(int id);
}
