package DesafioBomtrato.ModuloAprovacoes.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DesafioBomtrato.ModuloAprovacoes.Model.Processo;
import DesafioBomtrato.ModuloAprovacoes.Repository.ProcessoRepository;
import DesafioBomtrato.ModuloAprovacoes.Service.ProcessoService;

/**
 * Nessa classe possui os endpoints da API para cadastrar, editar, inativar 
 * ou ativar e aprovar.
 * 
 * @author Suellen Castro
 */

@RestController
@RequestMapping("/Processo")
@CrossOrigin("*")
public class ProcessoController {

	@Autowired
	private ProcessoRepository repository;

	@Autowired
	private ProcessoService service;

	@GetMapping
	public ResponseEntity<List<Processo>> GetAll() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Processo> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).build());
	}

	@GetMapping("/valorCausa/{valorCausa}")
	public ResponseEntity<List<Processo>> GetByValorCausa(@PathVariable BigDecimal valorCausa) {
		return ResponseEntity.ok(repository.findAllByValorCausa(valorCausa));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Processo> post(@RequestBody Processo processo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(processo));
	}

	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Processo processoParaEditar) {
		Optional<Processo> objetoEditado = service.editarProcesso(processoParaEditar);

		if (objetoEditado.isPresent()) {
			return ResponseEntity.status(201).body(objetoEditado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@PutMapping("/inativar/{id}")
	public ResponseEntity<Object> inativarPorId(@PathVariable(value = "id") Long id) {
		Optional<Processo> objetoInativado = service.inativarProcesso(id);

		if (objetoInativado.isPresent()) {
			return ResponseEntity.status(201).body(objetoInativado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@PutMapping("/ativar/{id}")
	public ResponseEntity<Object> ativarPorId(@PathVariable(value = "id") Long id) {
		Optional<Processo> objetoAtivado = service.ativarProcesso(id);

		if (objetoAtivado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAtivado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@PutMapping("/aprovar/{id}")
	public ResponseEntity<Object> aprovarPorId(@PathVariable(value = "id") Long id) {
		Optional<Processo> objetoAprovado = service.aprovarProcesso(id);

		if (objetoAprovado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAprovado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

}