package br.ufpe.cin.vimperial.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.cin.vimperial.entidades.Cliente;
import br.ufpe.cin.vimperial.entidades.Endereco;
import br.ufpe.cin.vimperial.entidades.Telefone;
import br.ufpe.cin.vimperial.util.JPAUtil;

public class ClienteDAO {
	


	public void inserir(Cliente cliente) {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO cliente(nome, cpf, datanascimento, sexo, email, localtrabalho, telefone, endereco, ativo) ");
			sql.append("     VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
			// try-with-resources - a partir do java 7
			try (Connection con = new JPAUtil().obterConexao();
					PreparedStatement pstm = con.prepareStatement(sql.toString(),
							Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getCpf());
				pstm.setString(3, cliente.getDataNascimento());
				pstm.setString(4, cliente.getSexo());
				pstm.setString(5, cliente.getEmail());
				pstm.setString(6, cliente.getLocalTrabalho());
				pstm.setLong(7, cliente.getTelefone().getCodTelefone());
				pstm.setLong(8, cliente.getEndereco().getCodEndereco());
				pstm.setString(9, cliente.getAtivo());
				pstm.execute();
				ResultSet rs = pstm.getGeneratedKeys(); // retorna o ID gerado
				if (rs.next()) { // verifico se o banco retornou
					cliente.setCodCliente(rs.getLong(1)); // primeira coluna
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	public void excluir(Cliente cliente) {

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM cliente WHERE codcliente=? ");
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			pstm.setLong(1,cliente.getCodCliente());
			pstm.executeUpdate();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
    }
	

		public List<Cliente> listarTodos(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT codcliente, nome, cpf, datanascimento, email, localtrabalho, sexo, telefone, endereco, ativo");
		sql.append(" FROM cliente c ");
		List<Cliente> clientes = new ArrayList<>();
		try (Connection con = new JPAUtil().obterConexao();
				PreparedStatement pstm = con.prepareStatement(sql.toString())) {
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				Telefone telefone = new Telefone();
				cliente.setCodCliente(rs.getLong("codcliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getString("datanascimento"));
				cliente.setEmail(rs.getString("email"));
				cliente.setLocalTrabalho(rs.getString("localtrabalho"));
				cliente.setSexo(rs.getString("sexo"));
				endereco.setCodEndereco(rs.getLong("endereco"));
				telefone.setCodTelefone(rs.getLong("telefone"));
				cliente.setEndereco(endereco);
				cliente.setTelefone(telefone);
				cliente.setAtivo(rs.getString("ativo"));
				clientes.add(cliente);
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}

}
