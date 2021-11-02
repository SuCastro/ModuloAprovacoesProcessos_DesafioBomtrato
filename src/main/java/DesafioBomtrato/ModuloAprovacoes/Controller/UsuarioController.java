package DesafioBomtrato.ModuloAprovacoes.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DesafioBomtrato.ModuloAprovacoes.Model.Usuario;
import DesafioBomtrato.ModuloAprovacoes.Model.UsuarioDTO;
import DesafioBomtrato.ModuloAprovacoes.Repository.UsuarioRepository;
import DesafioBomtrato.ModuloAprovacoes.Service.UsuarioService;

/**Nessa classe possui os endpoints da API para cadastrar, autenticar e endpoints de busca.
 * 
 * @author Suellen Castro
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
		@Autowired
		private UsuarioRepository repository;

		@Autowired
		private UsuarioService service;

		@PostMapping("/cadastrar")
		public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
			Optional<Object> objetoCadastrado = service.cadastrarUsuario(novoUsuario);

			if (objetoCadastrado.isPresent()) {
				return ResponseEntity.status(201).body(objetoCadastrado.get());
			} else {
				return ResponseEntity.status(400).build();
			}
			
		}
		
		@PutMapping("/autenticar")
		public ResponseEntity<Object> pegarCredenciais(@Valid @RequestBody UsuarioDTO loginSenha) {
			Optional<?> objetoCredenciado = service.pegarCredenciais(loginSenha);

			if (objetoCredenciado.isPresent()) {
				return ResponseEntity.status(201).body(objetoCredenciado.get());
			} else {
				return ResponseEntity.status(400).build();
			}
			
		}
		
		@GetMapping("/todos")
		public ResponseEntity<Object> buscarTodes() {
			List<Usuario> listaUsuarios = repository.findAll();
			
			if (listaUsuarios.isEmpty()) {
				return ResponseEntity.status(204).build();
			} else {
				return ResponseEntity.status(200).body(listaUsuarios);
			}
			
		}

		@GetMapping("/{id}")
		public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id") Long id) {
			return ResponseEntity.status(200).body(repository.findById(id).get());
		}

		@GetMapping("/pesquisa")
		public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(defaultValue = "") String nomeCompleto) {
			return ResponseEntity.status(200).body(repository.findByNomeCompletoContainingIgnoreCase(nomeCompleto));
		}
		
		
		@DeleteMapping("/deletar/{idUsuario}")
		public ResponseEntity<String> deletarPorId(@PathVariable Long idUsuario) {
			Optional<Usuario> usuarioExistente = repository.findById(idUsuario);
			if (usuarioExistente.isPresent()) {
				repository.deleteById(idUsuario);
				return ResponseEntity.status(200).build();
			} else {
				return ResponseEntity.status(400).build();
			}
			
		}

	}