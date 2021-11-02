package DesafioBomtrato.ModuloAprovacoes.Service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import DesafioBomtrato.ModuloAprovacoes.Model.Usuario;
import DesafioBomtrato.ModuloAprovacoes.Model.UsuarioDTO;
import DesafioBomtrato.ModuloAprovacoes.Repository.UsuarioRepository;

/**Nessa camada de serviço, utilizei métodos que possibilitam o cadastro de 
 * usuários e de autenticação.
 * 
 * @author Suellen Castro
 */

@Service
public class UsuarioService {

	@Autowired 
  private UsuarioRepository repository;
	
	public Optional<Object> cadastrarUsuario(Usuario novoUsuario) {
		return repository.findByEmail(novoUsuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(senhaCriptografada);
			return Optional.ofNullable(repository.save(novoUsuario));
		});
	}

	public Optional<?> pegarCredenciais(UsuarioDTO usuarioParaAutenticar) {
		return repository.findByEmail(usuarioParaAutenticar.getEmail()).map(usuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(usuarioParaAutenticar.getSenha(), usuarioExistente.getSenha())) {
				String estruturaBasic = usuarioParaAutenticar.getEmail() + ":" + usuarioParaAutenticar.getSenha(); 
				byte[] autorizacaoBase64 = Base64.encodeBase64(estruturaBasic.getBytes(Charset.forName("US-ASCII"))); 
				String autorizacaoHeader = "Basic " + new String(autorizacaoBase64); 

				usuarioParaAutenticar.setToken(autorizacaoHeader);
				usuarioParaAutenticar.setId(usuarioExistente.getId());
				usuarioParaAutenticar.setNomeCompleto(usuarioExistente.getNomeCompleto());
				usuarioParaAutenticar.setTipoDeUsuario(usuarioExistente.getTipoDeUsuario());
				usuarioParaAutenticar.setSenha(usuarioExistente.getSenha());
				return Optional.ofNullable(usuarioParaAutenticar);
			} else {
				return Optional.empty();
				}
		}).orElseGet(() -> {
			return Optional.empty();

		});
	
		}
}