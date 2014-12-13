package com.jogoforca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jogoforca.db.Conexao;
import com.jogoforca.db.EstruturaBanco;
import com.jogoforca.model.Jogador;
import com.jogoforca.model.Palavra;

public class JogadorDao implements IGenericDao<Jogador> {

	private EntityManager em;

	private static String INSERT = "INSERT INTO JOGADOR(NOME, PONTOS) VALUES (?,?)";
	private static String DELETE = "DELETE FROM JOGADOR WHERE ID = ?";
	private static String UPDATE = "UPDATE FROM JOGADOR SET NOME = ? WHERE ID = ?";
	private static String SELECT_ALL = "SELECT * FROM JOGADOR ORDER BY PONTOS DESC";
	private static String SELECT_ID = "SELECT * FROM JOGADOR WHERE ID = ?";

	public JogadorDao() {
		EstruturaBanco ts = new EstruturaBanco();
		ts.criaEstrutura();

		Conexao conn = new Conexao();
		this.em = conn.getEntityManager();
	}

	public boolean saveOrUpdate(Jogador obj) {
		// Save
		try {
			
			this.em.getTransaction().begin();
			this.em.persist(obj);
			this.em.getTransaction().commit();
			
			System.out.println("DADOS SALVOS");

			return true; // Conseguiu gravar

		} catch (Exception e) {
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
			
			Query q = em.createNativeQuery(SELECT_ALL, Jogador.class);
			
			lstJogador =  (List<Jogador>) q.getResultList();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			return lstJogador;
		}

	}

	public Jogador getById(int pkCodigo) {

		Jogador jogador = null;

		try {
/*//			conn = conexao.getConnection();

			pstmt = conn.prepareStatement(SELECT_ID);

			// Código imei de teste
			pstmt.setInt(1, pkCodigo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				jogador = new Jogador();

				jogador.setId(rs.getInt("ID"));
				jogador.setNome(rs.getString("NOME"));

			}

			pstmt.close();*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			return jogador;
		}

	}

}
