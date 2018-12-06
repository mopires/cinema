package br.com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cinema.model.Ingresso;

@Repository
public class IngressoDAO {
	Connection connection;
	
	@Autowired
	public IngressoDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Ingresso ingresso){
		String sql = "insert into ingressos (preco, id_ingresso_usuario, id_ingresso_filme) " +
					"values (?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setFloat(1, ingresso.getPreco());
			stmt.setLong(2, ingresso.getId_ingresso_usuario());
			stmt.setLong(3, ingresso.getId_ingresso_filme());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Ingresso> lista(){
		try{
			List<Ingresso> ingressos = new ArrayList<Ingresso>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM ingressos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Ingresso ingresso = new Ingresso();
				
				ingresso.setId(rs.getLong("id"));
				ingresso.setPreco(rs.getFloat("preco"));
				ingresso.setId_ingresso_usuario(rs.getLong("id_ingresso_usuario"));
				ingresso.setId_ingresso_filme(rs.getLong("id_ingresso_filme"));
				
				ingressos.add(ingresso);
			}
			rs.close();
			stmt.close();
			return ingressos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Ingresso ingresso){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from ingressos where id = ?");
			
			stmt.setLong(1, ingresso.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Ingresso buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from ingressos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Ingresso ingresso = new Ingresso();

					ingresso.setId(rs.getLong("id"));
					ingresso.setPreco(rs.getFloat("preco"));
					ingresso.setId_ingresso_usuario(rs.getLong("id_ingresso_usuario"));
					ingresso.setId_ingresso_filme(rs.getLong("id_ingresso_filme"));
					
					
					return ingresso;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Ingresso ingresso){
		String sql = "update ingressos set preco = ?, id_ingresso_usuario = ?,"
					+ "id_ingresso_filme = ? where id = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setFloat(1, ingresso.getPreco());
			stmt.setLong(2, ingresso.getId_ingresso_usuario());
			stmt.setLong(3, ingresso.getId_ingresso_filme());
			stmt.setLong(4, ingresso.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
