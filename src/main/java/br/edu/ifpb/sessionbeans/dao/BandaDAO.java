package br.edu.ifpb.sessionbeans.dao;

import br.edu.ifpb.sessionbeans.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    
    public List<Banda> listarDestaques(int results){
//        long count = quantBandas();
//        Random random = new Random();
//        int posic = random.nextInt((int)count);
        
        CriteriaQuery<Banda> queryBuilder = builder.createQuery(Banda.class);
        queryBuilder.select(queryBuilder.from(Banda.class));
        
        TypedQuery<Banda> query = em.createQuery(queryBuilder);
        // query.setFirstResult(posic);
//        query.setMaxResults(results);

        List<Banda> remaingResult = query.getResultList();
        List<Banda> randomList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < results; i++){
            int index = random.nextInt(remaingResult.size());
            Banda banda = remaingResult.remove(index);
            randomList.add(banda);
        }
        return randomList;
//        return query.getResultList();
    }
    
    public Long quantBandas(){
        CriteriaQuery<Long> queryBuilder = builder.createQuery(Long.class);
        queryBuilder.select(
                builder.count(
                        queryBuilder.from(Banda.class)
                )
        );
        return em.createQuery(queryBuilder).getSingleResult();
    }
    
}
