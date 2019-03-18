package br.edu.ifpb.sessionbeans.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converter.data")
public class DataConverter extends DateTimeConverter {
       
    public DataConverter() {
        setPattern("dd/MM/yyyy");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.length() != getPattern().length()) {
            return null;
        }

        return super.getAsObject(context, component, value);
    }
    

}
