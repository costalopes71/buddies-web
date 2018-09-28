package br.com.fiap.buddies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BDS_HISTORICO_CONVERSA")
@SequenceGenerator(name = "historico", sequenceName = "SEQ_BDS_HISTORICO_CONVERSA", allocationSize = 1, initialValue = 1)
public class HistoricoConversa {

	@Id
	@Column(name = "cd_conversa")
	@GeneratedValue(generator="historico", strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column(name="id_conversa", nullable=false)
	private int idConversa;
	
	@Column(name="id_idoso", nullable=false)
	private int idIdoso;
	
	@Column(name = "dt_conversa", nullable = false)
	private long dataConversa;

	@Column(name="st_resposta", nullable = false)
	private int resposta;

	@Column(name = "tx_mensagem", nullable = false)
	private String mensagem;

	public HistoricoConversa() { }
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public long getDataConversa() {
		return dataConversa;
	}

	public void setDataConversa(long dataConversa) {
		this.dataConversa = dataConversa;
	}

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getIdConversa() {
		return idConversa;
	}

	public void setIdConversa(int idConversa) {
		this.idConversa = idConversa;
	}

	public int getIdIdoso() {
		return idIdoso;
	}

	public void setIdIdoso(int idIdoso) {
		this.idIdoso = idIdoso;
	} 
	
}
