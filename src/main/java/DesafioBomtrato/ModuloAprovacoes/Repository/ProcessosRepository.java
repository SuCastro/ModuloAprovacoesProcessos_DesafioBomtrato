package DesafioBomtrato.ModuloAprovacoes.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DesafioBomtrato.ModuloAprovacoes.Models.Processos;


@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Long> {
	
	Processos findAllById (Long id);
	
	Processos findAllByValorCausa (Double valorCausa);
	
	Optional <List<Processos>> findAllByEscritorioContainingIgnoreCase (String escritorio);
	
	List<Processos> findAllByReclamanteContainingIgnoreCase (String reclamante);

}