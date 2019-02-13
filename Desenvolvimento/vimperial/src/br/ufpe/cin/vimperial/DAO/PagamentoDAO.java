package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Locacao;
import br.ufpe.cin.vimperial.entidades.Pagamento;
import br.ufpe.cin.vimperial.entidades.TipoPagamento;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class PagamentoDAO{
	

	public void inserir(Pagamento pagamento) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO pagamento(locacao, valortotal, tipopagamento, valorrecebido, troco) ");
			sql.append("     VALUES ( ?, ?, ?, ?, ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setLong(1, pagamento.getLocacao().getCodLocacao());
				pstm.setFloat(2, pagamento.getValorTotal());
				pstm.setLong(3, pagamento.getTipoPagamento().getCodTipoPagamento());
				pstm.setFloat(4, pagamento.getValorRecebido());
				pstm.setFloat(5, pagamento.getTroco());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					pagamento.setCodPagamento(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Pagamento pagamento) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM pagamento WHERE codpagamento=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,pagamento.getCodPagamento());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Pagamento> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.codpagamento, p.locacao, p.valortotal, tp.codtipopagamento, tp.tipopagamento, p.valorrecebido, p.troco");
		sql.append(" FROM pagamento p ");
		sql.append(" INNER JOIN tipopagamento tp on tp.codtipopagamento = p.tipopagamento ");
		List<Pagamento> pagamentos = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Pagamento pagamento = new Pagamento();
				Locacao locacao = new Locacao();
				TipoPagamento tipoPagamento = new TipoPagamento();
				pagamento.setCodPagamento(rs.getLong("p.codpagamento"));
				locacao.setCodLocacao(rs.getLong("p.locacao"));
				pagamento.setLocacao(locacao);
				pagamento.setValorTotal(rs.getFloat("p.valortotal"));
				tipoPagamento.setCodTipoPagamento(rs.getLong("tp.codtipopagamento"));
				tipoPagamento.setTipoPagamento(rs.getString("tp.tipopagamento"));
				pagamento.setTipoPagamento(tipoPagamento);
				pagamento.setValorRecebido(rs.getFloat("p.valorrecebido"));
				pagamento.setTroco(rs.getFloat("p.troco"));
				pagamentos.add(pagamento);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pagamentos;
	}

}
