package br.aeso.exercicio.interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;




import br.aeso.exercicio.cliente.Cliente;
import br.aeso.exercicio.cliente.ClienteJaCadastradoException;
import br.aeso.exercicio.cliente.ClienteNaoExncontradoException;
import br.aeso.exercicio.fachada.Fachada;
import br.aeso.exercicio.fornecedor.Fornecedor;
import br.aeso.exercicio.notaFiscal.NotaFiscal;
import br.aeso.exercicio.notaFiscal.NotaFiscalJaCadastradaException;
import br.aeso.exercicio.notaFiscal.NotaFiscalNaoEncontradaException;
import br.aeso.exercicio.pedido.Pedido;
import br.aeso.exercicio.pedido.PedidoJaCadastradoException;
import br.aeso.exercicio.pedido.PedidoNaoEncontradoException;
import br.aeso.exercicio.produto.Produto;
import br.aeso.exercicio.produto.ProdutoJaCadastradoException;
import br.aeso.exercicio.produto.ProdutoNaoEncontradoException;
import br.aeso.exercicio.util.CPFInvalidoException;

public class Interface extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container formProduto;
	private Container formCliente;
	private Container formPedido;
	private Container formFornecedor;
	private Container listarProdutos;
	
	public Interface() throws HeadlessException, ClassNotFoundException, IOException {
		super("Loja em Desenvolvimento!!!");
		Container content = this.getContentPane();
		content.setLayout(new BorderLayout());
		
		content.add(BorderLayout.NORTH, this.createMenuBar());
		
		this.createFormCliente();
		this.createFormPedido();
		this.createFormProduto();
		this.createFormFornecedor();
		this.listarProdutos();
		this.formProduto.setVisible(false);
		this.formPedido.setVisible(false);
		this.formCliente.setVisible(false);
		this.formFornecedor.setVisible(false);
		this.listarProdutos.setVisible(false);
		
		content.add(BorderLayout.SOUTH, this.formCliente);
		content.add(BorderLayout.SOUTH, this.formProduto);
		content.add(BorderLayout.SOUTH, this.formPedido);
		content.add(BorderLayout.SOUTH, this.formFornecedor);
		content.add(BorderLayout.CENTER, this.listarProdutos);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 600);
		this.setVisible(true);
	}
	public static void main(String args[]) throws HeadlessException, ClassNotFoundException, IOException{
		new Interface();
	}
	public JMenuBar createMenuBar(){
		JMenuBar bar = new JMenuBar();
		JMenu menuProdutos = new JMenu("Produtos");
		
		JMenuItem itemCadastrarProduto = new JMenuItem("Cadastrar");
		itemCadastrarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		itemCadastrarProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formCliente.setVisible(false);
				formPedido.setVisible(false);
				formFornecedor.setVisible(false);
				listarProdutos.setVisible(false);
				formProduto.setVisible(true);

			}
		});
		
		JMenuItem itemListarProduto = new JMenuItem("Listar");
		itemListarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		itemListarProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formCliente.setVisible(false);
				formPedido.setVisible(false);
				formFornecedor.setVisible(false);
				formProduto.setVisible(false);
				listarProdutos.setVisible(true);
			}
		});
		menuProdutos.add(itemCadastrarProduto);
		menuProdutos.add(itemListarProduto);
		
		bar.add(menuProdutos);
		bar.setVisible(true);
		return bar;
	}
	public void listarProdutos() throws ClassNotFoundException, IOException{
		JPanel panel = new JPanel();
		this.listarProdutos = panel;
		this.listarProdutos.setLayout(new FlowLayout());
		
		Fachada fachada = new Fachada("ArrayList");
		ArrayList<Produto> lista = fachada.listarProduto();
		if(lista.isEmpty()){
			this.setSize(900, 500);
			return;
		}
		panel.setLayout(new FlowLayout());
		Object valores[][] = new Object[lista.size()][3];
		int i = 0;
		for(Produto produto : lista){
			valores[i][0] = "" + produto.getCodigo();
			valores[i][1] = produto.getNome();
			valores[i][2] = "" + produto.getPreco();
		}
		Object colunas[] = {"Codigo", "Nome", "Preço"}; 
		JTable table = new JTable(valores, colunas);
		this.listarProdutos.add(table);
		this.setSize(900, 500);
	}
	public void createFormProduto(){
		this.formProduto = new JPanel();
		this.formProduto.setLayout(new GridLayout(8, 1));
		
		JLabel labelNome = new JLabel("Nome");
		final JTextField textBoxNome = new JTextField(50);
		textBoxNome.setName("nome");
		this.formProduto.add(labelNome);
		this.formProduto.add(textBoxNome);
		
		JLabel labelCategoria = new JLabel("Categoria");
		final JTextField textBoxCategoria = new JTextField(50);
		textBoxCategoria.setName("categoria");
		this.formProduto.add(labelCategoria);
		this.formProduto.add(textBoxCategoria);
		
		JLabel labelPreco = new JLabel("Preco");
		final JTextField textBoxPreco = new JTextField(50);
		textBoxPreco.setName("preco");
		this.formProduto.add(labelPreco);
		this.formProduto.add(textBoxPreco);
		
		JButton btn = new JButton("Cadastrar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nome = textBoxNome.getText();
				String categoria = textBoxCategoria.getText();
				double preco = Double.parseDouble(textBoxPreco.getText());
				Fachada fachada = new Fachada("ArrayList");
				int codigo;
				try {
					codigo = (int) fachada.getNextIdProduto();
					Produto produto = new Produto(codigo, nome, preco, categoria);
					listarProdutos();
					try {
						fachada.cadastrarProduto(produto);
					} catch (IllegalArgumentException | ClassNotFoundException | ProdutoJaCadastradoException
							| ProdutoNaoEncontradoException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.formProduto.add(btn);
		this.formProduto.setSize(900, 500);
	}
	public void createFormCliente(){
		this.formCliente = new JPanel();
		this.formCliente.setLayout(new GridLayout(6, 1));
		
		JLabel labelNome = new JLabel("Nome");
		final JTextField textBoxNome = new JTextField(50);
		textBoxNome.setName("nome");
		this.formCliente.add(labelNome);
		this.formCliente.add(textBoxNome);
		
		JLabel labelCpf = new JLabel("CPF");
		final JTextField textBoxCpf = new JTextField(50);
		textBoxCpf.setName("cpf");
		this.formCliente.add(labelCpf);
		this.formCliente.add(textBoxCpf);
		
		JButton btn = new JButton("Cadastrar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nome = textBoxNome.getText();
				String cpf = textBoxCpf.getText();
				Fachada fachada = new Fachada("ArrayList");
				int codigo;
				try {
					codigo = (int) fachada.getNextIdCliente();
					Cliente cliente = new Cliente(codigo, nome, cpf);
					try {
						fachada.cadastrarCliente(cliente);
					} catch (IllegalArgumentException | ClassNotFoundException | CPFInvalidoException
							| ClienteJaCadastradoException | ClienteNaoExncontradoException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException | IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		this.formCliente.add(btn);
		this.formCliente.setSize(900, 500);
	}
	public void createFormFornecedor(){
		this.formFornecedor = new JPanel();
		this.formFornecedor.setLayout(new FlowLayout());
		this.formFornecedor.setSize(900, 500);
	}
	public void createFormPedido() throws ClassNotFoundException, IOException{
		this.formPedido = new JPanel();
		this.formPedido.setLayout(new GridLayout(14, 1));
		
		JLabel labelQuantidade = new JLabel("Quantidade");
		final JTextField textBoxQuantidade = new JTextField(50);
		textBoxQuantidade.setName("quantidade");
		this.formPedido.add(labelQuantidade);
		this.formPedido.add(textBoxQuantidade);
		
		JLabel labelCodigoProduto = new JLabel("Codigo Produto");
		final JComboBox<Double> comboBoxProduto = new JComboBox<Double>();
		final Fachada fachada = new Fachada("ArrayList");
		ArrayList<Produto> listaProdutos = fachada.listarProduto();
		if(!listaProdutos.isEmpty()){
			for(Produto produto : listaProdutos){
				comboBoxProduto.addItem((double) produto.getCodigo());
			}
		}
		this.formPedido.add(labelCodigoProduto);
		this.formPedido.add(comboBoxProduto);
		
		JLabel labelValorProduto = new JLabel("Valor Produto: ");
		final JTextField textBoxValorProduto = new JTextField(50);
		textBoxValorProduto.setName("valorProduto");
		this.formPedido.add(labelValorProduto);
		this.formPedido.add(textBoxValorProduto);
		
		JLabel labelValorPedido = new JLabel("Valor Pedido: ");
		final JTextField textBoxValorPedido = new JTextField(50);
		textBoxValorProduto.setName("valorPedido");
		this.formPedido.add(labelValorPedido);
		this.formPedido.add(textBoxValorPedido);
		
		JLabel labelCodigoCliente = new JLabel("Codigo Cliente");
		final JComboBox<Double> comboBoxCliente = new JComboBox<Double>();
		ArrayList<Cliente> listaClientes = fachada.listarCliente();
		if(!listaClientes.isEmpty() || listaClientes == null){
			for(Cliente cliente : listaClientes){
				comboBoxCliente.addItem((double) cliente.getCodigo());
			}
		}
		this.formPedido.add(labelCodigoCliente);
		this.formPedido.add(comboBoxCliente);
		
		JLabel labelCodigoFornecedor = new JLabel("Codigo Fornecedor");
		final JComboBox<Double> comboBoxFornecedor = new JComboBox<Double>();
		ArrayList<Fornecedor> listaFornecedores = fachada.listarFornecedor();
		if(!listaFornecedores.isEmpty() || listaFornecedores == null){
			for(Fornecedor fornecedor : listaFornecedores){
				comboBoxFornecedor.addItem((double) fornecedor.getCodigo());
			}
		}
		this.formPedido.add(labelCodigoFornecedor);
		this.formPedido.add(comboBoxFornecedor);
		
 		comboBoxProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				double valor = (double) comboBoxProduto.getSelectedItem();
				try {
					Produto produto = fachada.procurarProduto("" + valor);
					textBoxValorProduto.setText("" + produto.getPreco());
					int quantidade = Integer.parseInt(textBoxQuantidade.getText());
					double valorProduto = quantidade * produto.getPreco();
					textBoxValorPedido.setText("" + valorProduto);
				} catch (ClassNotFoundException | ProdutoNaoEncontradoException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btn = new JButton("Cadastrar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int quantidade = Integer.parseInt(textBoxQuantidade.getText());
				int codigoProduto = (int)comboBoxProduto.getSelectedItem();
				int codigoCliente = (int) comboBoxCliente.getSelectedItem();
				int codigoFornecedor = (int) comboBoxFornecedor.getSelectedItem();
				double valorProduto = Double.parseDouble(textBoxValorProduto.getText());
				double valorTotal = Double.parseDouble(textBoxValorPedido.getText());
				
				Fachada fachada = new Fachada("ArrayList");
				int codigo;
				try {
					codigo = (int) fachada.getNextIdPedido();
					Date data = new Date();
					SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					NotaFiscal notaFiscal = new NotaFiscal((int)fachada.getNextIdNotaFiscal(), format.format(data), codigoCliente);
					try {
						fachada.cadastrarNotaFiscal(notaFiscal);
						Pedido pedido = new Pedido (codigo, quantidade, valorProduto, valorTotal, codigoProduto, codigoFornecedor, codigoCliente, format.format(data), notaFiscal.getCodigo());
						fachada.cadastrarPedido(pedido);
						
					} catch (IllegalArgumentException | ClassNotFoundException | NotaFiscalJaCadastradaException
							| NotaFiscalNaoEncontradaException | IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (PedidoJaCadastradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PedidoNaoEncontradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException | IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			}
		});
		this.formPedido.add(btn);
		this.formPedido.setSize(900, 500);
	}
}
