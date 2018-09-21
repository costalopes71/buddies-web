package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_INTERESSE")
@SequenceGenerator(name = "interesse", sequenceName = "SEQ_BDS_INTERESSE", initialValue = 1, allocationSize = 1)
public class Interesse {

	@Id
	@Column(name = "id_interesse")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interesse")
	private int idInteresse;

	@Column(name = "ds_interesse", nullable = false, length = 50)
	private String interesse;

	public int getIdInteresse() {
		return idInteresse;
	}

	public void setIdInteresse(int idInteresse) {
		this.idInteresse = idInteresse;
	}

	public String getInteresse() {
		return interesse;
	}

	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}

}
