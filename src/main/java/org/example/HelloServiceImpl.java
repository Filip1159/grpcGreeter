package org.example;

import org.example.grpc.HelloResponse;
import org.example.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.example.grpc.HelloServiceGrpc.HelloServiceImplBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = "Hello, " + request.getFirstName() + " " + request.getLastName();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM HH:mm:ss")))
                .build();

        System.out.println("Responding to request: " + request.getFirstName() + " " + request.getLastName());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
