import common.Factory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Slf4JLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.DBServerInitializer;

public class DBSocketServer {

    final static Logger logger = LoggerFactory.getLogger(DBSocketServer.class);


    public  static void main(String[] args) throws ClassNotFoundException, InterruptedException {

        if (args.length != 1) {
            System.err.println("Usage: java DBSocketServer <port number>");
            System.exit(1);
        }

            int portNumber = Integer.parseInt(args[0]);
        System.out.println("Starting on port:" + portNumber);
        logger.info("Starting server");

        Factory.portNumber = portNumber;

        startNetty(portNumber);


    }


    private static void startNetty(int portNumber) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory());

        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new DBServerInitializer());

            b.bind(portNumber).sync().channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


//    private static void addEntryToDB(int portNumber) throws ClassNotFoundException, InterruptedException {
//
//        try (
//                ServerSocket serverSocket = new ServerSocket(portNumber);
//                Socket clientSocket = serverSocket.accept();
//                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
////                BufferedReader in = new BufferedReader(
////                        new InputStreamReader(clientSocket.getInputStream()))
//                InputStream inputStream = clientSocket.getInputStream();
//                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//        ) {
//            if(objectInputStream.available() == 0) {Thread.sleep(10);return;}
//            DBEntry entry = (DBEntry)objectInputStream.readObject();
//            DBOperationResponse add = new leveldb.Writer().add(entry);
//            System.out.println("Response: " + add.getResponse());
//            out.writeObject(add);
//        } catch (IOException e) {
//            System.out.println("Exception caught when trying to listen on port "
//                    + portNumber + " or listening for a connection");
//            System.out.println(e.getMessage());
//        }
//    }
}
