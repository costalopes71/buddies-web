package br.com.fiap.buddies.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_BDS_HISTORICO_CONVERSA")
@SequenceGenerator(name = "historico", sequenceName = "SEQ_BDS_HISTORICO_CONVERSA", allocationSize = 1, initialValue = 1)
public class HistoricoConversa {

	@Id
	@Column(name = "id_conversa")
	@GeneratedValue(generator="historico", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name = "dt_conversa", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataConversa;

	@Column(nullable = false)
	private boolean resposta;

	@Column(name = "tx_conversa", nullable = false)
	private String textoConversa;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Idoso usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataConversa() {
		return dataConversa;
	}

	public void setDataConversa(Calendar dataConversa) {
		this.dataConversa = dataConversa;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public String getTextoConversa() {
		return textoConversa;
	}

	public void setTextoConversa(String textoConversa) {
		this.textoConversa = textoConversa;
	}

	public Idoso getUsuario() {
		return usuario;
	}

	public void setUsuario(Idoso usuario) {
		this.usuario = usuario;
	}

}
