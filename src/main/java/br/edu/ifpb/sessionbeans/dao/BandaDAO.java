package br.edu.ifpb.sessionbeans.dao;

import br.edu.ifpb.sessionbeans.entity.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BandaDAO {
    
    @PersistenceContext(unitName = "BandaPU")
    private EntityManager em;
    
    public void init() {
        Integrante joao = new Integrante();
        Banda banda = new Banda();
        banda.getIntegrantes().add(joao);
        Album album = new Album();
        album.setEstilo(Estilo.Rock);
        album.setBanda(banda);
        banda.getAlbums().add(album);
        
        em.persist(banda);        
    }
    
}
