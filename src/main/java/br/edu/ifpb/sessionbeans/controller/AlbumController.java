package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.AlbumDAO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.ifpb.sessionbeans.entity.Album;
import br.edu.ifpb.sessionbeans.entity.Banda;
import br.edu.ifpb.sessionbeans.entity.Estilo;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AlbumController {
    
    @EJB
    private AlbumDAO aDao;
    private Album albumForm;

    @PostConstruct
    public void init(){
        albumForm = new Album();
    }
    
    public void addAlbum(Banda banda){
        albumForm.setBanda(banda);
        aDao.salvar(albumForm);
        albumForm = new Album();
    }
    
    public void excluirAlbum(Album album){
        aDao.remover(album);
    }
    
    public void excluirAlbum(int id){
        aDao.remover(id);
    }
    
    public List<Estilo> estilos(){
        return Arrays.asList(Estilo.values());
    }
    
    public Album getAlbumForm() {
        return albumForm;
    }

    public void setAlbumForm(Album albumForm) {
        this.albumForm = albumForm;
    }
    
    
    
}
