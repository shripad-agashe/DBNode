package server;

import common.DBEntry;
import common.DBOperationResponse;
import common.Factory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import leveldb.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutCommand extends SimpleChannelInboundHandler<DBEntry>{
    final static Logger logger = LoggerFactory.getLogger(PutCommand.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DBEntry msg) throws Exception {
        Writer writer = Factory.getWriter();
        DBOperationResponse add = writer.add(msg);
        logger.info("Adding to database:" + msg.value);
        ctx.write(add);
        ctx.flush();

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
