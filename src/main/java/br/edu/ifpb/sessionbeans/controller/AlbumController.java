package br.edu.ifpb.sessionbeans.controller;

import br.edu.ifpb.sessionbeans.dao.AlbumDAO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.ifpb.sessionbeans.entity.Album;
import br.edu.ifpb.sessionbeans.entity.Banda;

@ManagedBean
@SessionScoped
public class AlbumController {
    
    @EJB
    private AlbumDAO aDao;
    
}
