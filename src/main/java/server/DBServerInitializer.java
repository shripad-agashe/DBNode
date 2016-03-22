package server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

public class DBServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("ObjectDecoder", new DelimiterBasedFrameDecoder(50000,  Unpooled.wrappedBuffer("#".getBytes())));
        pipeline.addLast("ObjectEncoder", new CommandEncoder());
        pipeline.addLast("RequestHandler", new CommandHandler());
//        pipeline.close();
    }
}
