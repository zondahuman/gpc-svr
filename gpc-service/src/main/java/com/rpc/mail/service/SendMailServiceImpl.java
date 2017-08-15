package com.rpc.mail.service;

/**
 * Created by abin on 2017/8/2 18:32.
 * gpc-svr
 * com.rpc.mail.service
 */

import com.rpc.mail.SendMailRequest;
import com.rpc.mail.SendMailResponse;
import com.rpc.mail.SendMailServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SendMailServiceImpl extends SendMailServiceGrpc.SendMailServiceImplBase {
    public void sendMail(SendMailRequest request, StreamObserver<SendMailResponse> responseObserver) {
        System.out.println(request.getRecipient() + "\t" + request.getTitle() + "\t" + request.getContent());
        //这里是具体的业务逻辑
        SendMailResponse resp = SendMailResponse.newBuilder().setCode(0).setMsg("OK").build();
        //设置返回结果
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}