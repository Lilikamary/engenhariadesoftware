package br.ufpe.cin.vimperial.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class EnderecoDAO{
	


	public void inserir(Endereco endereco) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO endereco (logradouro, numero, bairro, cidade, cep)" );
			sql.append("     VALUES ( ?, ?, ?, ?, ?) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, endereco.getLogradouro());
				pstm.setString(2, endereco.getNumero());
				pstm.setString(3, endereco.getBairro());
				pstm.setString(4, endereco.getCidade());
				pstm.setString(5, endereco.getCep());

				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					endereco.setCodEndereco(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Endereco endereco) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM endereco WHERE codendereco=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,endereco.getCodEndereco());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Endereco> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codendereco, logradouro, numero, bairro, cidade, cep");
		sql.append(" FROM endereco d ");
		List<Endereco> enderecos = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setCodEndereco(rs.getLong("codendereco"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCep(rs.getString("cep"));
				enderecos.add(endereco);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return enderecos;
	}

}
