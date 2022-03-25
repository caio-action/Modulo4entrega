package br.com.recode.ag.model;

public class Cliente {
	private Integer idCliente;
	private String nomeCliente;
	private String CPF;
	private String tel;
	private String email;
	private String creditCard;
	private Integer idDestino;
	
	
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public Integer getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}
	
	
	
}
