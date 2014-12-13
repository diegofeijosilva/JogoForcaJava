package com.jogoforca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jogoforca.db.Conexao;
import com.jogoforca.db.EstruturaBanco;
import com.jogoforca.model.Palavra;
import com.jogoforca.util.Util;

public class PalavrasDao implements IGenericDao<Palavra> {

	private EntityManager em;

	public PalavrasDao() {
		
		EstruturaBanco ts = new EstruturaBanco();
		ts.criaEstrutura();

		Conexao conn = new Conexao();
		this.em = conn.getEntityManager();

	}

	public boolean saveOrUpdate(Palavra obj) {

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

	// Retorna a quantidade de palavras o frases no banco
	public Integer getCountRegistros() {

		Integer total = 0;

		try {

			Query q = em.createNativeQuery("SELECT COUNT(*) AS TOTAL FROM PALAVRA");

			Object obj = q.getSingleResult();
			
			if(obj != null){
				total = Integer.parseInt(obj.toString());
			}

		} catch (Exception e) {
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
		    		
		    Query q = em.createNativeQuery(" SELECT * FROM PALAVRA WHERE ID = " + (randomNum-1), Palavra.class);
			
			obj =  (Palavra) q.getSingleResult();

			
		} catch (Exception e) {
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
