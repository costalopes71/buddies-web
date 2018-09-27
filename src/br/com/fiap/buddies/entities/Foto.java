package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_BDS_FOTO")
@SequenceGenerator(name="foto", sequenceName="SEQ_BDS_FOTO", initialValue=1, allocationSize=1)
public class Foto {

	@Id
	@Column(name="id_foto")
	@GeneratedValue(generator="foto", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ds_url", nullable=false, length=500)
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_idoso", nullable=false)
	private Idoso idoso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Idoso getIdoso() {
		return idoso;
	}

	public void setIdoso(Idoso idoso) {
		this.idoso = idoso;
	}

}
