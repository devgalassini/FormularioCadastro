package br.com.cadastro.model.dao;

import br.com.cadastro.exception.CadastroException;
import br.com.cadastro.model.entities.Cadastro;

import javax.persistence.EntityManager;

public class CadastroDao {

    public void insert(Cadastro cadastro) {

        EntityManager em = JpaResourceBean.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cadastro);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();

            throw new CadastroException("Erro ao realizar cadastro.\n" +
                    e.getMessage());
        } finally {
            em.close();
        }
    }
}
