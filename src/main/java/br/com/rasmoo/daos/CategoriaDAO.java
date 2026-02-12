package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em){
        this.em = em;
    }

    public void insert(Categoria categoria){
        this.em.persist(categoria);
    }

    public List<Categoria> findAll(){
        return em.createQuery("SELECT c FROM Categoria c").getResultList();
    }
}
