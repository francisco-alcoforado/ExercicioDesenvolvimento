package br.aeso.exercicio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BancoDeDados {
	public static BancoDeDados Instance;
	private Connection conn;
	private String[] javaClasses = new String[]{"Cliente", "Fornecedor", "Venda", "Vendedor", "Pedido", "Produto", "NotaFiscal"};
	private BancoDeDados(String connection, String user, String pass) throws SQLException{
		this.conn = DriverManager.getConnection(connection, user, pass);
	}
	
	public BancoDeDados getBancoDeDados(String connection, String user, String pass) throws SQLException{
		if(BancoDeDados.Instance == null){
			BancoDeDados.Instance = new BancoDeDados(connection, user, pass);
		}
		return BancoDeDados.Instance;
	}
	public ArrayList<Object> listar(String table) throws SQLException{
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM ?");
		stmt.setString(1, table);
		ResultSet rst = stmt.executeQuery();
		ArrayList<Object> lista = new ArrayList<Object>();
		while(rst.next()){
			lista = this setarObject();
		}
	}
	private Object setarObject(String table){
		
	}
	
}
