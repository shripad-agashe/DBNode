package leveldb;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;
public class Reader {

    private DB db;

    public Reader(DB db){

        this.db = db;
    }




    public  String get(String key) throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        String value = "";
        try {
            value = new String(db.get(bytes(key)));
        } finally {
            // Make sure you close the db to shutdown the
            // database and avoid resource leaks.
            db.close();
        }

        System.out.println("###### " + value);

        return  value;

    }

}
