package com.tercilio.os.api.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tercilio.os.api.domains.Cliente;
import com.tercilio.os.api.domains.OrdemServico;
import com.tercilio.os.api.domains.Tecnico;
import com.tercilio.os.api.domains.enums.Prioridade;
import com.tercilio.os.api.domains.enums.Status;
import com.tercilio.os.api.dtos.OrdemServicoDTO;
import com.tercilio.os.api.repositories.OrdemServicoRepository;
import com.tercilio.os.api.service.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService implements Serializable {

	private static final long serialVersionUID = 1L;


	@Autowired
	private OrdemServicoRepository repository;

	@Autowired
	private TecnicoService tecnicoService;

	@Autowired
	private ClienteService clienteService;

	public OrdemServico findById(Integer id) {
		Optional<OrdemServico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + OrdemServico.class.getName()));
	}

	public List<OrdemServico> findAll() {
		return repository.findAll();
	}

	public OrdemServico create(@Valid OrdemServicoDTO obj) {
		return fromDTO(obj);
	}

	public OrdemServico update(@Valid OrdemServicoDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
	
	private OrdemServico fromDTO(OrdemServicoDTO obj) {
		OrdemServico newObj = new OrdemServico();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade().getCod()));
		newObj.setStatus(Status.toEnum(obj.getStatus().getCod()));

		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());

		newObj.setTecnico(tec);
		newObj.setCliente(cli);

		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newObj);
	}


	
}
