package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class FilmeDAO {
	
	public void inserir(Filme filme) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO filme(tituloOriginal,tituloPortugues, direcao, genero, paisProducao, ano, duracao, sinopse) ");
			sql.append("     VALUES ( ?, ?, ?, ?,?, ?, ?,? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, filme.getTituloOriginal());
				pstm.setString(2, filme.getTituloPortugues());
				pstm.setString(3, filme.getDirecao());
				pstm.setString(4, filme.getGenero());
				pstm.setString(5, filme.getPaisProducao());
				pstm.setString(6, filme.getAno());
				pstm.setString(7, filme.getDuracao());
				pstm.setString(8, filme.getSinopse());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					filme.setCodFilme(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Filme filme) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM filme WHERE codFilme=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,filme.getCodFilme());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Filme> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codfilme, titulooriginal, tituloportugues, genero, direcao, ano, duracao, paisproducao,sinopse");
		sql.append(" FROM filme f ");
		List<Filme> filmes = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Filme filme = new Filme();
				filme.setCodFilme(rs.getLong("codFilme"));
				filme.setTituloOriginal(rs.getString("tituloOriginal"));
				filme.setTituloPortugues(rs.getString("tituloPortugues"));
				filme.setGenero(rs.getString("genero"));
				filme.setDirecao(rs.getString("direcao"));
				filme.setAno(rs.getString("ano"));
				filme.setDuracao(rs.getString("duracao"));
				filme.setPaisProducao(rs.getString("paisProducao"));
				filme.setSinopse(rs.getString("sinopse"));
				filmes.add(filme);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return filmes;
	}

}
