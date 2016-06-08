package br.aeso.exercicio.arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ArquivosManager{
	private FileOutputStream fileOutput;
	private FileInputStream fileInput;
	private ObjectOutputStream objectOutput;
	private ObjectInputStream objectInput;
	
	public boolean exists(String path){
		Path caminho = Paths.get(path);
		return Files.exists(caminho);
	}
	public void createFile(String path) throws IOException{
		System.out.println(path);
		File file = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
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
	
	public void saveValores(HashMap<Integer, Object> valores,  String path) throws IOException{
		this.fileOutput = new FileOutputStream(path);
		this.objectOutput = new ObjectOutputStream(this.fileOutput);
		
		this.objectOutput.writeObject(valores);
	}
	public void saveValores(HashSet<Object> valores, String path) throws IOException{
		this.fileOutput = new FileOutputStream(path);
		this.objectOutput = new ObjectOutputStream(this.fileOutput);
		
		this.objectOutput.writeObject(valores);
	}
	public Object getValores(String path) throws ClassNotFoundException, IOException{
		System.out.println(path);
		this.fileInput = new FileInputStream(path);
		this.objectInput = new ObjectInputStream(this.fileInput);
		
		Object valores = objectInput.readObject();
		return valores;
	}
}
