package DesafioBomtrato.ModuloAprovacoes.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DesafioBomtrato.ModuloAprovacoes.Model.Processo;


@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
	
	/**O método abaixo procura em toda a lista de processos, processos expecíficos pelo
	 * valor da causa.
	 * 
	 * @author Suellen Castro
	 */
	
	List<Processo> findAllByValorCausa (BigDecimal valorCausa);
	
	
	/**O método abaixo procura em toda a lista de processos, processos expecíficos pelo
	 * nome do escritório.
	 * 
	 * @author Suellen Castro
	 */
	
	Optional <List<Processo>> findAllByEscritorioContainingIgnoreCase (String escritorio);
	
	
	/**O método abaixo procura em toda a lista de processos, processos expecíficos pelo
	 * nome do reclamante.
	 * 
	 * @author Suellen Castro
	 */
	
	List<Processo> findAllByReclamanteContainingIgnoreCase (String reclamante);

}