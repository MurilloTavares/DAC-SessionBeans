package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.BandaDAO;
import br.edu.ifpb.sessionbeans.entity.Banda;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class GerenciarBanda {
    
    @EJB
    private BandaDAO bDao;
    
    private Banda banda;
    
    @PostConstruct
    public void init() {
        String param = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");
        int id = Integer.parseInt(param);
        banda = bDao.buscar(id);
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
}
