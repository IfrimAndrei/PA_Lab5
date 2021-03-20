package Commands;

import Catalog.Catalog;
import CustomExceptions.ArgumentsException;
import CustomExceptions.InvalidCatalogException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Command {
    private String[] arguments;

    public String[] getArguments( ) {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }
    public abstract void execute(String[] arguments, Catalog myCatalog ) throws ArgumentsException, InvalidCatalogException, IOException, URISyntaxException, ClassNotFoundException;
}

