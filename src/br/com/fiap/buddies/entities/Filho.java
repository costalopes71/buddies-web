package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_FILHO")
@SequenceGenerator(name="filho", sequenceName="SEQ_BDS_FILHO", allocationSize=1, initialValue=1)
public class Filho {

	@Id
	@Column(name = "id_filho")
	@GeneratedValue(generator="filho", strategy=GenerationType.SEQUENCE)
	private int idFilho;

	@Column(name = "nm_filho", nullable = false, length = 150)
	private String nomeFilho;

	public int getIdFilho() {
		return idFilho;
	}

	public void setIdFilho(int idFilho) {
		this.idFilho = idFilho;
	}

	public String getNomeFilho() {
		return nomeFilho;
	}

	public void setNomeFilho(String nomeFilho) {
		this.nomeFilho = nomeFilho;
	}

}
