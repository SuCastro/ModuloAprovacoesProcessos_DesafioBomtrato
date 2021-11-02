package DesafioBomtrato.ModuloAprovacoes.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DesafioBomtrato.ModuloAprovacoes.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	
	/**O método abaixo procura em toda a lista de usuarios cadastrados, usuário 
	 * expecífico pelo e-mail.
	 * 
	 * @author Suellen Castro
	 */
	
	public Optional<Usuario> findByEmail (String email);
	
	
	/**O método abaixo procura em toda a lista de usuarios cadastrados, usuário pelo
	 * nome completo.
	 * 
	 * @author Suellen Castro
	 */
			
	List<Usuario> findByNomeCompletoContainingIgnoreCase (String nomeCompleto);
	
}