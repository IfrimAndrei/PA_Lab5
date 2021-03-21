import Catalog.Catalog;
import CustomExceptions.ArgumentsException;
import CustomExceptions.InvalidCatalogException;
import CustomExceptions.InvalidNameException;
import MediaItems.Image;
import MediaItems.Movie;
import Catalog.CatalogUtil;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Shell myShell = new Shell();
        myShell.execute();

         /* Compulsory part
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
        }
        catch (IOException | ClassNotFoundException | InvalidCatalogException | InvalidNameException e) {
            e.printStackTrace();
        }*/

    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Some Cats", "d:/media/catalog.ser");

        var firstImage = new Image("bestImage","d:/media/examples/Cat1.jpg" );
        var secondImage = new Image("bestImage2","d:/media/examples/Cat2.jpeg" );
        var thirdImage = new Image("bestImage3","d:/media/examples/Cat3.jpg" );
        var movie = new Movie("bestMovie","https://www.youtube.com/watch?v=NUYvbT6vTPs" );

        catalog.add(firstImage);
        catalog.add(secondImage);
        catalog.add(thirdImage);
        catalog.add(movie);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IOException, ClassNotFoundException, InvalidCatalogException, InvalidNameException {
        Catalog catalog = CatalogUtil.load("d:/media/catalog.ser");
        //catalog.play();
        CatalogUtil.view( catalog.searchByName("bestMovie") );
    }
}