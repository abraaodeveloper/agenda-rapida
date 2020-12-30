package com.agendauniversitaria.agendarapida.model;

import java.io.Serializable;

public class Lembrete implements Serializable {

    private int id;
    private String nome;
    private String descricao;
    private String horaAlarme;

    public Lembrete() {}

    public Lembrete(int id, String nome, String descricao, String horaAlarme) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.horaAlarme = horaAlarme;
    }

    public String getHoraAlarme() {
        return horaAlarme;
    }

    public void setHoraAlarme(String horaAlarme) {
        this.horaAlarme = horaAlarme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
