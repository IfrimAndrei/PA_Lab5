import Catalog.Catalog;
import Commands.*;
import CustomExceptions.ArgumentsException;
import CustomExceptions.InvalidCatalogException;
import CustomExceptions.InvalidCommandException;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Shell {
    private String commandLine;
    private final BufferedReader console = new BufferedReader
            (new InputStreamReader(System.in));
    private Catalog myCatalog;
    public void execute() {
        System.out.println("Welcome to the shell! Use info to see available commands ");

        Catalog myCatalog = new Catalog("Shell Catalog","d:/media/catalog.ser");
        while(true)
        {
            System.out.print("Shell: ");
            try {
                commandLine = console.readLine();
            } catch (IOException e) {

                try {
                    e.printStackTrace();
                    sleep( 100 );

                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

            if (commandLine.equals(""))
                continue;
            if(!analyzeCommand())
                break;

        }

    }

    public boolean analyzeCommand()  {

        try {
            String[] arguments = commandLine.split( " ", 5 );
            commandLine = arguments[0];


            if ( commandLine.equals( "info" ) ) {
                System.out.println( "Comenzi posibile : 'add' 'list' 'load' 'play' 'quit' 'report'" );
                System.out.println( "-- add : add TYPE[MOVIE|IMAGE] NAME[STRING] PATH[STRING]" );
                System.out.println( "-- play: play : da play la itemele din catalog " );
                System.out.println( "         play path[STRING]: da play la acel path " );
                System.out.println( "-- load: load path[STRING]" );
                System.out.println( "-- save : save" );
                System.out.println( "-- list : list " );
                System.out.println( "-- report: report");
                return true;
            }
            if ( commandLine.equals( "add" ) ) {
                AddCommand myAdd = new AddCommand();
                myAdd.execute( arguments, myCatalog );
                return true;
            }
            if ( commandLine.equals( "list" ) ) {
                ListCommand myList = new ListCommand();
                myList.execute( arguments, myCatalog );
                return true;
            }
            if ( commandLine.equals( "load" ) ) {
                LoadCommand myLoad = new LoadCommand();
                myLoad.execute( arguments, myCatalog );
                myCatalog = myLoad.getLoadedCatalog();
                return true;
            }
            if ( commandLine.equals( "play" ) ) {

                PlayCommand myPlay = new PlayCommand();
                myPlay.execute( arguments, myCatalog );
                return true;
            }
            if( commandLine.equals("save")){
                SaveCommand mySave = new SaveCommand();
                mySave.execute( arguments, myCatalog );
                return true;
            }
            if ( commandLine.equals( "report" ) ) {

                return true;
            }
            if ( commandLine.equals( "quit" ) ) {
                System.out.println( "Shell closed" );
                return false;
            }

            //if command is not recognized, we give a custom exception, the sleep is so that the "Shell: " output is sent after the error print
            throw new InvalidCommandException( new Exception() );

        }

        catch (ArgumentsException | InvalidCatalogException | IOException | URISyntaxException | InvalidCommandException | ClassNotFoundException e) {

            try {
                e.printStackTrace();
                sleep( 100 );

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            return true;
        }

    }

}
