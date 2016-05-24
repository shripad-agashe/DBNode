package leveldb;

import common.DBEntry;
import common.DBOperationResponse;
import org.iq80.leveldb.DB;

import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;

public class Writer {


    private DB db;

    public Writer(DB db){

        this.db = db;
    }

    public DBOperationResponse add(DBEntry dbEntry) throws IOException {


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
