package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.BandaDAO;
import br.edu.ifpb.sessionbeans.entity.Banda;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DestaquesController {
    
    @EJB
    private BandaDAO bDao;
    private List<Banda> destaques;
    
    @PostConstruct
    private void init() {
        destaques = bDao.listarDestaques(3);
    }

    public List<Banda> getDestaques() {
        return destaques;
    }

    public void setDestaques(List<Banda> destaques) {
        this.destaques = destaques;
    }
    
}
