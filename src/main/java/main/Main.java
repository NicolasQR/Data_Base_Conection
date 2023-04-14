package main;

import db.DBConnection;
import model.*;
import providers.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        DBConnection dbConnection = new DBConnection();
        DataProvider dataProvider = new DataProvider();
        GenreProvider genreProvider = new GenreProvider();
        ItemProvider itemProvider = new ItemProvider();
        InfoProvider infoProvider = new InfoProvider();
        OccupationProvider occupationProvider = new OccupationProvider();
        UserProvider userProvider = new UserProvider();


        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "user");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            String nombreArchivo = archivo.getName();
            String[] infoParts = new String[3];
            int i = 0;
            try {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {

                    if (!(nombreArchivo.contains("info") && !(nombreArchivo.contains("data")))) {

                        String linea = scanner.nextLine();
                        linea += "|";
                        String[] parts = linea.split("\\|");
                        System.out.println(linea);

                        if (nombreArchivo.contains("user")) {
                            System.out.println("El nombre del archivo contiene la palabra 'user'");
                            User user = new User(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3], Long.parseLong(parts[4]));
                            userProvider.createUser(user);
                        } else if (nombreArchivo.contains("genre")) {
                            System.out.println("El nombre del archivo contiene la palabra 'genre'");
                            Genre genre = new Genre(Integer.parseInt(parts[1]), parts[0]);
                            genreProvider.createGenre(genre);
                        } else if (nombreArchivo.contains("item")) {
                            System.out.println("El nombre del archivo contiene la palabra 'item'");
                            Genre genre = new Genre(Integer.parseInt(parts[1]), parts[0]);
                            genreProvider.createGenre(genre);
                        }
                    } else if (nombreArchivo.contains("data")) {
                            String linea = scanner.nextLine();
                            linea += "  ";
                            String[] parts = linea.split("\\    ");
                            System.out.println(linea);

                            System.out.println("El nombre del archivo contiene la palabra 'data'");
                            Data data = new Data(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), new Timestamp(Long.parseLong(parts[3])));
                            dataProvider.createData(data);
                    } else {
                        String linea = scanner.nextLine();
                        linea += " ";
                        String[] parts = linea.split("\\ ");
                        infoParts[i] = parts[0];
                        i++;
                        System.out.println(linea);
                        System.out.println("El nombre del archivo contiene la palabra 'info'");

                    }

                }
                Info info = new Info(Integer.parseInt(infoParts[0]),Integer.parseInt(infoParts[1]),Integer.parseInt(infoParts[1]));
                infoProvider.createInfo(info);
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        //Parte de lectura de archivos



        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(genre);
        Item item = new Item(1,"Title", "Releasedate", "Videorelease", genres);
        Occupation occupation = new Occupation("idk");

        //
        try {


            occupationProvider.createOccupation(occupation);
            itemProvider.createItem(item);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
