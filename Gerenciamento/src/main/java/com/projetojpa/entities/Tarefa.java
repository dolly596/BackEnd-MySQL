package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity 
@Table(name = "tarefa")
public class Tarefa {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	
	@NotBlank
	@Column(name = "nome")
	private String nome;
	

	@Column(name = "dataLimiteExecucao")
	private String dataLimiteExecucao;
	
	@NotBlank
	@Column(name = "detalhesTarefa")
	private String detalhesTarefa;
	
	@NotBlank
	@Column(name = "statusTarefa")
	private String statusTarefa;
	
	
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
	public String getDataLimite() {
		return statusTarefa;
	}
	public void setDataLimite(String dataLimiteExecucao) {
		this.dataLimiteExecucao = dataLimiteExecucao;
	}
	
	public String getDetalhesTarefa() {
		return detalhesTarefa;
	}
	public void setDetalhesTarefa(String detalhesTarefa) {
		this.detalhesTarefa = detalhesTarefa;
	}
	
	public String getStatusTarefa() {
		return statusTarefa;
	}
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
}
