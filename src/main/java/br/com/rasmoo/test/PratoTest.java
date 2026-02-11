package br.com.rasmoo.test;

import br.com.rasmoo.entities.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PratoTest {
    static void main() {
        Prato prato = new Prato(null, "Strogonoff", "Arroz, Strogonoff e Batata Palha", true, BigDecimal.valueOf(40.00), LocalDate.now());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rasfood");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(prato);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
