package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.BandaDAO;
import br.edu.ifpb.sessionbeans.entity.Integrante;
import br.edu.ifpb.sessionbeans.entity.Banda;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NovaBanda implements Serializable{
    
    @EJB
    private BandaDAO bDao;
    
    private Banda bandaForm;
    private Integrante integranteForm;
    
    @PostConstruct
    public void init() {
        bandaForm = new Banda();
        integranteForm = new Integrante();
    }
    
    public void salvar(){
        bDao.salvar(bandaForm);
        bandaForm = new Banda();
    }
    
    public void addIntegranteNaBanda(){
        bandaForm.getIntegrantes().add(integranteForm);
        integranteForm = new Integrante();
    }
    
    public Banda getBandaForm() {
        return bandaForm;
    }

    public void setBandaForm(Banda bandaForm) {
        this.bandaForm = bandaForm;
    }

    public Integrante getIntegranteForm() {
        return integranteForm;
    }

    public void setIntegranteForm(Integrante integranteForm) {
        this.integranteForm = integranteForm;
    }
    
}
