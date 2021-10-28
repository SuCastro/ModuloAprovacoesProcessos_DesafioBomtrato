package DesafioBomtrato.ModuloAprovacoes.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "Usuario")
public class Usuario
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Obrigatório nome completo.")
	private String nomeCompleto;
	
	
	@Email(message = "Obrigatório email.")
	private String email;
	
	
	@NotBlank
	@Size (min = 5, max = 100, message = "Mínimo 5 caracteres.")
	private String senha;
	
	
	@NotBlank (message = "Obrigatório um tipo de usuario.")
	private String tipoDeUsuario;
	
	@OneToMany(mappedBy = "Usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"Usuario"})
	private List<Processo> processoJuridico = new ArrayList<>();

	public Usuario() {
		super();
	}


	public Usuario(Long id, String nomeCompleto, String email,String senha, String tipoDeUsuario) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.tipoDeUsuario = tipoDeUsuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}


	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}


	public List<Processo> getMeusProcessos() {
		return processoJuridico;
	}


	public void setMeusProcessos(List<Processo> processoJuridico) {
		this.processoJuridico = processoJuridico;
	}
	
}