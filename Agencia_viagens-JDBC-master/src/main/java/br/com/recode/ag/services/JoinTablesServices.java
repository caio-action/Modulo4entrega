package br.com.recode.ag.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.recode.ag.connfactory.ConnectionFactory;

public class JoinTablesServices {
	
	public void imprimirDestinoOuPromocao() {
		Connection conn =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DestinoPromocao";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			System.out.println("");
			System.out.println("DESTINOS E PROMOÇÕES:");
			System.out.println("");
			while (rs.next()) {
				System.out.println("ID do destino: "+rs.getInt(1));
				System.out.println("Nome do destino: "+rs.getString(2));
				System.out.println("Local de embarque: "+rs.getString(3));
				System.out.println("Nº de horas estimado de viagem: "+rs.getInt(4));
				System.out.println("Data da viagem: "+rs.getDate(5));
				System.out.println("Preço da viagem: R$ "+rs.getDouble(6));
				System.out.println("ID da promoção: "+rs.getString(7));
				System.out.println("Percentual de desconto: "+rs.getDouble(8)+"%");
				System.out.println("Preço com desconto: R$ "+((rs.getDouble(9)==0)? "-":rs.getDouble(9)));
				System.out.println("__________________________________________________");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					
						conn.close();	
				}
				
				if(pstm!=null) {
					
					pstm.close();	
				}
				
				if(rs!=null) {
					
					rs.close();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void imprimirDestinoEPromocao() {
		Connection conn =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DestinoEPromocao";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			System.out.println("");
			System.out.println("DESTINOS EM PROMOÇÃO:");
			System.out.println("");
			while (rs.next()) {
				System.out.println("ID do destino: "+rs.getInt(1));
				System.out.println("Nome do destino: "+rs.getString(2));
				System.out.println("Local de embarque: "+rs.getString(3));
				System.out.println("Nº de horas estimado de viagem: "+rs.getInt(4));
				System.out.println("Data da viagem: "+rs.getDate(5));
				System.out.println("Preço da viagem: R$ "+rs.getDouble(6));
				System.out.println("ID da promoção: "+rs.getString(7));
				System.out.println("Percentual de desconto: "+rs.getDouble(8)+"%");
				System.out.println("Preço com desconto: R$ "+rs.getDouble(9));
				System.out.println("__________________________________________________");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					
					conn.close();	
				}
				
				if(pstm!=null) {
					
					pstm.close();	
				}
				
				if(rs!=null) {
					
					rs.close();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void imprimirDestinoSemPromocao() {
		Connection conn =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DestinoSemPromocao";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			System.out.println("");
			System.out.println("DESTINOS SEM PROMOÇÃO:");
			System.out.println("");
			while (rs.next()) {
				System.out.println("ID do destino: "+rs.getInt(1));
				System.out.println("Nome do destino: "+rs.getString(2));
				System.out.println("Local de embarque: "+rs.getString(3));
				System.out.println("Nº de horas estimado de viagem: "+rs.getInt(4));
				System.out.println("Data da viagem: "+rs.getDate(5));
				System.out.println("Preço da viagem: R$ "+rs.getDouble(6));
				System.out.println("ID da promoção: "+rs.getString(7));
				System.out.println("Percentual de desconto: "+rs.getDouble(8)+"%");
				System.out.println("Preço com desconto: R$ "+((rs.getDouble(9)==0)? "-":rs.getDouble(9)));
				System.out.println("__________________________________________________");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					
					conn.close();	
				}
				
				if(pstm!=null) {
					
					pstm.close();	
				}
				
				if(rs!=null) {
					
					rs.close();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void imprimeViajantes() {
		Connection conn =  null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM TabelaViajantes";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			System.out.println("");
			System.out.println("CLIENTES COM DESTINOS COMPRADOS:");
			System.out.println("");
			while (rs.next()) {
				System.out.println("ID do cliente: "+rs.getInt(1));
				System.out.println("Nome do cliente: "+rs.getString(2));
				System.out.println("CPF do cliente: "+rs.getString(3));
				System.out.println("Telefone do cliente: "+rs.getString(4));
				System.out.println("E-mail do cliente: "+rs.getString(5));
				System.out.println("Cartão de crédito do cliente: "+rs.getString(6));
				
				System.out.println("ID do destino: "+rs.getInt(7));
				System.out.println("Nome do destino: "+rs.getString(8));
				System.out.println("Local de embarque: "+rs.getString(9));
				System.out.println("Nº de horas estimado de viagem: "+rs.getInt(10));
				System.out.println("Data da viagem: "+rs.getDate(11));
				System.out.println("Preço da viagem: R$ "+rs.getDouble(12));
				System.out.println("ID da promoção: "+rs.getString(13));
				System.out.println("Percentual de desconto: "+rs.getDouble(14)+"%");
				System.out.println("Preço com desconto: R$ "+((rs.getDouble(15)==0)? "-":rs.getDouble(15)));
				System.out.println("__________________________________________________");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					
					conn.close();	
				}
				
				if(pstm!=null) {
					
					pstm.close();	
				}
				
				if(rs!=null) {
					
					rs.close();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
