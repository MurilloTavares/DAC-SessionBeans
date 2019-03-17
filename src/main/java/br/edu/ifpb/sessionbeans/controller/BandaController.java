package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.BandaDAO;
import br.edu.ifpb.sessionbeans.entity.Banda;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BandaController {
    
    @EJB
    private BandaDAO bDao;
    
    public void salvar(Banda banda){
        bDao.salvar(banda);
    }
    
    public List<Banda> listar(){
        return bDao.listar();
    }
    
    public void excluir(Banda banda){
        bDao.excluir(banda);
    }
    
}
