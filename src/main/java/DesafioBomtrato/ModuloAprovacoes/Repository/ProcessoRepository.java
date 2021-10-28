package DesafioBomtrato.ModuloAprovacoes.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DesafioBomtrato.ModuloAprovacoes.Model.Processo;


@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
	
	Processo findAllById (Long id);
	
	Processo findAllByValorCausa (Double valorCausa);
	
	Optional <List<Processo>> findAllByEscritorioContainingIgnoreCase (String escritorio);
	
	List<Processo> findAllByReclamanteContainingIgnoreCase (String reclamante);

}