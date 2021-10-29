package DesafioBomtrato.ModuloAprovacoes.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import DesafioBomtrato.ModuloAprovacoes.Model.Processo;
import DesafioBomtrato.ModuloAprovacoes.Repository.ProcessoRepository;

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
		
}