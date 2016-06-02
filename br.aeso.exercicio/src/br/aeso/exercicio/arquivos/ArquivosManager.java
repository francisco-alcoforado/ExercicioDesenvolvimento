package br.aeso.exercicio.arquivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ArquivosManager {
	private FileOutputStream fileOutput;
	private FileInputStream fileInput;
	private ObjectOutputStream objectOutput;
	private ObjectInputStream objectInput;
	
	public boolean exists(String path){
		Path caminho = Paths.get(path);
		return Files.exists(caminho);
	}
	public void saveArray(Object valores[], String path) throws IOException{
		this.fileOutput = new FileOutputStream(path);
		this.objectOutput = new ObjectOutputStream(this.fileOutput);
		
		this.objectOutput.writeObject(valores);
	}
	
	public Object[] getArray(String path) throws IOException, ClassNotFoundException{
		this.fileInput = new FileInputStream(path);
		this.objectInput = new ObjectInputStream(this.fileInput);
		
		Object valores[] = (Object[]) objectInput.readObject();
		return valores;
	}
	
	public void saveValores(ArrayList<Object> valores, String path) throws IOException{
		this.fileOutput = new FileOutputStream(path);
		this.objectOutput = new ObjectOutputStream(this.fileOutput);
		
		this.objectOutput.writeObject(valores);
	}
	
	public Object getValores(String path) throws ClassNotFoundException, IOException{
		this.fileInput = new FileInputStream(path);
		this.objectInput = new ObjectInputStream(this.fileInput);
		
		Object valores = objectInput.readObject();
		return valores;
	}
}
