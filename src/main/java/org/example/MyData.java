package org.example;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class MyData {
    static void info() throws UnknownHostException {
        System.out.println("Filip Wiśniewski, 260406");
        System.out.println("Szymon Bąk, 260431");
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM HH:mm:ss")));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
        System.out.println("Witaj w świecie Javy \uD83D\uDE00");
    }
}
