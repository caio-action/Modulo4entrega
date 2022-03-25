package br.com.recode.ag.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.recode.ag.connfactory.ConnectionFactory;
import br.com.recode.ag.model.Destino;

public class DestinoServices {
	public List<Destino> getDestinos(){
		
		String sql = "SELECT * FROM DESTINO";
		List<Destino> destinos = new ArrayList<Destino>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = ConnectionFactory.createConnectionToMySQL();
		
		try {
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			
			
			while(rs.next()) {
				Destino destino = new Destino();
				
				destino.setIdDestino(rs.getInt("idDestino"));
				destino.setNomeDestino(rs.getString("nomeDestino"));
				destino.setLocalPartida(rs.getString("localPartida"));
				destino.setHorasDeViagem(rs.getInt("horasDeViagem"));
				destino.selectDataViagem(rs.getDate("dataViagem"));
				destino.setPreco(rs.getDouble("preco"));
				
				destinos.add(destino);
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
		
		return destinos;
	}
	
	public void imprimeDestinos(){
		System.out.println("__________LISTA DE DESTINOS__________");
		for (Destino d : this.getDestinos()) {
			System.out.println("ID do Destino: "+ d.getIdDestino());
			System.out.println("Nome do Destino: "+d.getNomeDestino());
			System.out.println("Local de embarque: "+d.getLocalPartida());
			System.out.println("Horas de viagem: "+d.getHorasDeViagem());
			System.out.println("Data da viagem: "+d.getDataViagem());
			System.out.println("Preço da passagem: R$ "+d.getPreco());
			System.out.println("__________________________________________________");
		}
	}
	
	
	public void saveDestino(Destino destino) {
		Scanner sc = new Scanner(System.in);
		String sql = "INSERT INTO DESTINO (nomeDestino, localPartida, horasDeViagem, dataViagem, preco) VALUES (?, ?, ?, ?, ?)";
		Date data = null;
		
		System.out.println("Digite o nome do destino: ");
		destino.setNomeDestino(sc.nextLine());
		System.out.println("Digite o local de embarque: ");
		destino.setLocalPartida(sc.nextLine());
		System.out.println("Digite o tempo estimado da viagem em horas: ");
		destino.setHorasDeViagem(sc.nextInt());
		System.out.print("Digite o preço da passagem: R$  ");
		destino.setPreco(sc.nextDouble());
		destino.setDataViagem(data);
		System.out.println(" ");
		
		
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			conn= ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNomeDestino());
			pstm.setString(2, destino.getLocalPartida());
			pstm.setInt(3, destino.getHorasDeViagem());
			pstm.setDate(4, new Date(destino.getDataViagem().getTime()));
			pstm.setDouble(5, destino.getPreco());
			
			pstm.executeUpdate();
			
			System.out.println("Dados cadastrados com sucesso.");
			
		} catch (Exception e) {
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

	public void deleteDestino(Destino destino) {
		String sql = "DELETE FROM DESTINO WHERE idDestino = ?";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		this.imprimeDestinos();
		
		System.out.println("Digite o ID do destino que deseja apagar do cadastro: ");
		destino.setIdDestino(sc.nextInt());
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, destino.getIdDestino());
			
			pstm.executeUpdate();
			
			System.out.println("Removido com sucesso.");
			
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

	public void updateDestino(Destino destino) {
		String sql = "UPDATE DESTINO set nomeDestino = ?, localPartida = ?, horasDeViagem = ?, dataViagem = ?, preco = ?  WHERE idDestino = ?";
		Scanner sc = new Scanner(System.in);
		Date data = null;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		this.imprimeDestinos();
		
		System.out.println("Digite o ID do destino que você deseja atualizar os dados cadastrais: ");
		destino.setIdDestino(sc.nextInt());

		System.out.println("ATUALIZANDO DADOS DO DESTINO");
		
		System.out.println("Digite o nome do destino: ");
		sc.nextLine();
		destino.setNomeDestino(sc.nextLine());
		System.out.println("Digite o local de embarque: ");
		destino.setLocalPartida(sc.nextLine());
		System.out.println("Digite o tempo estimado da viagem em horas: ");
		destino.setHorasDeViagem(sc.nextInt());
		System.out.print("Digite o preço da passagem: R$  ");
		destino.setPreco(sc.nextDouble());
		destino.setDataViagem(data);
		System.out.println(" ");
		
		try {
			conn= ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNomeDestino());
			pstm.setString(2, destino.getLocalPartida());
			pstm.setInt(3, destino.getHorasDeViagem());
			pstm.setDate(4, new Date(destino.getDataViagem().getTime()));
			pstm.setDouble(5, destino.getPreco());
			pstm.setInt(6, destino.getIdDestino());
			
			pstm.executeUpdate();
			
			System.out.println("Os dados de "+destino.getNomeDestino()+" foram atualizados com sucesso.");
			
			}catch (Exception e) {
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
		
		Destino destino = new Destino();
		int opcaoMenuDestino;
		boolean repetirMenuDestino = true;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("");
			System.out.println("MENU - CRUD DESTINO");
			System.out.println("");
			System.out.println("Digite uma das opções abaixo:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar dados do destino");
			System.out.println("2 - Atualizar dados do destino");
			System.out.println("3 - Excluir destino");
			System.out.println("4 - Mostrar destinos");
				
			opcaoMenuDestino = sc.nextInt();
			
				
			switch (opcaoMenuDestino) {
				case 0:
					repetirMenuDestino = false;
					System.out.println("Saindo do CRUD DESTINO.");
					break;
				case 1:
					this.saveDestino(destino);
					break;
				case 2:
					this.updateDestino(destino);
					break;
				case 3:
					this.deleteDestino(destino);
					break;
				case 4:
					this.imprimeDestinos();
					break;
			
				default:
					System.out.println("Opção inválida, digite um numero de 0 a 4.");
					break;
			}
			
		} while (repetirMenuDestino);
	}
	
}
