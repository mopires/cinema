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

import br.com.cinema.model.Filme;

@Repository
public class FilmeDAO {
	Connection connection;
	
	@Autowired
	public FilmeDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Filme filme){
		String sql = "insert into filmes (nome) " +
					"values (?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, filme.getNome());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Filme> lista(){
		try{
			List<Filme> filmes = new ArrayList<Filme>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM filmes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Filme filme = new Filme();
				
				filme.setId(rs.getLong("id"));
				filme.setNome(rs.getString("nome"));
				
				filmes.add(filme);
			}
			rs.close();
			stmt.close();
			return filmes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Filme filme){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from filmes where id = ?");
			
			stmt.setLong(1, filme.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Filme buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from filmes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Filme filme = new Filme();

					filme.setId(rs.getLong("id"));
					filme.setNome(rs.getString("nome"));
					
					return filme;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Filme filme){
		String sql = "update filmes set nome=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, filme.getNome());
			stmt.setLong(2, filme.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
