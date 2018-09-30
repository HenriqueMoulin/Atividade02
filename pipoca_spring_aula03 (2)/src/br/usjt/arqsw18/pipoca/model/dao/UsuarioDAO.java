package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	/*public int inserirUsuario(Usuario usuario) throws IOException {
		int id = -1;
		String sql = "insert into Usuario (login, senha) values (?,?)";
		
		try(
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
					
			pst.execute();
			
			String query = "select LAST_INSERT_ID()";
			try(PreparedStatement pst1 = conn.prepareStatement(query);
				ResultSet rs = pst1.executeQuery();){

				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return id;
	}*/
	
	public boolean validarUsuario(Usuario usuario){
		
		boolean validacao = false;
		
		String sql = "select u from Usuario u where u.login = :login AND u.senha = :senha";
		
		Query query = em.createQuery(sql);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		try {
			if(query.getSingleResult() != null)  {
				validacao = true;
			}					
		}catch (NoResultException nre) {
			
		}
		
		return validacao;
		
	}
}
		
		

