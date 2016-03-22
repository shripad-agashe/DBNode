package server;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

public class CommandObject extends DelimiterBasedFrameDecoder {

    public CommandObject(int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);
    }
}
