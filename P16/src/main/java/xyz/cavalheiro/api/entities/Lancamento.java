package xyz.cavalheiro.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import xyz.cavalheiro.api.enums.TipoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataLancamento;
	private String descricacao;
	private String localizacao;
	private TipoEnum tipoLancamento;
	private Funcionario funcionario;
	private Date dataCriacao;
	private Date dataAtualizacao;
	
	public Lancamento() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_lancamento", nullable = false)
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	@Column(name = "decricao", nullable = true)
	public String getDescricacao() {
		return descricacao;
	}


	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	@Column(name = "localizacao", nullable = true)
	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_lancamento", nullable = false)
	public TipoEnum getTipoLancamento() {
		return tipoLancamento;
	}


	public void setTipoLancamento(TipoEnum tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}


	@PrePersist
	public void prePersist() {
		final Date atual = new Date(0);
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date(0);
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", dataLancamento=" + dataLancamento + ", descricacao=" + descricacao
				+ ", localizacao=" + localizacao + ", tipoLancamento=" + tipoLancamento + ", funcionario=" + funcionario
				+ ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	
	
}
