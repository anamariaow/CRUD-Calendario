package com.calendar.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private LocalDateTime dataDiNascita;

//    @OneToMany
//    private Calendario calendario;

    public User(Long id, String nome, String cognome, LocalDateTime dataDiNascita, Calendario calendario) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
//        this.calendario = calendario;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDateTime getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDateTime dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

//    public Calendario getCalendario() {
//        return calendario;
//    }
//
//    public void setCalendario(Calendario calendario) {
//        this.calendario = calendario;
//    }
}
