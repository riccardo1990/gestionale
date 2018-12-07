package com.trenota.gestionale;

public class Utenti {

    private String name;
    private String surname;
    private String projectId;

    public Utenti(String name, String surname, String projectId) {
        this.name = name;
        this.surname = surname;
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
