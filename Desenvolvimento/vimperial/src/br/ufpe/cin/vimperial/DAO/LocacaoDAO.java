package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Locacao;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class LocacaoDAO{
	

	public void inserir(Locacao locacao) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO locacao(cliente, datalocacao, datadevolucao, multa) ");
			sql.append("     VALUES ( ?, ?, ?, ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setLong(1, locacao.getCliente().getCodCliente());
				pstm.setTimestamp(2, new Timestamp(locacao.getDataLocacao().getTime()));
				pstm.setTimestamp(3, new Timestamp(locacao.getDataDevolucao().getTime()));
				pstm.setLong(4, locacao.getMulta());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					locacao.setCodLocacao(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Locacao locacao) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM locacao WHERE codLocacao=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,locacao.getCodLocacao());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Locacao> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT l.codlocacao, c.codcliente, c.nome, l.datalocacao, l.datadevolucao, l.multa ");
		sql.append(" FROM locacao l ");
		sql.append(" INNER JOIN cliente c on c.codcliente = l.cliente ");
		List<Locacao> locacoes = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Locacao locacao = new Locacao();
				Cliente cliente = new Cliente();
				locacao.setCodLocacao(rs.getLong("l.codlocacao"));
				cliente.setCodCliente(rs.getLong("c.codcliente"));
				cliente.setNome(rs.getString("c.nome"));
				locacao.setCliente(cliente);
				locacao.setDataLocacao(rs.getDate("l.datalocacao"));
				locacao.setDataDevolucaoBanco(rs.getDate("l.datadevolucao"));
				locacao.setMulta(rs.getLong("l.multa"));
				locacoes.add(locacao);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return locacoes;
	}

}
