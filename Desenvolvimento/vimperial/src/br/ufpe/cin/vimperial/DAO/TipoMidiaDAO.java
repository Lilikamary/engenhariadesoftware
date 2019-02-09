package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.TipoMidia;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class TipoMidiaDAO{
	

	public void inserir(TipoMidia tipoMidia) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO tipomidia (tipomidia)" );
			sql.append("     VALUES ( ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, tipoMidia.getTipoMidia());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					tipoMidia.setCodMidia(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(TipoMidia tipoMidia) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tipomidia WHERE codmidia=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,tipoMidia.getCodMidia());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<TipoMidia> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codmidia, tipomidia");
		sql.append(" FROM tipomidia tm ");
		List<TipoMidia> tipoMidias = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				TipoMidia tipoMidia = new TipoMidia();
				tipoMidia.setCodMidia(rs.getLong("codmidia"));
				tipoMidia.setTipoMidia(rs.getString("tipomidia"));
				tipoMidias.add(tipoMidia);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tipoMidias;
	}

}
