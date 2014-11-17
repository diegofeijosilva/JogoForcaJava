package com.jogoforca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.jogoforca.db.Conexao;
import com.jogoforca.db.EstruturaBanco;
import com.jogoforca.model.Palavra;
import com.jogoforca.util.Util;

public class PalavrasDao implements IGenericDao<Palavra> {

	Conexao conexao;
	Connection conn;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static String INSERT = "INSERT INTO PALAVRA(DESCRICAO) VALUES (?)";
	private static String DELETE = "DELETE FROM PALAVRA WHERE ID = ?";
	private static String UPDATE = "UPDATE FROM DISPOSITIVO SET NOME = ? WHERE ID = ?";
	private static String SELECT_ALL = "SELECT * FROM DISPOSITIVO ORDER BY ID";
	private static String SELECT_ID = "SELECT * FROM PALAVRA WHERE ID = ?";

	public PalavrasDao() {
		EstruturaBanco ts = new EstruturaBanco();
		ts.criaEstrutura();

		conexao = new Conexao();

	}

	public boolean saveOrUpdate(Palavra obj) {

		// Save
		try {
			conn = conexao.getConnection();

			pstmt = conn.prepareStatement(INSERT);

			// Código imei de teste
			pstmt.setString(1, obj.getDescricao());

			pstmt.execute();
			pstmt.close();

			System.out.println("DADOS SALVOS");

			return true; // Conseguiu gravar

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}

	}

	// Retorna a quantidade de palavras o frases no banco
	public Integer getCountRegistros() {

		Integer total = 0;

		try {
			conn = conexao.getConnection();

			pstmt = conn.prepareStatement("SELECT COUNT(*) AS TOTAL FROM PALAVRA");

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt("TOTAL");
			}

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return total;
		}

	}

	public Palavra getPalavraRandomico() {

		Palavra obj=null;

		try {
			
			Integer totalPalavras = this.getCountRegistros();

			// Retorna um valor randômico
		    int randomNum = Util.randInt(1, totalPalavras);
		    
		    System.out.println("PALAVARA A SER PESQUISADA: " + randomNum);
	  
		    ResultSet rs;
		    while(true){
	    	   conn = conexao.getConnection();

				pstmt = conn.prepareStatement(SELECT_ID);

				// Código imei de teste
				pstmt.setInt(1, randomNum);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					obj = new Palavra();
					obj.setId(rs.getInt("ID"));
					obj.setDescricao(rs.getString("DESCRICAO"));
					
					System.out.println("PALAVRA SELECIONADA: " + obj.getDescricao());
					
					pstmt.execute();
					pstmt.close();
					break;	
				}
				
				// Se não achou procura outro
				randomNum = Util.randInt(1, totalPalavras);
	       }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			return obj;
		}

	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Palavra> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Palavra getById(int pkCodigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
