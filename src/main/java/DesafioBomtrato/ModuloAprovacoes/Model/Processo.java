package DesafioBomtrato.ModuloAprovacoes.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe Processo utilizada como entidade para registrar processo no Banco de dados. Além disso,
 * utilizei de anotações que restrigiam caracteres, valores e numerais. Também acrescentei ao código
 * uma nova anotação aprendida, a Column, sendo que meu objetivo era não deixar campos nulos. Por fim,
 * fiz uma lógica de negócio onde todos os novos processos criados, iniciem com status 'ativo'(true) e
 * 'reprovado'(false). 
 *  
 * @author Suellen Castro
 *
 */

@Entity
@Table(name="tb_processo")
	public class Processo {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Min(value = 30000, message = "Insira valores acima de R$ 30.000,00.")
		@Digits(integer = 5, fraction = 2, message = "Apenas dezenas de milhares e 2 casas após o ponto.")
		private BigDecimal valorCausa;
				
		@Pattern(regexp="^[A-Za-z\s]{1,50}$", message = "Apenas letras no campo 'escritório'.")
		private String escritorio;
				
		@Pattern(regexp="^[A-Za-z\s]{1,100}$", message = "Apenas letras.")
		private String reclamante;
				
		@ManyToOne
		@JsonIgnoreProperties("processoJuridico")
		private Usuario usuario;
		
		@Column(nullable=false)
		private Boolean status=true;
		
		@Column(nullable=false)
		private Boolean aprovacao=false;

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public BigDecimal getValorCausa() {
			return valorCausa;
		}


		public void setValorCausa(BigDecimal valorCausa) {
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
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}


		public Boolean getStatus() {
			return status;
		}


		public void setStatus(Boolean status) {
			this.status = status;
		}


		public Boolean getAprovacao() {
			return aprovacao;
		}


		public void setAprovacao(Boolean aprovacao) {
			this.aprovacao = aprovacao;
		}

	 		
}