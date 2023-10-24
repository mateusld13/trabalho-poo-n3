package com.apicomsqlite.poo.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Time {

    @Id
    private int id;

    private String nome;

    private String goleiro;
    private String zagueiro;
    private String lateral;
    private String volante;
    private String meioAtacante;
    private String meioCampo;
    private String atacante;

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

    public String getGoleiro() {
        return goleiro;
    }

    public void setGoleiro(String goleiro) {
        this.goleiro = goleiro;
    }

    public String getZagueiro() {
        return zagueiro;
    }

    public void setZagueiro(String zagueiro) {
        this.zagueiro = zagueiro;
    }

    public String getLateral() {
        return lateral;
    }

    public void setLateral(String lateral) {
        this.lateral = lateral;
    }

    public String getVolante() {
        return volante;
    }

    public void setVolante(String volante) {
        this.volante = volante;
    }

    public String getMeioAtacante() {
        return meioAtacante;
    }

    public void setMeioAtacante(String meioAtacante) {
        this.meioAtacante = meioAtacante;
    }

    public String getMeioCampo() {
        return meioCampo;
    }

    public void setMeioCampo(String meioCampo) {
        this.meioCampo = meioCampo;
    }

    public String getAtacante() {
        return atacante;
    }

    public void setAtacante(String atacante) {
        this.atacante = atacante;
    }

}
