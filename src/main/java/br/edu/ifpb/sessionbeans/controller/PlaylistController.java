package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.PlaylistDAO;
import br.edu.ifpb.sessionbeans.entity.Banda;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PlaylistController {
    
    @EJB
    private PlaylistDAO playlist;
    
    public void addBanda(Banda banda){
        playlist.addBanda(banda);
    }
    
    public void removerBanda(Banda banda){
        playlist.removerBanda(banda);
    }
    
    public List<Banda> listar(){
        return playlist.listar();
    }
    
}
