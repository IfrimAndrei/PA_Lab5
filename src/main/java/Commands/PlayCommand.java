package Commands;

import Catalog.Catalog;
import CustomExceptions.ArgumentsException;
import MediaItems.Item;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PlayCommand extends Command {
    @Override
    public void execute(String[] arguments, Catalog myCatalog)
            throws ArgumentsException, IOException, URISyntaxException {
        if (  arguments.length > 2)
        {
            throw new ArgumentsException( new Exception() );
        }

        if(arguments.length == 2) {
            Desktop desktop = Desktop.getDesktop();
            setArguments( arguments );

            URI uri = new URI( arguments[1] );
            desktop.browse( uri );

        }
        else
        {
            URI uri = null;
            if(myCatalog.getItems().size() == 0)
                throw new IllegalArgumentException(
                        "ItemList should not be empty."
                );

            Desktop desktop = Desktop.getDesktop();
            for(Item i : myCatalog.getItems())
            {

                    uri = new URI(i.getLocation());
                    desktop.browse(uri);

            }
        }
    }

}
