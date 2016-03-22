package server;

import common.DBEntry;
import common.DBOperationResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import leveldb.Writer;

public class PutCommand extends SimpleChannelInboundHandler<DBEntry>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DBEntry msg) throws Exception {
        Writer writer = new Writer();
        DBOperationResponse add = writer.add(msg);
        System.out.println("\n#@#@ " + msg.value);
        ctx.write(add);
        ctx.flush();

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
