package com.trabalhoDeBackEnd.BackEnd.Controller;

import com.trabalhoDeBackEnd.BackEnd.Controller.Dtos.TarefaDto;
import com.trabalhoDeBackEnd.BackEnd.models.entities.Tarefa;
import com.trabalhoDeBackEnd.BackEnd.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {
  private TarefaService tarefaService;

  @Autowired
  public TarefaController(TarefaService tarefaService){
    this.tarefaService = tarefaService;
  }

  @PostMapping
  public ResponseEntity<Tarefa> create(@RequestBody TarefaDto tarefaDto){
    Tarefa newTarefa = tarefaService.registerTarefa(tarefaDto.toTarefa());
    return ResponseEntity.status(HttpStatus.CREATED).body(newTarefa);
  }

  @GetMapping()
  public ResponseEntity<List<Tarefa>> getAll(){
    return ResponseEntity.ok(tarefaService.listTarefas());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Tarefa> getBayId(@PathVariable Long id){
    return ResponseEntity.ok(tarefaService.showTarefa(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody TarefaDto tarefaDto){
    return ResponseEntity.ok(tarefaService.updateTarefa(id, tarefaDto.toTarefa()));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id){
    tarefaService.deteleTarefa(id);
    return ResponseEntity.ok("Tarefa deletada");
  }
}
