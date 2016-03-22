package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferOutputStream;
import com.esotericsoftware.kryo.io.Output;
import common.DBOperationResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CommandEncoder extends MessageToByteEncoder<DBOperationResponse> {
    @Override
    protected void encode(ChannelHandlerContext ctx, DBOperationResponse msg, ByteBuf out) throws Exception {
        ByteBufferOutputStream bos = new ByteBufferOutputStream();
        Output output = new Output(bos);
        Kryo kryo = new Kryo();
        kryo.writeObject(output,msg);

        System.out.printf("Going back to client:" + msg.getResponse());
        out.writeBytes(output.getBuffer());
        ctx.flush();
    }
}
