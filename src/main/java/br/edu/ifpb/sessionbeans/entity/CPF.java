package br.edu.ifpb.sessionbeans.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.swing.text.MaskFormatter;

@Embeddable
public class CPF implements Serializable{
    
    private String numericCpf;

    public CPF() {
    }

    public CPF(String cpf) {
        setCpf(cpf);
    }

    public void setCpf(String cpf) {
        if(cpf == null) cpf = "";
        this.numericCpf = cpf.replaceAll("\\D+","");;
    }
    
    public String getNumericCpf() {
        return numericCpf;
    }
    
    public String getFormatedCpf(){
        if(!isValid()) return "";
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");  
            mf.setValueContainsLiteralCharacters(false); 
            return mf.valueToString(numericCpf);
        } catch (ParseException ex) {
            return "";
        }
    }
    
    public boolean isValid(){
        return numericCpf.length() == 11;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numericCpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CPF other = (CPF) obj;
        if (!Objects.equals(this.numericCpf, other.numericCpf)) {
            return false;
        }
        return true;
    }
        
}
