package com.rpc.mail.client;

/**
 * Created by abin on 2017/8/2 18:34.
 * gpc-svr
 * com.rpc.mail.client
 */
import java.util.concurrent.TimeUnit;

import com.rpc.mail.SendMailRequest;
import com.rpc.mail.SendMailResponse;
import com.rpc.mail.SendMailServiceGrpc;
import com.rpc.mail.SendMailServiceGrpc.SendMailServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = NettyChannelBuilder.forAddress("127.0.0.1", 8080).usePlaintext(true).build();
        //同步调用(异步调用的话，就是：SendMailServiceGrpc.newFutureStub(channel))
        SendMailServiceBlockingStub stub = SendMailServiceGrpc.newBlockingStub(channel);

        //设置请求参数
        SendMailRequest param = SendMailRequest.newBuilder().setRecipient("admin@google.com").setTitle("Email Title").setContent("This is email content").build();
        SendMailResponse resp = stub.sendMail(param);
        System.out.println(resp.getMsg() + "\t" + resp.getCode());

        //close
        channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }
}