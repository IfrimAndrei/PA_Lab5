package Commands;

import Catalog.Catalog;
import CustomExceptions.ArgumentsException;
import CustomExceptions.InvalidCatalogException;

import java.io.*;

public class LoadCommand extends Command{
    private Catalog loadedCatalog;

    public Catalog getLoadedCatalog( ) {
        return loadedCatalog;
    }

    @Override
    public void execute(String[] arguments, Catalog myCatalog)
            throws ArgumentsException, InvalidCatalogException, IOException, ClassNotFoundException {

        if ( arguments.length > 2 ) {
            throw new ArgumentsException( new Exception() );
        }

        File f = new File( arguments[1] );

        if ( !f.exists() || f.isDirectory() ) {
            throw new InvalidCatalogException( new Exception() );
        }


        var ois = new ObjectInputStream(
                new FileInputStream( arguments[1] ) );
        loadedCatalog = (Catalog) ois.readObject();

    }
}
