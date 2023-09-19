package com.nbeverton;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name="user")
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String testeJSF;

    public String getTesteJSF() {
        return testeJSF;
    }

    public void setTesteJSF(String testeJSF) {
        this.testeJSF = testeJSF;
    }
}
