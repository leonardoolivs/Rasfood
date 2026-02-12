package br.com.rasmoo.daos;

import br.com.rasmoo.entities.Prato;
import org.h2.api.UserToRolesMapper;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PratoDAO {

    private EntityManager entityManager;

    public PratoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Prato prato) {
        this.entityManager.persist(prato);
    }

    public Prato findById(Long id) {
        return this.entityManager.find(Prato.class, id);
    }

    public void remove(Long id) {
        Prato prato = findById(id);
        if (prato != null) {
            this.entityManager.remove(prato);
        }
    }

    public Prato listPerName(String name){
        return this.entityManager
                .createQuery("SELECT p FROM Prato p WHERE p.nome = :name", Prato.class)
                .setParameter("name", name).getSingleResult();

    }

    public List<Prato> listPerPrice(BigDecimal price){
        return this.entityManager
                .createQuery(" SELECT p FROM Prato p WHERE p.preco = :price ", Prato.class)
                .setParameter("price", price).getResultList();
    }

    public List<Prato> list() {
        return this.entityManager
                .createQuery("SELECT p FROM Prato p", Prato.class).getResultList();
    }

    public void update(Long id, Prato prato){
        prato = findById(id);
        if(prato != null){
            this.entityManager.merge(prato);
        }
    }
}
