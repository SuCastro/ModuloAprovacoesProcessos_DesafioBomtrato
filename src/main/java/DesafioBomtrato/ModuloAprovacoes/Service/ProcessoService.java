package DesafioBomtrato.ModuloAprovacoes.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import DesafioBomtrato.ModuloAprovacoes.Model.Processo;
import DesafioBomtrato.ModuloAprovacoes.Repository.ProcessoRepository;

/**Nesta classe utilizei de métodos que permitem a edição, inativação e aprovação de processos.
 * 
 * @author Suellen Castro
 */

@Service
public class ProcessoService {


	private @Autowired ProcessoRepository repositoryP;

	public Optional<Processo> editarProcesso(Processo processoParaEditar) {
		return repositoryP.findById(processoParaEditar.getId()).map(processoExistente -> {
			processoExistente.setValorCausa(processoParaEditar.getValorCausa());
			processoExistente.setEscritorio(processoParaEditar.getEscritorio());
			return Optional.ofNullable(repositoryP.save(processoExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	public Optional<Processo> inativarProcesso(Long id) {
		Optional<Processo> processoEncontrado=repositoryP.findById(id);
		if(processoEncontrado.isPresent()) {
			Processo processo=processoEncontrado.get();
			processo.setStatus(false);
			return Optional.ofNullable(repositoryP.save(processo));
		}else {
			return Optional.empty();
		}
	}
	
	public Optional<Processo> ativarProcesso(Long id) {
		Optional<Processo> processoEncontrado=repositoryP.findById(id);
		if(processoEncontrado.isPresent()) {
			Processo processo=processoEncontrado.get();
			processo.setStatus(true);
			return Optional.ofNullable(repositoryP.save(processo));
		}else {
			return Optional.empty();
		}
	}
	
	public Optional<Processo> aprovarProcesso(Long id) {
		Optional<Processo> processoAprovado=repositoryP.findById(id);
		if(processoAprovado.isPresent()) {
			Processo processo=processoAprovado.get();
			processo.setAprovacao(true);
			return Optional.ofNullable(repositoryP.save(processo));
		}else {
			return Optional.empty();
		}
	}
		
}