package com.jogoforca.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EstruturaBanco {
	
	private static String PALAVRA = "CREATE TABLE IF NOT EXISTS PALAVRA (ID INTEGER IDENTITY, DESCRICAO VARCHAR(250), TEMA VARCHAR(50))";
	private static String JOGADOR = "CREATE TABLE IF NOT EXISTS JOGADOR (ID INTEGER IDENTITY, NOME VARCHAR(250), PONTOS DOUBLE)";
	
	public boolean criaEstrutura(){
		
		Conexao conex = new Conexao();

		try{

		    EntityManager em = conex.getEntityManager();
 
		    em.getTransaction().begin();
		    Query q = em.createNativeQuery(PALAVRA);
		    q.executeUpdate();
		    
		    q = em.createNativeQuery(JOGADOR);
		    q.executeUpdate();
		    
		    em.getTransaction().commit();
			
		}catch (Exception sqlException) {
			System.out.println("Erro ao Criar as Tabelas no banco");
			sqlException.printStackTrace();
			return false;
		}
	
	return true;	
	}

}
