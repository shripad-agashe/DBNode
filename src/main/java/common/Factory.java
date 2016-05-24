package common;

import leveldb.Reader;
import leveldb.Writer;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.factory;

public class Factory

{
    public static int portNumber = 100000;

    public static Writer getWriter(){

        Writer writer = new Writer(getDb());

        return writer;
    }

    public static Reader getReader(){

        Reader reader = new Reader(getDb());

        return reader;
    }

    private static DB getDb() {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = null;
        try {
           db =  factory.open(new File("example-" + portNumber), options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return db;
    }

}
