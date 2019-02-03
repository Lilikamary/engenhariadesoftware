package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.TelefoneCliente;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class TelefoneClienteDAO {
	
	public void inserir(TelefoneCliente telefoneCliente) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO telefonecliente (telefone)" );
			sql.append("     VALUES ( ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, telefoneCliente.getTelefone());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					telefoneCliente.setCodTelefoneCliente(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(TelefoneCliente telefoneCliente) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM telefonecliente WHERE codtelefonecliente=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,telefoneCliente.getCodTelefoneCliente());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<TelefoneCliente> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codtelefonecliente, telefone");
		sql.append(" FROM telefonecliente tc ");
		List<TelefoneCliente> telefoneClientes = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				TelefoneCliente telefoneCliente = new TelefoneCliente();
				telefoneCliente.setCodTelefoneCliente(rs.getLong("codtelefonecliente"));
				telefoneCliente.setTelefone(rs.getString("telefone"));
				telefoneClientes.add(telefoneCliente);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return telefoneClientes;
	}

}
