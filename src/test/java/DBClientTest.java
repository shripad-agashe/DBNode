import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DBClientTest {

    @Test
    public void addKeyValue() throws IOException {
        DBClient client = new DBClient();
        client.add("abc","def");
        Assert.assertEquals("def", client.get("abc"));
    }

}