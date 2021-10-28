package DesafioBomtrato.ModuloAprovacoes.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DesafioBomtrato.ModuloAprovacoes.Model.Processo;
import DesafioBomtrato.ModuloAprovacoes.Repository.ProcessoRepository;
import DesafioBomtrato.ModuloAprovacoes.Repository.UsuarioRepository;

@Service
public class ProcessoService {


	private @Autowired ProcessoRepository repositoryP;
	
	private @Autowired UsuarioRepository repositoryU;

	public cadastrarProcesso(Processo novoProcesso) {
		//Optional<Tema> objetoExistente = repositorioT.findById(novaPostagem.getTema().getId());
		return repositoryU.findById(novoProcesso.getUsuario().getId()).map(usuarioExistente -> {
			if (usuarioExistente.getMeusProcessos()) {
				novoProcesso.setUsuario(usuarioExistente);
				return Optional.ofNullable(repositoryP.save(novoProcesso));
			} else {
				return Optional.empty();
			}
		}); /*.orElseGet(() -> {
			return Optional.empty();
		})*/
	}

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