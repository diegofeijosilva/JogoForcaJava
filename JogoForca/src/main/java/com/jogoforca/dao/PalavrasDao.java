package com.jogoforca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jogoforca.db.Conexao;
import com.jogoforca.db.EstruturaBanco;
import com.jogoforca.model.Palavra;

public class PalavrasDao implements IGenericDao<Palavra> {

	Conexao conexao;
	Connection conn;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static String INSERT = "INSERT INTO PALAVRA(DESCRICAO) VALUES (?)";
	private static String DELETE = "DELETE FROM PALAVRA WHERE ID = ?";
	private static String UPDATE = "UPDATE FROM DISPOSITIVO SET NOME = ? WHERE ID = ?";
	private static String SELECT_ALL = "SELECT * FROM DISPOSITIVO ORDER BY ID";
	private static String SELECT_ID = "SELECT * FROM DISPOSITIVO WHERE IMEI = ?";

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
