package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class TelefoneDAO {
	
	public void inserir(Telefone telefone) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO telefone (telefone)" );
			sql.append("     VALUES ( ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, telefone.getTelefone());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					telefone.setCodTelefone(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Telefone telefone) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM telefone WHERE codtelefone=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,telefone.getCodTelefone());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Telefone> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codtelefone, telefone");
		sql.append(" FROM telefone tc ");
		List<Telefone> telefones = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Telefone telefone = new Telefone();
				telefone.setCodTelefone(rs.getLong("codtelefone"));
				telefone.setTelefone(rs.getString("telefone"));
				telefones.add(telefone);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return telefones;
	}

}
