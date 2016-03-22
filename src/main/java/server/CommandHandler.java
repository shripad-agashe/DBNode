package server;

import common.DBEntry;
import common.DBOperationResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class CommandHandler extends SimpleChannelInboundHandler<DBEntry> {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.write(new DBOperationResponse("hi there"));
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DBEntry msg) throws Exception {
        ctx.write(new DBOperationResponse("hi there"));
        System.out.println("\nAdded data in Handler:" + msg.value);

    }
}
