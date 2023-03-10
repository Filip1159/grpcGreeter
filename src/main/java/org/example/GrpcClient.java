package org.example;

import io.grpc.ManagedChannelBuilder;
import org.example.grpc.HelloRequest;
import org.example.grpc.HelloServiceGrpc;

import java.util.Scanner;

public class GrpcClient {
    public static void main(String[] args) {
        var channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj swoje imię: ");
            var firstName = scanner.nextLine();
            if (shouldExit(firstName)) break;

            System.out.print("Podaj nazwisko: ");
            var lastName = scanner.nextLine();
            if (shouldExit(lastName)) break;

            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

            var helloResponse = stub.hello(HelloRequest.newBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .build());

            System.out.println(helloResponse);

        }
        channel.shutdown();
    }

    private static boolean shouldExit(String input) {
        return input.equalsIgnoreCase("exit") || input.isBlank();
    }
}
