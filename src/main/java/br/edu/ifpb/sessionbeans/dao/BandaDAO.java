package br.edu.ifpb.sessionbeans.dao;

import br.edu.ifpb.sessionbeans.entity.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BandaDAO {
    
    @PersistenceContext(unitName = "BandaPU")
    private EntityManager em;
    
    public void salvar(Banda banda){
        em.persist(banda);
    }
    
}
