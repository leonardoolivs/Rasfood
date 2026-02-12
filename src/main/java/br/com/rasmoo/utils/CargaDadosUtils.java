package br.com.rasmoo.utils;

import br.com.rasmoo.daos.CategoriaDAO;
import br.com.rasmoo.daos.PratoDAO;
import br.com.rasmoo.entities.Categoria;
import br.com.rasmoo.entities.Prato;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CargaDadosUtils {

    public static void cadastrarCategorias(EntityManager em){
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        Categoria categoriaA = new Categoria("Entradas");
        Categoria categoriaB = new Categoria("Saladas");
        Categoria categoriaC = new Categoria("Pratos Principais");

        //Create
        categoriaDAO.insert(categoriaA);
        categoriaDAO.insert(categoriaB);
        categoriaDAO.insert(categoriaC);

        em.clear();
    }

    public static void cadastrarPratos(EntityManager em){
        PratoDAO pratoDAO = new PratoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        List<Categoria> listaCategoria = categoriaDAO.findAll();

        Prato pratoA = new Prato(null, "Strogonoff", "Arroz, Strogonoff e Batata Palha", true, BigDecimal.valueOf(40.00), LocalDate.now(), listaCategoria.get(2));
        Prato pratoB = new Prato(null, "Churrasco", "Arroz, Hamburguer e Feijão", true, BigDecimal.valueOf(40.00), LocalDate.now(), listaCategoria.get(2));

        //Create
        pratoDAO.persist(pratoA);
        pratoDAO.persist(pratoB);

        em.clear();

        //FindByName
        System.out.println(pratoDAO.listPerName("Churrasco"));

        //FindById
//        System.out.println(pratoDAO.findById(1L));

        //Delete
//        pratoDAO.remove(1L);

        //Read
//        List<Prato> pratoList = pratoDAO.list();
//
//        for(Prato cadaPrato : pratoList){
//            System.out.println(cadaPrato);
//        }

        //List Per Price
//        System.out.println(pratoDAO.listPerPrice(BigDecimal.valueOf(40.00)));

        //Update
//        pratoB.setDescricao("Arroz, Hamburguer Angus, Feijão e Batata Frita");
//        pratoDAO.update(2L, pratoB);
//
//        System.out.println(pratoDAO.findById(2L));

    }
}
