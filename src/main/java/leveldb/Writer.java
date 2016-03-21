package leveldb;

import common.DBEntry;
import common.DBOperationResponse;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

import java.io.File;
import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;
import static org.iq80.leveldb.impl.Iq80DBFactory.factory;

public class Writer {

    public DBOperationResponse add(DBEntry dbEntry) throws IOException {
        Options options = new Options();
        options.createIfMissing(true);
        DB db = factory.open(new File("example"), options);
        try {
            db.put(bytes(dbEntry.key), bytes(dbEntry.value));
        } finally {
            // Make sure you close the db to shutdown the
            // database and avoid resource leaks.
            db.close();
        }
        return new DBOperationResponse("Added");
    }
}
