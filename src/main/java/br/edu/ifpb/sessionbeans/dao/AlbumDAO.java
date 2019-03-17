package br.edu.ifpb.sessionbeans.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.edu.ifpb.sessionbeans.entity.Album;

@Stateless
public class AlbumDAO {
    
    @PersistenceContext(unitName = "BandaPU")
    EntityManager em;
    
    public void salvar(Album album){
        em.persist(album);
    }
    
    public void remover(Album album){
        album = em.find(Album.class, album.getId());
        em.remove(album);
    }
    
    public void remover(int id){
        Album album = em.find(Album.class, id);
        em.remove(album);
    }

    
}
