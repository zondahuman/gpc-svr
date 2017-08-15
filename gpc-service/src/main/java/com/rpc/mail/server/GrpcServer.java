package com.rpc.mail.server;

/**
 * Created by abin on 2017/8/2 18:33.
 * gpc-svr
 * com.rpc.mail.server
 */

import com.rpc.mail.service.SendMailServiceImpl;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws Exception {
        Server server = NettyServerBuilder.forPort(8080).addService(new SendMailServiceImpl()).build();
        server.start();
        System.out.println("server startup at 8080");
        server.awaitTermination();
    }
}

