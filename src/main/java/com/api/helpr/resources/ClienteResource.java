package com.api.helpr.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.helpr.domain.Cliente;
import com.api.helpr.domain.dtos.ClienteDTO;
import com.api.helpr.services.ClienteService;

@RestController
@RequestMapping(value = "/service/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}
	
	@GetMapping
	  public ResponseEntity<List<ClienteDTO>> findAllClientes(){
	    List<Cliente> list = service.findAllClientes();
	    List<ClienteDTO> listDto = list.stream()
	        .map(tec -> new ClienteDTO(tec)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDto);
	  }
}
