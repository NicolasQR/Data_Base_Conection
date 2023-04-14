package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadData {

	private static List<Users> users;
	
	public static void main(String[] args) {
		  users = new ArrayList<>();
		  JFileChooser chooser = new JFileChooser();
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "user");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(null);
		  if(returnVal == JFileChooser.APPROVE_OPTION) {
		    File archivo = chooser.getSelectedFile();
		    try {
		      Scanner scanner = new Scanner(archivo);
		      while (scanner.hasNextLine()) {
		        	
		        String linea = scanner.nextLine();
		        linea += "|";
		        String[] parts = linea.split("\\|");
		        System.out.println(linea);
		        addUsers(Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
		 
		      }
		      scanner.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		  }
	 }
	
		
	public static void addUsers(int age, String genre, String ocupation, String parts) {
		Users user = new Users(age, genre, ocupation, parts);
		users.add(user);
	}
	
	public void conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1522/mydatabase", "username", "password");

	}
}
