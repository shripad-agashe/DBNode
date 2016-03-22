package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import common.DBEntry;
import common.DBOperationResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CommandHandler extends SimpleChannelInboundHandler {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.write(new DBOperationResponse("hi there"));
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(new DBOperationResponse("hi there"));

        System.out.println(msg.getClass().getName());

        ByteBuf buf1 = (ByteBuf) msg;
        System.out.println(buf1.readableBytes());


        Kryo kryo = new Kryo();
        kryo.register(DBEntry.class,new JavaSerializer());
//
        int i = buf1.readableBytes();


        byte[] buf = new byte[i];
        buf1.readBytes(buf);
        Input input = new Input(buf);
        DBEntry dbEntry;
        dbEntry = (DBEntry) kryo.readClassAndObject(input);
        System.out.println("####### :" +dbEntry.value);


    }
}
