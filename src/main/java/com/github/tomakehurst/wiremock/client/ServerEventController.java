package com.github.tomakehurst.wiremock.client;

import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

public class ServerEventController {
    private OutputStream out;

    public ServerEventController(OutputStream out) {
        this.out = out;
    }

    public void sendEvent(String event) {
        try {
            out.write(event.getBytes());
            out.flush();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            out.flush();
            out.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
