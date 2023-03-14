package org.example;

import io.grpc.ServerBuilder;

import java.io.IOException;
import java.net.UnknownHostException;

public class GrpcServer {
    public static void main(String[] args) throws UnknownHostException {
        MyData.info();
        try {
            var server = ServerBuilder
                    .forPort(9000)
                    .addService(new HelloServiceImpl())
                    .build();

            server.start();
            while (true) Thread.sleep(100);
        } catch (IOException | InterruptedException e) {
            System.out.println("Server terminated");
        }
    }
}
