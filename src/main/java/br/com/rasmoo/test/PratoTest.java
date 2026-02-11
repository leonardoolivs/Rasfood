package br.com.rasmoo.test;

import br.com.rasmoo.daos.PratoDAO;
import br.com.rasmoo.entities.Prato;
import br.com.rasmoo.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PratoTest {
    static void main() {
        Prato prato = new Prato(null, "Strogonoff", "Arroz, Strogonoff e Batata Palha", true, BigDecimal.valueOf(40.00), LocalDate.now());

        EntityManager em = JPAUtil.getEntityManagerRasFood();

        PratoDAO pratoDAO = new PratoDAO(em);

        em.getTransaction().begin();

        pratoDAO.persist(prato);

        em.getTransaction().commit();

        em.close();
    }
}
