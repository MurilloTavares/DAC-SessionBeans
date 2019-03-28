package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.entity.Banda;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PlaylistController {
    
    private List<Banda> playlist = new ArrayList<>();
    
    public String addBanda(Banda banda){
        playlist.add(banda);
        return "index.xhtml";
    }
    
    public void removerBanda(Banda banda){
        playlist.remove(banda);
    }
    
    public List<Banda> listar(){
        return playlist;
    }
    
}
