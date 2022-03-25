package br.com.recode.ag.model;

public class Promocao {
	private Integer idPromocao;
	private Integer idDestino;
	private Double percentualDesconto;
	
	public Integer getIdPromocao() {
		return idPromocao;
	}
	public void setIdPromocao(Integer idPromocao) {
		this.idPromocao = idPromocao;
	}
	public Integer getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}
	public Double getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	
	
}
