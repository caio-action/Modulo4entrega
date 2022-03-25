package br.com.recode.ag.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.recode.ag.connfactory.ConnectionFactory;
import br.com.recode.ag.model.Promocao;

public class PromocaoServices {

	public List<Promocao> getPromocoes(){
		String sql = "SELECT * FROM PROMOCAO";
		
		List<Promocao> promocoes = new ArrayList<Promocao>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		
		conn = ConnectionFactory.createConnectionToMySQL();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			
			
			while(rs.next()) {
				Promocao promocao = new Promocao();
				
				promocao.setIdPromocao(rs.getInt("idPromocao"));
				promocao.setPercentualDesconto(rs.getDouble("percentualDesconto"));
				promocao.setIdDestino(rs.getInt("idDestino"));
				
				promocoes.add(promocao);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
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
		
		return promocoes;
	}
	
	public void imprimePromocoes(){
		System.out.println("__________LISTA DE PROMO��ES__________");
		for (Promocao p : this.getPromocoes()) {
			System.out.println("ID da Promo��o: "+ p.getIdPromocao());
			System.out.println("Percentual de desconto: "+p.getPercentualDesconto()+"%");
			System.out.println("ID do destino em promo��o: "+p.getIdDestino());
			System.out.println("__________________________________________________");
		}
	}

	public void savePromocao(Promocao promocao) {
		Scanner sc = new Scanner(System.in);
		String sql = "INSERT INTO PROMOCAO (idDestino, percentualDesconto) VALUES (?, ?)";
		JoinTablesServices joinTablesServices = new JoinTablesServices();
		
		
		joinTablesServices.imprimirDestinoSemPromocao(); 
		System.out.println("Digite o ID do destino que voc� deseja inserir a promo��o: ");
		promocao.setIdDestino(sc.nextInt());
		System.out.println("Digite o percentual de desconto que ser� dado na promo��o: ");
		promocao.setPercentualDesconto(sc.nextDouble());
		System.out.println("");
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, promocao.getIdDestino());
			pstm.setDouble(2, promocao.getPercentualDesconto());
			
			pstm.executeUpdate();
			
			System.out.println("Promo��o cadastrada com sucesso.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				
				if (conn != null) {
					
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void deletePromocao(Promocao promocao) {
		String sql = "DELETE FROM PROMOCAO WHERE idPromocao = ?";
		Scanner sc = new Scanner(System.in);
		JoinTablesServices joinTablesServices = new JoinTablesServices();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		joinTablesServices.imprimirDestinoEPromocao();
		System.out.println("Digite o ID da promo��o que voc� deseja excluir: ");
		promocao.setIdPromocao(sc.nextInt());
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setInt(1, promocao.getIdPromocao());
			
			pstm.executeUpdate();
			
			System.out.println("Promo��o exclu�da com sucesso.");
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (pstm != null) {

					pstm.close();
				}

				
				if (conn != null) {
					
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}
	
	public void updatePromocao(Promocao promocao) {
		String sql = "UPDATE PROMOCAO set percentualDesconto = ?  WHERE idPromocao = ?";
		Scanner sc = new Scanner(System.in);
		JoinTablesServices joinTablesServices = new JoinTablesServices();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		joinTablesServices.imprimirDestinoEPromocao();
		System.out.println("Digite o ID promo��o que voc� deseja atualizar: ");
		promocao.setIdPromocao(sc.nextInt());
		
		System.out.println("ATUALIZA��O DE DADOS DA PROMO��O");
		
		System.out.println("Digite o novo percentual de desconto da promo��o: ");
		promocao.setPercentualDesconto(sc.nextDouble());
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setDouble(1, promocao.getPercentualDesconto());
			pstm.setInt(2, promocao.getIdPromocao());
			
			pstm.executeUpdate();
			
			System.out.println("Promo��o atualizada com sucesso.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				
				if (conn != null) {
					
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	
	public void menu() {
		Promocao promocao = new Promocao();
		int opcaoMenuPromocao;
		boolean repetirMenuPromocao = true;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("");
			System.out.println("MENU - CRUD PROMOCAO");
			System.out.println("");
			System.out.println("Digite uma das op��es abaixo:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar nova promo��o");
			System.out.println("2 - Atualizar dados da promo��o");
			System.out.println("3 - Excluir promo��o");
			System.out.println("4 - Mostrar promo��es");
			
			opcaoMenuPromocao = sc.nextInt();
			
			switch(opcaoMenuPromocao) {
			case 0:
				repetirMenuPromocao = false;
				System.out.println("Saindo do CRUD PROMO��O.");
				break;
			case 1:
				this.savePromocao(promocao);
				break;
			case 2:
				this.updatePromocao(promocao);
				break;
			case 3:
				this.deletePromocao(promocao);
				break;
			case 4:
				this.imprimePromocoes();
				break;
		
			default:
				System.out.println("Op��o inv�lida, digite um numero de 0 a 4.");
				break;
			}
			
		} while (repetirMenuPromocao);
	}
	
}
