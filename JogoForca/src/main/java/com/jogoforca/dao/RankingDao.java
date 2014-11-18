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
import com.jogoforca.model.Ranking;

public class RankingDao implements IGenericDao<Ranking> {

	Conexao conexao;
	Connection conn;

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static String INSERT = "INSERT INTO RANKING(IDJOGADOR, PONTOS) VALUES (?,?)";
	private static String DELETE = "DELETE FROM RANKING WHERE ID = ?";
	private static String UPDATE = "UPDATE FROM RANKING SET NOME = ? WHERE ID = ?";
	private static String SELECT_ALL = "SELECT * FROM RANKING ORDER BY ID";
	private static String SELECT_ID = "SELECT * FROM RANKING WHERE ID = ?";

	public RankingDao() {

		EstruturaBanco ts = new EstruturaBanco();
		ts.criaEstrutura();

		conexao = new Conexao();
	}

	public boolean saveOrUpdate(Ranking obj) {
		
		// Save
		try {
			conn = conexao.getConnection();

			pstmt = conn.prepareStatement(INSERT);

			// Código imei de teste
			pstmt.setInt(1, obj.getJogador().getId());
			pstmt.setFloat(2, obj.getPontos());

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

	public List<Ranking> getAll() {
		
		List<Ranking> lstRanking = new ArrayList<Ranking>();
		JogadorDao daoJogador = new JogadorDao();

		try {
			conn = conexao.getConnection();

			pstmt = conn.prepareStatement(SELECT_ALL);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Ranking ranking = new Ranking();

				ranking.setId(rs.getInt("ID"));
				ranking.setJogador(daoJogador.getById(rs.getInt("IDJOGADOR"))); 
				ranking.setPontos(rs.getFloat("PONTOS"));
				

				lstRanking.add(ranking);
			}

			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			return lstRanking;
		}
	}

	public Ranking getById(int pkCodigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
