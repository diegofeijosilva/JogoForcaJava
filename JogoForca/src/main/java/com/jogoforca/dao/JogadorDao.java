package com.jogoforca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jogoforca.db.Conexao;
import com.jogoforca.db.EstruturaBanco;
import com.jogoforca.model.Jogador;

public class JogadorDao implements IGenericDao<Jogador> {

	Conexao conexao;
	Connection conn;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static String INSERT = "INSERT INTO JOGADOR(ID, NOME, PONTOS) VALUES (?,?,?)";
	private static String DELETE = "DELETE FROM JOGADOR WHERE ID = ?";
	private static String UPDATE = "UPDATE FROM JOGADOR SET NOME = ? WHERE ID = ?";
	private static String SELECT_ALL = "SELECT * FROM JOGADOR ORDER BY PONTOS DESC";
	private static String SELECT_ID = "SELECT * FROM JOGADOR WHERE ID = ?";
	private static String SELECT_MAX = "SELECT MAX(ID) FROM JOGADOR";

	public JogadorDao() {
		EstruturaBanco ts = new EstruturaBanco();
		ts.criaEstrutura();

		conexao = new Conexao();
	}

	public boolean saveOrUpdate(Jogador obj) {
		// Save
		try {
			conn = conexao.getConnection();

			Integer maxId = 1;
			pstmt = conn.prepareStatement(SELECT_MAX);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt("ID");
			}
			
			pstmt = conn.prepareStatement(INSERT);

			// Código imei de teste
			pstmt.setInt(1, maxId);
			pstmt.setString(2, obj.getNome());
			pstmt.setFloat(3, obj.getPontos());

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

	public List<Jogador> getAll() {

		List<Jogador> lstJogador = new ArrayList<Jogador>();

		try {
			conn = conexao.getConnection();

			pstmt = conn.prepareStatement(SELECT_ALL);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Jogador jogador = new Jogador();

				jogador.setId(rs.getInt("ID"));
				jogador.setNome(rs.getString("NOME"));
				jogador.setPontos(rs.getFloat("PONTOS"));

				lstJogador.add(jogador);
			}

			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			return lstJogador;
		}

	}

	public Jogador getById(int pkCodigo) {

		Jogador jogador = null;

		try {
			conn = conexao.getConnection();

			pstmt = conn.prepareStatement(SELECT_ID);

			// Código imei de teste
			pstmt.setInt(1, pkCodigo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				jogador = new Jogador();

				jogador.setId(rs.getInt("ID"));
				jogador.setNome(rs.getString("NOME"));

			}

			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			return jogador;
		}

	}

}
