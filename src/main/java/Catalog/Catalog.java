package Catalog;

import CustomExceptions.InvalidNameException;
import MediaItems.Item;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public String getName( ) {
        return name;
    }
    public String getPath( ) {
        return path;
    }
    public List<Item> getItems( ) {
        return items;
    }

    public Catalog(String name, String path) {
        this.name=name;
        this.path=path;
    }

    public void add(Item item) {
        items.add( item );
    }

    public void play(){
        if(items.size() == 0)
            throw new IllegalArgumentException(
                    "ItemList should not be empty."
            );

        Desktop desktop = Desktop.getDesktop();
        for(Item i : items)
        {
            URI uri = null;
            try{
                uri = new URI(i.getLocation());
                desktop.browse(uri);
            }
            catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Item searchByName(String name) throws InvalidNameException {
        for ( Item i : items ) {
            if ( i.getName().equals( name ) ) {
                return i;
            }
        }
        throw new InvalidNameException( new Exception() );
    }
    public void list()
    {
        System.out.println("Itemele din catalog sunt: ");
        for(Item i : items)
            System.out.println( i.toString());
    }
}

