package server;

import common.DBOperationResponse;
import common.DBQuery;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import leveldb.Reader;

public class QueryCommand extends SimpleChannelInboundHandler<DBQuery>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DBQuery msg) throws Exception {
        Reader reader = new Reader();
        System.out.println(msg.getKey());
        String value = reader.get(msg.getKey());
        ctx.write(new DBOperationResponse(value));
        ctx.flush();

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
