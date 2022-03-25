package br.com.recode.ag.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.recode.ag.connfactory.ConnectionFactory;
import br.com.recode.ag.model.Cliente;

public class ClienteServices {
	
	public List<Cliente> getClientes(){
		String sql = "SELECT * FROM CLIENTE";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNomeCliente(rs.getString("nomeCliente"));
				cliente.setCPF(rs.getString("CPF"));
				cliente.setTel(rs.getString("tel"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCreditCard(rs.getString("creditCard"));
				cliente.setIdDestino(rs.getInt("idDestino"));
				
				clientes.add(cliente);
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
		
		return clientes;
	}
	
	
	
	public void imprimeClientes(){
		System.out.println("__________LISTA DE CLIENTES__________");
		for (Cliente c : this.getClientes()) {
			System.out.println("ID do cliente: "+ c.getIdCliente());
			System.out.println("Nome do cliente: "+c.getNomeCliente());
			System.out.println("CPF: "+c.getCPF());
			System.out.println("Telefone: "+c.getTel());
			System.out.println("E-mail: "+c.getEmail());
			System.out.println("Cartão de crédito: "+c.getCreditCard());
			System.out.println("ID da viagem: "+c.getIdDestino());
			System.out.println("__________________________________________________");
		}
	}
	
	
	public void saveDadosCliente(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		String sql = "INSERT INTO CLIENTE (nomeCliente, CPF, tel, email, creditCard) VALUES (?, ?, ?, ?, ?)";
		
		System.out.println("Digite o nome do cliente: ");
		cliente.setNomeCliente(sc.nextLine());
		System.out.println("CPF do cliente: ");
		cliente.setCPF(sc.nextLine());
		System.out.println("Telefone do cliente: ");
		cliente.setTel(sc.nextLine());
		System.out.println("E-mail do cliente: ");
		cliente.setEmail(sc.nextLine());
		System.out.println("Cartão de crédito do cliente: ");
		cliente.setCreditCard(sc.nextLine());
		
		
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
				conn= ConnectionFactory.createConnectionToMySQL();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNomeCliente());
				pstm.setString(2, cliente.getCPF());
				pstm.setString(3, cliente.getTel());
				pstm.setString(4, cliente.getEmail());
				pstm.setString(5, cliente.getCreditCard());
				
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
	
	public void escolheDestino(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		String sql = "UPDATE CLIENTE SET idDestino = ? WHERE idCliente = ? ";
		
		DestinoServices ds =  new DestinoServices();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		this.imprimeClientes();
		System.out.println("Digite o Id do cliente que deseja escolher um destino: ");
		cliente.setIdCliente(sc.nextInt());
		
		ds.imprimeDestinos();
		System.out.println("Digite o Id do destino que o cliente deseja: ");
		cliente.setIdDestino(sc.nextInt());
		
		
		
		
		try {
			conn= ConnectionFactory.createConnectionToMySQL();
			pstm= conn.prepareStatement(sql);
			
			pstm.setInt(1, cliente.getIdDestino());
			pstm.setInt(2, cliente.getIdCliente());
			
			pstm.executeUpdate();
			
			System.out.println("Destino escolhido com sucesso!");
			
		} catch (SQLException e) {
			
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
	
	
	public void deleteCliente(Cliente cliente) {
		String sql = "DELETE FROM CLIENTE WHERE idCliente = ?";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		this.imprimeClientes();
		
		System.out.println("Digite o ID do cliente que deseja apagar do cadastro: ");
		cliente.setIdCliente(sc.nextInt());
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, cliente.getIdCliente());
			
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
	
	
	public void updateDadosCliente(Cliente cliente) {
		String sql = "UPDATE CLIENTE set nomeCliente = ?, CPF = ?, tel = ?, email = ?, creditCard = ?  WHERE idCliente = ?";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		this.imprimeClientes();
		
		System.out.println("Digite o ID do cliente que deseja atualizar os dados cadastrais: ");
		cliente.setIdCliente(sc.nextInt());
		
		System.out.println("ATUALIZANDO DADOS DO(A) CLIENTE");
		
		System.out.println("Digite o nome do cliente: ");
		sc.nextLine();
		cliente.setNomeCliente(sc.nextLine());
		System.out.println("CPF do cliente: ");
		cliente.setCPF(sc.nextLine());
		System.out.println("Telefone do cliente: ");
		cliente.setTel(sc.nextLine());
		System.out.println("E-mail do cliente: ");
		cliente.setEmail(sc.nextLine());
		System.out.println("Cartão de crédito do cliente: ");
		cliente.setCreditCard(sc.nextLine());
		
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNomeCliente());
			pstm.setString(2, cliente.getCPF());
			pstm.setString(3, cliente.getTel());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getCreditCard());
			pstm.setInt(6, cliente.getIdCliente());
			
			pstm.executeUpdate();
			
			System.out.println("Os dados de "+cliente.getNomeCliente()+" foram atualizados com sucesso.");
			
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
		
		Cliente cliente = new Cliente();
		int opcaoMenuCliente;
		boolean repetirMenuCliente = true;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("");
			System.out.println("MENU - CRUD CLIENTE");
			System.out.println("");
			System.out.println("Digite uma das opções abaixo:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar dados do cliente");
			System.out.println("2 - Escolher destino do cliente");
			System.out.println("3 - Atualizar dados do cliente");
			System.out.println("4 - Excluir cliente");
			System.out.println("5 - Mostrar clientes");
				
			opcaoMenuCliente = sc.nextInt();
			
				
			switch (opcaoMenuCliente) {
				case 0:
					repetirMenuCliente = false;
					System.out.println("Saindo do CRUD CLIENTE.");
					break;
				case 1:
					this.saveDadosCliente(cliente);
					break;
				case 2:
					this.escolheDestino(cliente);
					break;
				case 3:
					this.updateDadosCliente(cliente);
					break;
				case 4:
					this.deleteCliente(cliente);
					break;
				case 5:
					this.imprimeClientes();
					break;
			
				default:
					System.out.println("Opção inválida, digite um numero de 0 a 5.");
					break;
			}
			
		} while (repetirMenuCliente);
		
		
		
		
	}
}
