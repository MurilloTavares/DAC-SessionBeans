package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.BandaDAO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BandaController {
    
    @EJB
    private BandaDAO bDao;
    
    public void init() {
        bDao.init();
    }
    
}
