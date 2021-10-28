package DesafioBomtrato.ModuloAprovacoes.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
		public ResponseEntity<List<Processo>> GetByValorCausa (@PathVariable Double valorCausa) {
			return ResponseEntity.ok(repository.findAll());
		}
		
		@PostMapping("/cadastrar")
		public ResponseEntity<Object> cadastrarProcesso(@Valid @RequestBody Processo novoProcesso) {
			Optional<?> objetoCadastrado = service.cadastrarProcesso(novoProcesso);

			if (objetoCadastrado.isPresent()) {
				return ResponseEntity.status(201).body(objetoCadastrado.get());
			} else {
				return ResponseEntity.status(400).build();
			}

		}

		@PutMapping("/editar")
		public ResponseEntity<Object> editar (@Valid @RequestBody Processo processoParaEditar) {
			Optional<Processo> objetoEditado = service.editarProcesso(processoParaEditar);

			if (objetoEditado.isPresent()) {
				return ResponseEntity.status(201).body(objetoEditado.get());
			} else {
				return ResponseEntity.status(400).build();
			}
		}
		
		@DeleteMapping("/inativar/{id}")
		public ResponseEntity<Object> inativarPorId(@PathVariable(value = "id") Long id) {
			Optional<Processo> objetoExistente = repository.findById(id);
			if (objetoExistente.isPresent()) {
				repository.deleteById(id);
				return ResponseEntity.status(200).build();
			} else {
				return ResponseEntity.status(400).build();
			}

		}
		
}