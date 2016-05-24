package server;

import common.DBOperationResponse;
import common.DBQuery;
import common.Factory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import leveldb.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryCommand extends SimpleChannelInboundHandler<DBQuery>{

    final static Logger logger = LoggerFactory.getLogger(QueryCommand.class);



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DBQuery msg) throws Exception {
        Reader reader = Factory.getReader();
        System.out.println(msg.getKey());
        String value = reader.get(msg.getKey());
        logger.info("Query returned:" + value);
        ctx.write(new DBOperationResponse(value));
        ctx.flush();

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
