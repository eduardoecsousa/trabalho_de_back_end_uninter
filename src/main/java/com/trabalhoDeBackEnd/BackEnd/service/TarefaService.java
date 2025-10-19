package com.trabalhoDeBackEnd.BackEnd.service;

import com.trabalhoDeBackEnd.BackEnd.Error.TaredaNotFoundException;
import com.trabalhoDeBackEnd.BackEnd.models.entities.Tarefa;
import com.trabalhoDeBackEnd.BackEnd.models.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
  private TarefaRepository tarefaRepository;

  @Autowired
  public TarefaService(TarefaRepository tarefaRepository){
    this.tarefaRepository = tarefaRepository;
  }

  public List<Tarefa> listTarefas() {
    return tarefaRepository.findAll();
  }

  public Tarefa showTarefa(Long id){
    Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
    if (optionalTarefa.isEmpty()){
      throw new TaredaNotFoundException("Tarefa Not Found");
    }
    return optionalTarefa.get();
  }

  public Tarefa registerTarefa(Tarefa tarefa){
    return tarefaRepository.save(tarefa);
  }

  public Tarefa updateTarefa(Long id, Tarefa tarefa) {
    Tarefa beforeTarefa = this.showTarefa(id);
    beforeTarefa.setTarefa(tarefa.getTarefa());
    beforeTarefa.setResponsavelPelaTarefa(tarefa.getResponsavelPelaTarefa());
    beforeTarefa.setDataDeEntrega(tarefa.getDataDeEntrega());

    Tarefa afterTarefa = tarefaRepository.save(beforeTarefa);
    return afterTarefa;
  }

  public void deteleTarefa(Long id){
    Tarefa tarefa = this.showTarefa(id);

    tarefaRepository.deleteById(id);
  }
}
