package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private Boolean value;

    @PostConstruct
    public void init() {
    }

    public Boolean getValue() {
        return value;
    }

    public Boolean getValueDisabled() {
        return true;
    }

    public Boolean getValueReadOnly() {
        return false;
    }

    public void setValue(Boolean value) {
        this.value = value;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Value changed",
                        "Value changed to: " + (value == null ? "null" : value.toString())));
    }

    public void setValueDisabled(Boolean value) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Disabled Value changed",
                        "Value changed to: " + (value == null ? "null" : value.toString())));
    }

    public void setValueReadOnly(Boolean value) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "ReadOnly Value changed",
                        "Value changed to: " + (value == null ? "null" : value.toString())));
    }
}
