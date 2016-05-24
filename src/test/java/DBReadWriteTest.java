import common.DBEntry;
import common.Factory;
import leveldb.Reader;
import leveldb.Writer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DBReadWriteTest {

    @Test
    public void verifyIfValueIstored() throws IOException {
       Writer dbWriter = Factory.getWriter();
        Reader dbReader = Factory.getReader();
        dbWriter.add(new DBEntry("abc","def"));

        Assert.assertEquals("def", dbReader.get("abc"));
    }

}