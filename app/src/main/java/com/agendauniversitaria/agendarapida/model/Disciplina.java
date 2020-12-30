package com.agendauniversitaria.agendarapida.model;

public class Disciplina {

    private int id;
    private String nomeDisc;
    private String nomeProf;
    private String sala;
    private String descricao;

    public Disciplina(int id, String nomeDisc, String nomeProf, String sala, String descricao) {
        this.id = id;
        this.nomeDisc = nomeDisc;
        this.nomeProf = nomeProf;
        this.sala = sala;
        this.descricao = descricao;
    }

    public Disciplina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDisc() {
        return nomeDisc;
    }

    public void setNomeDisc(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
