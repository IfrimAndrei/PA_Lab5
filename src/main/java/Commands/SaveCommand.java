package Commands;

import Catalog.Catalog;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command{

    @Override
    public void execute(String[] arguments, Catalog myCatalog) throws IOException {
         var oos = new ObjectOutputStream(new FileOutputStream(myCatalog.getPath())) ;
         oos.writeObject(myCatalog);;
    }
}
