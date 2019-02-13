package br.ufpe.cin.vimperial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Distribuidora;
import br.ufpe.cin.vimperial.entidades.Filme;
import br.ufpe.cin.vimperial.entidades.Locacao;
import br.ufpe.cin.vimperial.entidades.LocacaoItem;
import br.ufpe.cin.vimperial.entidades.TipoMidia;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class LocacaoItemDAO{
	

	public void inserir(LocacaoItem locacaoItem) {
		
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO locacaoitem(locacao, filme, valorlocacao, valormulta, valortotal) ");
			sql.append("     VALUES ( ?, ?, ?, ?, ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setLong(1, locacaoItem.getLocacao().getCodLocacao());
				pstm.setLong(2, locacaoItem.getFilme().getCodFilme());
				pstm.setFloat(3, locacaoItem.getValorLocacao());
				pstm.setFloat(4, locacaoItem.getValorMulta());
				pstm.setFloat(5, locacaoItem.getValorTotal());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					locacaoItem.setCodLocacaoItem(rs.getLong(1)); // primeira coluna
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(LocacaoItem locacaoItem) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM locacaoitem WHERE codlocacaoitem=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,locacaoItem.getCodLocacaoItem());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<LocacaoItem> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT li.codlocacaoitem, l.codlocacao, f.codfilme, f.titulooriginal, li.valorlocacao, li.valormulta, li.valortotal ");
		sql.append(" FROM locacaoitem li ");
		sql.append(" INNER JOIN locacao l on l.codlocacao = li.locacao ");
		sql.append(" INNER JOIN filme f on f.codfilme = li.filme ");
		List<LocacaoItem> locacaoitens = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				LocacaoItem locacaoItem = new LocacaoItem();
				Locacao locacao = new Locacao();
				Filme filme = new Filme();
				locacaoItem.setCodLocacaoItem(rs.getLong("li.codlocacaoitem"));
				locacao.setCodLocacao(rs.getLong("l.codlocacao"));
				locacaoItem.setLocacao(locacao);
				filme.setCodFilme(rs.getLong("f.codfilme"));
				filme.setTituloOriginal(rs.getString("f.titulooriginal"));
				locacaoItem.setFilme(filme);
				locacaoItem.setValorLocacao(rs.getFloat("li.valorlocacao"));
				locacaoItem.setValorMulta(rs.getFloat("li.valormulta"));
				locacaoItem.setValorTotal(rs.getFloat("li.valortotal"));
				locacaoitens.add(locacaoItem);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return locacaoitens;
	}

}
