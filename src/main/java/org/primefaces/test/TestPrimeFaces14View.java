package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named("testPf14")
@ViewScoped
public class TestPrimeFaces14View implements Serializable {

    private String valueStr = "0";

    @PostConstruct
    public void init() {
    }

    public String getValueStr() {
        return valueStr;
    }

    public String getValueStrDisabled() {
        return "1";
    }

    public String getValueStrReadOnly() {
        return "2";
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Value changed",
                        "Value changed to: " + (valueStr == null ? "null" : valueStr)));
    }

    public void setValueStrDisabled(String valueStr) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Disabled Value changed",
                        "Value changed to: " + (valueStr == null ? "null" : valueStr)));
    }

    public void setValueStrReadOnly(String valueStr) {
    FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "ReadOnly Value changed",
                    "Value changed to: " + (valueStr == null ? "null" : valueStr)));
    }
}
