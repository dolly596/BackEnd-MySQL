package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ItemExecucao")
public class ItemExecucao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	
	@NotBlank
	@Column(name = "percentual")
	private double percentual;
	
	@NotBlank
	@Column(name = "descricao")
	private String descricao;
	
	@NotBlank
	@Column(name = "dataExecucao")
	private String execucao;
	
	@NotBlank
	@Column(name = "statusTarefa")
	private String status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPercentual() {
		return percentual;
	}
	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}
	public String getDataExecucao() {
		return execucao;
	}
	public void setDataExecucao(String execucao) {
		this.execucao = execucao;
	}
	
	public String getStatusTarefa() {
		return status;
	}
	public void setStatusTarefa(String status) {
		this.status = status;
	}
	
}
