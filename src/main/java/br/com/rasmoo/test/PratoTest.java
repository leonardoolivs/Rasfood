package br.com.rasmoo.test;

import br.com.rasmoo.utils.CargaDadosUtils;
import br.com.rasmoo.utils.JPAUtil;

import javax.persistence.EntityManager;

public class PratoTest {
    static void main() {

        EntityManager em = JPAUtil.getEntityManagerRasFood();

        em.getTransaction().begin();

        CargaDadosUtils.cadastrarCategorias(em);
        CargaDadosUtils.cadastrarPratos(em);
        CargaDadosUtils.cadastrarEndereco(em);
        CargaDadosUtils.cadastrarCliente(em);
        CargaDadosUtils.cadastrarOrdem(em);

        em.getTransaction().commit();

        em.close();
    }
}
