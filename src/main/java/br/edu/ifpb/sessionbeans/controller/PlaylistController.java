package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.PlaylistDAO;
import br.edu.ifpb.sessionbeans.entity.Banda;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class PlaylistController {
    
    @EJB
    private PlaylistDAO playlist;
    
    public String addBanda(Banda banda){
        playlist.addBanda(banda);
//        HttpServletRequest request = (HttpServletRequest) FacesContext
//                .getCurrentInstance()
//                .getExternalContext()
//                .getRequest();
//        return request.getRequestURL().toString()+"?faces-redirect=trues";
        return "index.xhtml";
    }
    
    public void removerBanda(Banda banda){
        playlist.removerBanda(banda);
    }
    
    public List<Banda> listar(){
        return playlist.listar();
    }
    
}
