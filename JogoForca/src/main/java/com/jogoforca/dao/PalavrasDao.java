package com.jogoforca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.jogoforca.db.Conexao;
import com.jogoforca.db.EstruturaBanco;
import com.jogoforca.model.Palavra;

public class PalavrasDao implements IGenericDao<Palavra> {
	
	Conexao conn;
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static String INSERT = "INSERT INTO DISPOSITIVO(IMEI, NOME) VALUES (?,?)";
	private static String DELETE = "DELETE FROM DISPOSITIVO WHERE ID = ?";
	private static String UPDATE = "UPDATE FROM DISPOSITIVO SET NOME = ? WHERE ID = ?";
	private static String SELECT_ALL = "SELECT * FROM DISPOSITIVO ORDER BY ID";
	private static String SELECT_ID = "SELECT * FROM DISPOSITIVO WHERE IMEI = ?";
	
	public PalavrasDao() {
		EstruturaBanco ts = new EstruturaBanco();
		ts.criaEstrutura();
	}

	public boolean saveOrUpdate(Palavra objeto) {
		// TODO Auto-generated method stub
		return false;
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
