package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_FILME")
@SequenceGenerator(name="filme", sequenceName="SEQ_BDS_FILME", initialValue=1, allocationSize=1)
public class Filme {

	@Id
	@Column(name="id_filme")
	@GeneratedValue(generator="filme", strategy=GenerationType.SEQUENCE)
	private int idFilme;

	@Column(name="nm_filme", nullable=false, length=150)
	private String nomeFilme;
	
	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

}
