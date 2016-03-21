package server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class DBServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("ObjectDecoder", new CommandDecoder());
        pipeline.addLast("ObjectEncoder", new CommandEncoder());
        pipeline.addLast("RequestHandler", new CommandHandler());
//        pipeline.close();
    }
}
