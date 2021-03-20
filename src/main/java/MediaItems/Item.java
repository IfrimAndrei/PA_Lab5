package MediaItems;
import java.io.Serializable;


public abstract class Item implements Serializable {
    private String name;
    private String location;


    public Item(String name, String path) {
        this.name=name;
        this.location=path;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getName( ) {
        return name;
    }
    public String getLocation( ) {
        return location;
    }

    @Override
    public String toString( ) {
        return "Item{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    //…
}
