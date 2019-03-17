package br.edu.ifpb.sessionbeans.dao;

import br.edu.ifpb.sessionbeans.entity.Banda;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

@Stateful
public class PlaylistDAO {
    
    private List<Banda> playlist;
    
    @PostConstruct
    public void init(){
        playlist = new ArrayList<>();
    }
    
    public void addBanda(Banda banda){
        playlist.add(banda);
    }
    
    public void removerBanda(Banda banda){
        playlist.remove(banda);
    }
    
    public List<Banda> listar(){
        return playlist;
    }
    
}
