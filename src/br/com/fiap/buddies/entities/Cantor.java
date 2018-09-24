package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_CANTOR")
@SequenceGenerator(name="cantor", sequenceName="SEQ_BDS_CANTOR", allocationSize=1, initialValue=1)
public class Cantor {

	@Id
	@Column(name="id_cantor")
	@GeneratedValue(generator="cantor", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name="nm_cantor", nullable=false, length=150)
	private String nomeCantor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCantor() {
		return nomeCantor;
	}

	public void setNomeCantor(String nomeCantor) {
		this.nomeCantor = nomeCantor;
	}	
	
}
