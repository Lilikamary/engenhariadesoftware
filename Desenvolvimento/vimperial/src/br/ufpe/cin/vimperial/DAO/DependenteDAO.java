package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Dependente;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class DependenteDAO {



	public void inserir(Dependente dependente) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dependente (nome, tipodependente, email, cliente)" );
			sql.append("     VALUES ( ?, ?, ?, ?) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, dependente.getNome());
				pstm.setString(2, dependente.getTipoDependente());
				pstm.setString(3, dependente.getEmail());
				pstm.setLong(4, dependente.getCliente().getCodCliente());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					dependente.setCodDependente(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Dependente dependente) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM dependente WHERE coddependente=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,dependente.getCodDependente());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Dependente> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT coddependente, nome, tipodependente, email, cliente");
		sql.append(" FROM dependente d ");
		List<Dependente> dependentes = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Dependente dependente = new Dependente();
				Cliente cliente = new Cliente();
				dependente.setCodDependente(rs.getLong("coddependente"));
				dependente.setNome(rs.getString("nome"));
				dependente.setTipoDependente(rs.getString("tipodependente"));
				dependente.setEmail(rs.getString("email"));
				cliente.setCodCliente(rs.getLong("cliente"));
				dependente.setCliente(cliente);
				dependentes.add(dependente);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dependentes;
	}

}
