package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.AlbumDAO;
import br.edu.ifpb.sessionbeans.dao.BandaDAO;
import br.edu.ifpb.sessionbeans.entity.Banda;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.edu.ifpb.sessionbeans.entity.Album;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class GerenciarBanda implements Serializable{
    
    @EJB
    private BandaDAO bDao;
    @EJB
    private AlbumDAO aDao;
    
    private Banda banda;
    
    @PostConstruct
    public void init() {
        String param = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");
        int id = Integer.parseInt(param);
        banda = bDao.buscar(id);
    }
        
    public void addAlbum(Album album){
        album.setBanda(banda);
        banda.getAlbums().add(album);
        bDao.atualizar(banda);
    }
    
    public void removerAlbum(Album album){
        banda.getAlbums().remove(album);
        bDao.atualizar(banda);
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
        
}
