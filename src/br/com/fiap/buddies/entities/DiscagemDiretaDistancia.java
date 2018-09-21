package br.com.fiap.buddies.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_DDD")
public class DiscagemDiretaDistancia {

	@Id
	private int ddd;

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

}
