package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.repository.ItemExecucaoRepository;

@Service
public class ItemExecucaoService {
	private final ItemExecucaoRepository itemExecucaoRepository;
	
	@Autowired
	public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
		this.itemExecucaoRepository = itemExecucaoRepository;
	}
	
	public List<ItemExecucao> buscaTodasExecucao(){
		return itemExecucaoRepository.findAll();
	}
	
	public ItemExecucao buscaExecucaoId (Long id) {
		Optional <ItemExecucao> execucao = itemExecucaoRepository.findById(id);
		return execucao.orElse(null);			
	}
	
	public ItemExecucao salvaExecucao(ItemExecucao itemExecucao) {
		return itemExecucaoRepository.save(itemExecucao);
	}
	
	public ItemExecucao alterarExecucao (Long id, ItemExecucao alterarExecucao) {
		Optional <ItemExecucao> existeExecucao = itemExecucaoRepository.findById(id);
		if (existeExecucao.isPresent()) {
			alterarExecucao.setId(id);
			return itemExecucaoRepository.save(alterarExecucao);
		}
		return null;
	}
	
	public boolean apagarExecucao(Long id) {
		Optional <ItemExecucao> existeExecucao = itemExecucaoRepository.findById(id);
		if (existeExecucao.isPresent()) {
			itemExecucaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
