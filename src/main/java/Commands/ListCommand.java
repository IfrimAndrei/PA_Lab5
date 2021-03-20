package Commands;

import Catalog.Catalog;
import CustomExceptions.ArgumentsException;
import CustomExceptions.InvalidCatalogException;
import MediaItems.Item;

import java.io.FileNotFoundException;

public class ListCommand extends Command{

    @Override
    public void execute(String[] arguments, Catalog myCatalog) throws ArgumentsException, InvalidCatalogException, FileNotFoundException {

        if (  arguments.length > 1)
        {
            throw new ArgumentsException( new Exception() );
        }
        System.out.println("Itemele din catalog sunt: ");
        for( Item i : myCatalog.getItems())
            System.out.println( i.toString());

    }
}
