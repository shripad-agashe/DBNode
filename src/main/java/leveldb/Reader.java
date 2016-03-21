package leveldb;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;
import static org.iq80.leveldb.impl.Iq80DBFactory.factory;
public class Reader {


    public  String get(String key) throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("example"), options);
        String value = "";
        try {
            value = new String(db.get(bytes(key)));
        } finally {
            // Make sure you close the db to shutdown the
            // database and avoid resource leaks.
            db.close();
        }
        return  value;

    }

}
