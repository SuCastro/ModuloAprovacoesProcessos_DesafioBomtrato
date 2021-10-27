package DesafioBomtrato.ModuloAprovacoes.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DesafioBomtrato.ModuloAprovacoes.Models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail (String email);
	
	List<Usuario> findByNomeCompletoContainingIgnoreCase (String nomeCompleto);
	
}