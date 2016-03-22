package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import common.DBEntry;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CommandHandler extends SimpleChannelInboundHandler {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf1 = (ByteBuf) msg;

        Kryo kryo = new Kryo();
        int i = buf1.readableBytes();

        byte[] buf = new byte[i];
        buf1.readBytes(buf);
        Input input = new Input(buf);
        DBEntry dbEntry;
        Object obj = kryo.readClassAndObject(input);
        ctx.fireChannelRead(obj);
    }
}
