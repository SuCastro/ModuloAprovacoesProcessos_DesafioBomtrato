package DesafioBomtrato.ModuloAprovacoes.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Processos")
	public class Processos {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		@Digits(integer = 8, fraction = 2, message = "Apenas milhares e 2 casas após o ponto")
		private Double valorCausa;
		
		@NotBlank
		@Size(min=3, max=255)
		private String escritorio;
	
		
		@NotBlank
		private String reclamante;
		
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JsonIgnoreProperties({ "processosJuridicos" })
		private Usuario Usuario;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Double getValorCausa() {
			return valorCausa;
		}


		public void setValorCausa(Double valorCausa) {
			this.valorCausa = valorCausa;
		}


		public String getEscritorio() {
			return escritorio;
		}


		public void setEscritorio(String escritorio) {
			this.escritorio = escritorio;
		}


		public String getReclamante() {
			return reclamante;
		}


		public void setReclamante(String reclamante) {
			this.reclamante = reclamante;
		}


		public Usuario getUsuario() {
			return Usuario;
		}


		public void setUsuario(Usuario usuario) {
			Usuario = usuario;
		}
	 		
}