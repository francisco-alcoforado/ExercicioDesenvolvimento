package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import br.aeso.exercicio.cliente.Cliente;
import br.aeso.exercicio.cliente.ClienteNaoExncontradoException;
import br.aeso.exercicio.cliente.ControladorCliente;
import br.aeso.exercicio.cliente.EmailCliente;
import br.aeso.exercicio.cliente.TelefoneCliente;
import br.aeso.exercicio.database.BancoDeDados;
import br.aeso.exercicio.vendedor.ControladorVendedor;
import br.aeso.exercicio.vendedor.Vendedor;
import br.aeso.exercicio.vendedor.VendedorNaoEncontradoException;

public class ConnectarDBPedido {
private BancoDeDados banco;
	
	public ConnectarDBPedido() throws SQLException {
		this.banco = BancoDeDados.getBancoDeDados("jdbc:mysql://servidor/BancoProjeto", "root", "");
		
	}

	public ArrayList<Pedido> listar() throws SQLException{
		String sql = "SELECT * FROM Pedido";
		ResultSet rst = this.banco.listar(sql);
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		while(rst.next()){
			Cliente cliente = getCliente(rst.getInt("Codigo_Cliente");
			Vendedor vendedor = getVendedor(rst.getInt("Codigo_Vendedor");
			Pedido pedido = new Pedido(rst.getInt("Codigo"), cliente, vendedor, rst.getDouble("Valor"), rst.getDate("Data_Pedido"));
			lista.add(pedido);
		}
		return lista;
	}
	private Cliente getCliente(int codigo) throws SQLException, ClienteNaoExncontradoException, ClassNotFoundException, IOException{
		ControladorCliente controle = new ControladorCliente();
		return controle.procurar(codigo);
	}
	private Vendedor getVendedor(int codigo) throws SQLException, ClassNotFoundException, IOException, VendedorNaoEncontradoException{
		ControladorVendedor controle = new ControladorVendedor();
		return controle.procurar(codigo);
	}
	public void cadastrar(Pedido pedido) throws SQLException{
		String sql = "INSERT INTO Pedido (Nome, Codigo_Cliente, Codigo_Vendedor, Valor, Data_Pedido) VALUE (" + pedido.getCliente().getCodigo() + ", "+ pedido.getVendedor().getCodigo() +", " + pedido.getValor() + ", '" + pedido.getData_pedido().toString() + "')";
		this.banco.cadastrar(sql);
	}
	public void atualizar(Cliente cliente) throws SQLException{
		String sql = "UPDATE Pedido SET Nome = '" + cliente.getNome() + "', CPF = '" + cliente.getCpf() + "', Rua = '" + 
	cliente.getRua() + "', Bairro = '" + cliente.getBairro() + "', Cidade = '" + cliente.getCidade() + "', CEP = '"+ cliente.getCEP()
	+"', Numero = " + cliente.getNumero() + ", Complemento = '" + cliente.getComplemento() + "' WHERE Codigo = " + cliente.getCodigo();
		this.banco.atualizar(sql);
		for(EmailCliente email : cliente.getEmails()){
			String sqlEmail = "UPDATE Email_Cliente SET email = '" + email.getEmail() + "', " + email.getPrimario() + ", WHERE Codigo = " + email.getCodigo();
			this.banco.atualizar(sqlEmail);
		}
		for(TelefoneCliente telefone : cliente.getTelefones()){
			String sqlTelefone = "UPDATE Telefone_Cliente SET Telefone = '" + telefone.getTelefone() + "' WHERE Codigo = " + telefone.getCodigo();
			this.banco.atualizar(sqlTelefone);
		}
	}
	public void remover(Cliente cliente) throws SQLException{
		String sql = "DELETE FROM Cliente WHERE Codigo = " + cliente.getCodigo();
		String sqlEmail = "DELETE FROM Email_Cliente WHERE Codigo_Cliente = " + cliente.getCodigo();
		String sqlTelefone = "DELETE FROM Telefone_Cliente WHERE Codigo_Cliente = " + cliente.getCodigo();
		this.banco.remove(sqlEmail);
		this.banco.remove(sqlTelefone);
		this.banco.remove(sql);
	}
	public ArrayList<Cliente> procurar(Map<String, Object> valores) throws SQLException{
		String sql = "SELECT * FROM Cliente WHERE ";
		int i = 0;
		for(String key : valores.keySet()){
			if(i == 0){
				if(valores.get(key) instanceof Integer){
					sql += key + " = " + valores.get(key);
				}else if (valores.get(key) instanceof String){
					sql += key + " = '" + valores.get(key) + "'";
				}
			}else{
				if(valores.get(key) instanceof Integer){
					sql += ", " + key + " = " + valores.get(key);
				}else if(valores.get(key) instanceof String){
					sql += ", " + key + " = '" + valores.get(key) + "'";
				}
			}
			i++;
		}
		ResultSet rst = this.banco.listar(sql);
		ArrayList<Cliente> lista = new ArrayList<Cliente>(); 
		while(rst.next()){
			ArrayList<EmailCliente> emails = this.getEmails(rst.getInt("Codigo"));
			ArrayList<TelefoneCliente> telefones = this.getTelefones(rst.getInt("Codigo"));
			Cliente cliente = new Cliente(rst.getInt("Codigo"), rst.getString("Nome"), rst.getString("CPF"), rst.getString("Rua"), rst.getString("Bairro"), rst.getString("Cidade"), rst.getString("CEP"), rst.getInt("Numero"), rst.getString("Complemeto"), telefones, emails);
			lista.add(cliente);
		}
		return lista;
	}
}
