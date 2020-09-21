package wyszukiwarka;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class search {

    public static void main(String[] args) {

        String[] excludedItems = {"oraz", "ponieważ", "żeby", "może", "tego", "moja", "której", "przez", "między",
                                    "wbrew", "jaki", "ponad", "które", "ależ", "miała", "były", "wśród", "nawet"};

        Connection connect = Jsoup.connect("http://www.onet.pl/");

        Path path = Paths.get("src/wyszukiwarka/popular_words.txt");
        Path path1 = Paths.get("src/wyszukiwarka/filtered_popular_words.txt");
        ArrayList<String> list = new ArrayList<>();

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            try {
                Document document = connect.get();
                Elements links = document.select("span.title");
                for (int i = 0; i < links.size(); i++) {
                    String elem = links.get(i).text();
                    System.out.println(elem);
                    String[] parts = elem.split(" ");
                    for (String part : parts) {
                        if (part.length() > 3) {
                            list.add(part);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Files.write(path, list);
            } catch (IOException e) {
                System.out.println("Nie można zapisać pliku!!!");
            }
        } catch (IOException e) {
            System.out.println("Bład zapisu");
        }

        ArrayList<String> outLine = new ArrayList<>();

        try {
            if (!Files.exists(path1)) {
                Files.createFile(path1);
            }
            try {
                Scanner scann =  new Scanner(path);
                while (scann.hasNextLine()) {
                    String text = scann.nextLine();
                    String bad = "";
                    for (int i = 0; i < excludedItems.length; i++) {
                        if (excludedItems[i].equals(text)) {
                            bad = text;
                        }
                    }
                    if (bad == "") {
                        outLine.add(text);
                    }
                    bad = "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Files.write(path1, outLine);
            } catch (IOException ex) {
                System.out.println("Brak zapisu do pliku");
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu");
        }
    }
}
