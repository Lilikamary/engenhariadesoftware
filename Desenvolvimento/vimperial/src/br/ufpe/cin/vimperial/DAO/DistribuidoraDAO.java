package br.ufpe.cin.vimperial.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class DistribuidoraDAO {
	



	public void inserir(Distribuidora distribuidora) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO distribuidora (razaosocial, responsavel, telefone, endereco)" );
			sql.append("     VALUES ( ?, ?, ?, ?) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, distribuidora.getRazaoSocial());
				pstm.setString(2, distribuidora.getResponsavel());
				pstm.setLong(3, distribuidora.getTelefone().getCodTelefone());			
				pstm.setLong(4, distribuidora.getEndereco().getCodEndereco());				
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					distribuidora.setCodDistribuidora(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Distribuidora distribuidora) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM distribuidora WHERE coddistribuidora=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,distribuidora.getCodDistribuidora());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Distribuidora> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT coddistribuidora, razaosocial, responsavel, telefone, endereco");
		sql.append(" FROM distribuidora di ");
		List<Distribuidora> distribuidoras = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Distribuidora distribuidora = new Distribuidora();
				Telefone telefone = new Telefone();
				Endereco endereco = new Endereco();
				distribuidora.setCodDistribuidora(rs.getLong("coddistribuidora"));
				distribuidora.setRazaoSocial(rs.getString("razaosocial"));
				distribuidora.setResponsavel(rs.getString("responsavel"));
				telefone.setCodTelefone(rs.getLong("telefone"));
				endereco.setCodEndereco(rs.getLong("endereco"));
				distribuidora.setEndereco(endereco);
				distribuidora.setTelefone(telefone);
				distribuidoras.add(distribuidora);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return distribuidoras;
	}

}
