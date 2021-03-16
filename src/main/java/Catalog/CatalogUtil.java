package Catalog;

import CustomExceptions.InvalidCatalogException;
import CustomExceptions.InvalidNameException;
import MediaItems.Item;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        File f = new File(path);
        if(!f.exists() || f.isDirectory()) {
            throw new InvalidCatalogException( new Exception() );
        }


        try (var ois = new ObjectInputStream(
                new FileInputStream( path ))){
                return (Catalog) ois.readObject();
        }

    }

    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
        URI uri = null;
        try{
            uri = new URI(item.getLocation());
            desktop.browse(uri);
        }
        catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

}