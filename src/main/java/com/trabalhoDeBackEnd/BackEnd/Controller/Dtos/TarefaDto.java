package com.trabalhoDeBackEnd.BackEnd.Controller.Dtos;

import com.trabalhoDeBackEnd.BackEnd.models.entities.Tarefa;

import java.time.LocalDate;
  public record TarefaDto(Long id, String tarefa, LocalDate dataDeEntrega, String responsavelPelaTarefa) {
  public Tarefa toTarefa() {
    return new Tarefa(tarefa, responsavelPelaTarefa,dataDeEntrega);
  }
}
