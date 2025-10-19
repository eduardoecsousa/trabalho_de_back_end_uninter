package com.trabalhoDeBackEnd.BackEnd.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tarefa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String tarefa;

  @Column
  private LocalDate dataDeEntrega;

  @Column
  private String responsavelPelaTarefa;

  public Tarefa(){}

  public Tarefa(String tarefa, String responsavelPelaTarefa, LocalDate dataDeEntrega) {
    this.tarefa = tarefa;
    this.responsavelPelaTarefa = responsavelPelaTarefa;
    this.dataDeEntrega = dataDeEntrega;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTarefa() {
    return tarefa;
  }

  public void setTarefa(String tarefa) {
    this.tarefa = tarefa;
  }

  public LocalDate getDataDeEntrega() {
    return dataDeEntrega;
  }

  public void setDataDeEntrega(LocalDate dataDeEntrega) {
    this.dataDeEntrega = dataDeEntrega;
  }

  public String getResponsavelPelaTarefa() {
    return responsavelPelaTarefa;
  }

  public void setResponsavelPelaTarefa(String responsavelPelaTarefa) {
    this.responsavelPelaTarefa = responsavelPelaTarefa;
  }
}
