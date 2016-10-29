package br.aeso.exercicio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BancoDeDados {
	public static BancoDeDados Instance;
	private Connection conn;
	private String[] javaClasses = new String[]{"Cliente", "Fornecedor", "Venda", "Vendedor", "Pedido", "Produto", "NotaFiscal"};
	private BancoDeDados(String connection, String user, String pass) throws SQLException{
		this.conn = DriverManager.getConnection(connection, user, pass);
	}
	
	public static BancoDeDados getBancoDeDados(String connection, String user, String pass) throws SQLException{
		if(BancoDeDados.Instance == null){
			BancoDeDados.Instance = new BancoDeDados(connection, user, pass);
		}
		return BancoDeDados.Instance;
	}
	public ResultSet listar(String sql) throws SQLException{
		Statement stmt = null;
		try{
			stmt = this.conn.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			return rst;
		}catch(Exception e){
			throw new SQLException();
		}
	}
	public void cadastrar(String sql) throws SQLException{
		try{
		  Statement stmt = this.conn.createStatement();
		  stmt.executeUpdate(sql);
		}catch(Exception e){
			throw new SQLException();
		}
	}
	public void atualizar(String sql) throws SQLException{
		try{
		  Statement stmt = this.conn.createStatement();
		  stmt.executeUpdate(sql);
		}catch(Exception e){
			throw new SQLException();
		}
	}
	public void remove(String sql) throws SQLException{
		try{
		  Statement stmt = this.conn.createStatement();
		  stmt.executeUpdate(sql);
		}catch(Exception e){
			throw new SQLException();
		}
	}
}
