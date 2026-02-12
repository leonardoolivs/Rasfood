package br.com.rasmoo.test;

import br.com.rasmoo.daos.CategoriaDAO;
import br.com.rasmoo.daos.PratoDAO;
import br.com.rasmoo.entities.Categoria;
import br.com.rasmoo.entities.Prato;
import br.com.rasmoo.utils.CargaDadosUtils;
import br.com.rasmoo.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PratoTest {
    static void main() {

        EntityManager em = JPAUtil.getEntityManagerRasFood();

        em.getTransaction().begin();

        CargaDadosUtils.cadastrarCategorias(em);
        CargaDadosUtils.cadastrarPratos(em);

        em.getTransaction().commit();

        em.close();
    }
}
