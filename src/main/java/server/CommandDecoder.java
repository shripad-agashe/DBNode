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

//        byte[] bytes = new byte[in.readableBytes()];

//        ByteBuf byteBuf = in.readBytes(in.readableBytes());


        Kryo kryo = new Kryo();
        kryo.register(DBEntry.class,new JavaSerializer());
//
        int i = in.readableBytes();
        if (i < 2)
            return;
//
//        in.markReaderIndex();
//        System.out.println("@@@@@@@@@@@@: " + in.readerIndex());
//
//
//        int len = in.readUnsignedShort();
//        System.out.println("@@@@@@@@@@@@: " + in.writerIndex());
//
//        System.out.println("############## " + len);
//        System.out.println("############## " + i);
//
//        if (i < len && i < in.writerIndex()) {
//            in.resetReaderIndex();
//            return;
//        }


//
        byte[] buf = new byte[i];
        in.readBytes(buf);
        Input input = new Input(buf);
        DBEntry dbEntry;
        dbEntry = (DBEntry) kryo.readClassAndObject(input);
        System.out.println("####### :" +dbEntry.value);
        out.add(dbEntry);
    }
}
