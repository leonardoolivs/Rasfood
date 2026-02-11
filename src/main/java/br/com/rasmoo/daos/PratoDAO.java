package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Prato;

import javax.persistence.EntityManager;

public class PratoDAO {

    private EntityManager entityManager;

    public PratoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Prato prato) {
        this.entityManager.persist(prato);
    }
}
