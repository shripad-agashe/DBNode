package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import common.DBEntry;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class CommandDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("In Decoder");

        byte[] bytes = new byte[in.readableBytes()];

        ByteBuf byteBuf = in.readBytes(in.readableBytes());


        Kryo kryo = new Kryo();
        kryo.register(DBEntry.class,new JavaSerializer());
        Input input = new Input(byteBuf.array());
//
//        if (in.readableBytes() < 2)
//            return;
//
//        in.markReaderIndex();
//
//        int len = in.readUnsignedShort();
//
//        if (in.readableBytes() < len) {
//            in.resetReaderIndex();
//            return;
//        }
//
//        byte[] buf = new byte[len];
//        in.readBytes(buf);
//        Input input = new Input(byteBuf.getByte(0));
        DBEntry dbEntry = kryo.readObject(input, DBEntry.class);
        out.add(dbEntry);
    }
}
