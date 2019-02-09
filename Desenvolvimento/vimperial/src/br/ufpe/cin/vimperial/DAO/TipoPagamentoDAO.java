package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.TipoPagamento;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class TipoPagamentoDAO{
	

	public void inserir(TipoPagamento tipoPagamento) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO tipopagamento (tipopagamento)" );
			sql.append("     VALUES ( ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, tipoPagamento.getTipoPagamento());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					tipoPagamento.setCodTipoPagamento(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(TipoPagamento tipoPagamento) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tipopagamento WHERE codtipopagamento=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,tipoPagamento.getCodTipoPagamento());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<TipoPagamento> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codtipopagamento, tipopagamento");
		sql.append(" FROM tipopagamento tp ");
		List<TipoPagamento> tipoPagamentos = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				TipoPagamento tipoPagamento = new TipoPagamento();
				tipoPagamento.setCodTipoPagamento(rs.getLong("codtipopagamento"));
				tipoPagamento.setTipoPagamento(rs.getString("tipopagamento"));
				tipoPagamentos.add(tipoPagamento);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tipoPagamentos;
	}

}
