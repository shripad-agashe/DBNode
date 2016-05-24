package server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferOutputStream;
import com.esotericsoftware.kryo.io.Output;
import common.DBOperationResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class CommandEncoder extends MessageToByteEncoder<DBOperationResponse> {

    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(CommandEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, DBOperationResponse msg, ByteBuf out) throws Exception {
        ByteBufferOutputStream bos = new ByteBufferOutputStream();
        Output output = new Output(bos);
        Kryo kryo = new Kryo();
        kryo.writeObject(output,msg);

        LOGGER.debug("Going back to client:" + msg.getResponse());
        System.out.printf("Going back to client:" + msg.getResponse());

        out.writeBytes(output.getBuffer());
    }
}
