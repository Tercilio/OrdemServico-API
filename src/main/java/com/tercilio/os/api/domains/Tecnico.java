package com.tercilio.os.api.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "tecnico") // MAPEADO PELO ATRIBUTO tecnico, la na OrdemServico
	private List<OrdemServico> list = new ArrayList<>();

	public Tecnico() {
		super();

	}

	public Tecnico(Integer id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);

	}

	public List<OrdemServico> getList() {
		return list;
	}

	public void setList(List<OrdemServico> list) {
		this.list = list;
	}

}
