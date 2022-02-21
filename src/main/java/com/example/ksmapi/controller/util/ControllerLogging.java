package com.example.ksmapi.controller.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
@Slf4j
public class ControllerLogging {
    public static void logRequestSource(final HttpServletRequest request, final Class aClass) {
        String requestUserHost = String.format("Request user: %s, Request host: %s | Controller: %s",
                request.getRemoteUser(), request.getRemoteHost(), aClass.getSimpleName());
        String requestIPnPort = String.format("Request IP: %s, Request port: %s | Controller : %s",
                request.getRemoteAddr(), request.getRemotePort(), aClass.getSimpleName());
        log.info(requestUserHost);
        log.info(requestIPnPort);
    }
}
