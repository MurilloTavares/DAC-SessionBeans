package br.edu.ifpb.sessionbeans.dao;

import br.edu.ifpb.sessionbeans.entity.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class BandaDAO {
    
    @PersistenceContext(unitName = "BandaPU")
    private EntityManager em;
    private CriteriaBuilder builder;
    
    @PostConstruct
    private void init(){
        builder = em.getCriteriaBuilder();
    }
    
    public void salvar(Banda banda){
        em.persist(banda);
    }
    
    public List<Banda> listar(){
        CriteriaQuery<Banda> queryBuilder = builder.createQuery(Banda.class);
        queryBuilder.select(queryBuilder.from(Banda.class));
        
        TypedQuery<Banda> query = em.createQuery(queryBuilder);
        return query.getResultList();
    }
    
    public void excluir(Banda banda){
        banda = em.find(Banda.class, banda.getId());
        em.remove(banda);
    }
    
    public Banda buscar(int id){
        return em.find(Banda.class, id);
    }

    public void atualizar(Banda banda) {
        em.merge(banda);
    }
    
}
