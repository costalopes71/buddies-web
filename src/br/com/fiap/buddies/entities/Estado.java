package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_ESTADO")
@SequenceGenerator(name="estado", sequenceName="SEQ_BDS_ESTADO", initialValue=1, allocationSize=1)
public class Estado {

	@Id
	@Column(name="id_estado")
	@GeneratedValue(generator="estado", strategy=GenerationType.SEQUENCE)
	private int idEstado;
	
	@Column(name="nm_estado", nullable=false, length=150)
	private String nomeEstado;
	
	@Column(name="sg_estado", nullable=false, length=2)
	private String sigla;

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
