package com.jogoforca.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EstruturaBanco {
	
	Connection conn = null; // Gerencia a conexao
	Statement statement = null; // instrucao SQL
	
	private static String PALAVRA = "CREATE TABLE IF NOT EXISTS PALAVRA (ID INTEGER IDENTITY, DESCRICAO VARCHAR(250))";
	private static String JOGADOR = "CREATE TABLE IF NOT EXISTS JOGADOR (ID INTEGER IDENTITY, NOME VARCHAR(250))";
	private static String RANKING = "CREATE TABLE IF NOT EXISTS RANKING (ID INTEGER IDENTITY, IDJOGADOR INTEGER,  NOME VARCHAR(250))";
	
	public boolean criaEstrutura(){
		
		//Deleta Estrutura caso esteja em memória
		//dropEstrutura();
		
		Conexao conex = new Conexao();

		try{
			conn = conex.getConnection();
			statement = conn.createStatement();

			statement.executeUpdate(PALAVRA);
			statement.executeUpdate(JOGADOR);
			statement.executeUpdate(RANKING);
			//statement.executeUpdate("CREATE TABLE Projeto ( id INTEGER IDENTITY, idTipoProjeto INTEGER, descricao VARCHAR(256), dtInicio date, dtFim date, statusProjeto BOOLEAN, nivelDificuldade CHAR)");
			
			statement.close();
			
		}catch (SQLException sqlException) {
			System.out.println("Erro ao Criar as Tabelas no banco");
			sqlException.printStackTrace();
			return false;
		}
	
	return true;	
	}


}
