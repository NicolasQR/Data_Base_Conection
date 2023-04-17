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
        ItemGenreProvider itemGenreProvider = new ItemGenreProvider();


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

                    if (!(nombreArchivo.contains("info")) && !(nombreArchivo.contains("data"))) {
                        String linea = scanner.nextLine();
                        if(linea.equals("")){
                            break;
                        }
                        //linea += "|";
                        String[] parts = linea.split("\\|");
                        System.out.println(linea);

                        if (nombreArchivo.contains("user")) {
                            User user = new User(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2], parts[3], parts[4]);
                            userProvider.createUser(user);
                        } else if (nombreArchivo.contains("genre")) {
                            if(parts[0].equals("Children's")){
                                parts[0] = "Children''s";
                            }
                            Genre genre = new Genre(Integer.parseInt(parts[1]), parts[0]);
                            genreProvider.createGenre(genre);
                        } else if (nombreArchivo.contains("item")) {
                            //Primeros 4 no cuentan en los generos

                            String[] title_date = parts[1].split("\\(");
                            String title = "";
                            String date = "";
                            if(title_date.length > 2) {
                                if(title_date.length == 3) {
                                    title = title_date[0] + title_date[1];
                                    date = title_date[2].replace(")", " ");
                                } else {
                                    title = "";
                                    for(int x = 0; x < title_date.length - 1; x++){
                                        title += title_date[x];
                                    }
                                    date = title_date[title_date.length];
                                }
                            } else if(title_date.length > 1){
                                title = title_date[0];
                                date = title_date[1].replace(")", " ");
                            }
                            ArrayList<Genre> genres = new ArrayList<>();
                            ArrayList<ItemGenre> itemGenres = new ArrayList<>();

                            if(parts[5].equals("1")){
                                Genre genre = genreProvider.getGenre("unknown");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[6].equals("1")){
                                Genre genre = genreProvider.getGenre("Action");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[7].equals("1")){
                                Genre genre = genreProvider.getGenre("Adventure");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[8].equals("1")){
                                Genre genre = genreProvider.getGenre("Animation");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[9].equals("1")){
                                Genre genre = genreProvider.getGenre("Children''s");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            } if(parts[10].equals("1")){
                                Genre genre = genreProvider.getGenre("Comedy");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[11].equals("1")){
                                Genre genre = genreProvider.getGenre("Crime");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[12].equals("1")){
                                Genre genre = genreProvider.getGenre("Documentary");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[13].equals("1")){
                                Genre genre = genreProvider.getGenre("Drama");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[14].equals("1")) {
                                Genre genre = genreProvider.getGenre("Fantasy");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[15].equals("1")) {
                                Genre genre = genreProvider.getGenre("Film-Noir");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[16].equals("1")){
                                Genre genre = genreProvider.getGenre("Horror");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[17].equals("1")){
                                Genre genre = genreProvider.getGenre("Musical");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[18].equals("1")){
                                Genre genre = genreProvider.getGenre("Mystery");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[19].equals("1")){
                                Genre genre = genreProvider.getGenre("Romance");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[20].equals("1")){
                                Genre genre = genreProvider.getGenre("Sci-Fi");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[21].equals("1")){
                                Genre genre = genreProvider.getGenre("Thriller");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[22].equals("1")){
                                Genre genre = genreProvider.getGenre("War");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);
                            }
                            if(parts[23].equals("1")){
                                Genre genre = genreProvider.getGenre("Western");
                                genres.add(genre);
                                ItemGenre itemGenre = new ItemGenre(Integer.parseInt(parts[0]), genre.getId());
                                itemGenres.add(itemGenre);

                            }

                            if(title.contains("'")){
                                title = title.replace("'", "''");
                            }
                            if(parts[1].contains("'")){
                                parts[2] = parts[2].replace("'", "''");
                            }
                            if(parts[4].contains("'")){
                                parts[4] = parts[4].replace("'", "''");
                            }

                            Item item = new Item(Integer.parseInt(parts[0]), title, date, parts[2], parts[4], genres);
                            itemProvider.createItem(item);
                            for(int j = 0; j < itemGenres.size(); j++){
                                itemGenreProvider.createItemGenre(itemGenres.get(j));
                            }

                        }
                        else if (nombreArchivo.contains("occupation")){
                            occupationProvider.createOccupation(new Occupation(parts[0]));
                        }
                    } else if (nombreArchivo.contains("data")) {
                            String linea = scanner.nextLine();
                           // linea += "  ";
                            String[] parts = linea.split("\t");
                            System.out.println(linea);
                            Data data = new Data(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), new Timestamp(Long.parseLong(parts[3])));
                            dataProvider.createData(data);
                    } else if (nombreArchivo.contains("info")){
                        String linea = scanner.nextLine();
                        linea += " ";
                        String[] parts = linea.split("\\ ");
                        infoParts[i] = parts[0];
                        i++;
                        System.out.println(linea);
                    }
                }
                if(i != 0) {
                    Info info = new Info(Integer.parseInt(infoParts[0]), Integer.parseInt(infoParts[1]), Integer.parseInt(infoParts[1]));
                    infoProvider.createInfo(info);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
