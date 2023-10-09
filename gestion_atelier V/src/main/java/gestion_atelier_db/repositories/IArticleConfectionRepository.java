package gestion_atelier_db.repositories;

import java.util.ArrayList;

import gestion_atelier_db.entities.ArticleConfection;

public interface IArticleConfectionRepository<base> {
     ArticleConfection insert(base data);
     ArticleConfection update(base data);
     ArrayList<base> findAll();
     base findById(int id);
     ArticleConfection delete(int id);
     ArticleConfection indexOf(int id);
}
