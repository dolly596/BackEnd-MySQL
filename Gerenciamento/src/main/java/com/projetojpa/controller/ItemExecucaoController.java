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

import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.service.ItemExecucaoService;


@RestController
@RequestMapping("/execucao")
public class ItemExecucaoController {

	private final ItemExecucaoService itemExecucaoService;

	@Autowired
	public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
		this.itemExecucaoService = itemExecucaoService;
	}
	@GetMapping ("/{id}")
	public ResponseEntity<ItemExecucao> buscaExecucaoIdControlId (@PathVariable Long id) {
		ItemExecucao execucao = itemExecucaoService.buscaExecucaoId(id);
		if (execucao != null) {
			return ResponseEntity.ok(execucao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<ItemExecucao>> buscaTodasExecucaoControl(){
		List<ItemExecucao> execucao = itemExecucaoService.buscaTodasExecucao();
		return ResponseEntity.ok(execucao);
	}
	@PostMapping("/")
	public ResponseEntity<ItemExecucao> salvaItemExecucaoControl(@RequestBody ItemExecucao itemExecucao){
		ItemExecucao salvaExecucao = itemExecucaoService.salvaExecucao(itemExecucao);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaExecucao);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ItemExecucao> alterarItemExecucaoControl(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao){
		ItemExecucao alterarExecucao = itemExecucaoService.alterarExecucao(id, itemExecucao);
		if(alterarExecucao != null) {
			return ResponseEntity.ok(alterarExecucao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarExecucaoControl(@PathVariable Long id){
		boolean apagar = itemExecucaoService.apagarExecucao(id);
		if (apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
