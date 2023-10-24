package com.hoaxvo.serversentevents.server.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class SSEServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/event-stream");
        response.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream out = response.getOutputStream();

        while (true) {
            String event = "data: " + new Date() + " uuid:" + UUID.randomUUID() + "\n\n"; // this last string is required because it tells client that server has stop sent event

            // Send the event to the client
            out.write(event.getBytes());
            out.flush();

            // Wait for 1 second before sending the next event
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}