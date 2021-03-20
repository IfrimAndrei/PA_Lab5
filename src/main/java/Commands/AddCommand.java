package Commands;

import Catalog.Catalog;
import CustomExceptions.ArgumentsException;
import MediaItems.Image;
import MediaItems.Movie;

public class AddCommand extends Command{

    @Override
    public void execute(String[] arguments, Catalog myCatalog) throws ArgumentsException {
        if (  arguments.length > 4 || arguments .length <2)
        {
            throw new ArgumentsException( new Exception() );
        }
        if( arguments[1].equals( "Movie" ) )
        {
            Movie myMovie = new Movie (arguments[2],arguments[3]);
            myCatalog.getItems().add( myMovie );
            return;
        }
        if( arguments[1].equals( "Image" ) )
        {
            Image myImage = new Image (arguments[2],arguments[3]);
            myCatalog.getItems().add( myImage );
            return;
        }
        throw new ArgumentsException( new Exception() );


    }
}
