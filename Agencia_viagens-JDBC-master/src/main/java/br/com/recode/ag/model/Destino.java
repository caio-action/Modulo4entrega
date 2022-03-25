package br.com.recode.ag.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Destino {
	private Integer idDestino;
	private String nomeDestino;
	private String localPartida;
	private Integer horasDeViagem;
	private Date dataViagem;
	private Double preco;
	
	
	public Integer getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public String getLocalPartida() {
		return localPartida;
	}
	public void setLocalPartida(String localPartida) {
		this.localPartida = localPartida;
	}
	public Integer getHorasDeViagem() {
		return horasDeViagem;
	}
	public void setHorasDeViagem(Integer horasDeViagem) {
		this.horasDeViagem = horasDeViagem;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		int dia;
		int mes;
		int ano;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o dia do m�s que ocorrer� o embarque? ");
		dia = sc.nextInt();
		System.out.println("Digite o m�s que ocorrer� a viagem? (1 a 12) ");
		mes = sc.nextInt();
		mes-=1;
		System.out.println("Digite o ano da viagem? ");
		ano = sc.nextInt();
		
		
		
		Calendar dataCalendario = new GregorianCalendar(ano, mes, dia);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		String dataText = sdf.format(dataCalendario.getTime());
		try {
			dataViagem = sdf.parse(dataText);
			this.dataViagem = dataViagem;
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}
	
	public void selectDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
