package br.edu.ifpb.sessionbeans.jsf.converter;

import br.edu.ifpb.sessionbeans.entity.CPF;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converter.CPF")
public class CPFConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return new CPF(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) return "";
        CPF cpf = (CPF)value;
        return cpf.getFormatedCpf();
    }
    
}
