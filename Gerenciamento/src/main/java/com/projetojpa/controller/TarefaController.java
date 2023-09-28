package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Tarefa;
import com.projetojpa.service.TarefaService;


@RestController
@RequestMapping("/tarefa")
public class TarefaController {
private final TarefaService tarefaService;
	
	@Autowired
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Tarefa> buscaTarefaIdControlId (@ PathVariable Long id) {
		Tarefa tarefa = tarefaService.buscaTarefaId(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Tarefa>> buscaTodasTarefaControl(){
		List<Tarefa> tarefa = tarefaService.buscaTodasTarefas();
		return ResponseEntity.ok(tarefa);
	}
	@PostMapping("/")
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody Tarefa tarefa){
		Tarefa salvaTarefa = tarefaService.salvaTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> alterarTarefaControl(@PathVariable Long id, @RequestBody Tarefa tarefa){
		Tarefa alterarTarefa = tarefaService.alterarTarefa(id, tarefa);
		if(alterarTarefa != null) {
			return ResponseEntity.ok(alterarTarefa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaTarefaControl(@PathVariable Long id){
		boolean apagar = tarefaService.apagarTarefa(id);
		if (apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
