package com.trenota.gestionale;

import java.util.List;

public class Container {

    private String containerCode;
    private List<Utenti> listaUtenti;

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
    }

    public List<Utenti> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(List<Utenti> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
}
