package com.group.consult.commerce.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 请求日志
 */
@Component
@Order(100)
@Slf4j
public class RequestLogFilter extends AbstractRequestLoggingFilter {

    public RequestLogFilter() {
        super();
        super.setIncludeHeaders(true);
        super.setIncludeClientInfo(true);
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(10240);
        super.setBeforeMessagePrefix("");
        super.setBeforeMessageSuffix("");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest requestToUse = request;
        if (!(request instanceof ContentCachingRequestWrapper)) {
            requestToUse = new ContentCachingRequestWrapper(request);
        }

        HttpServletResponse responseToUse = response;
        if (!(response instanceof ContentCachingResponseWrapper)) {
            responseToUse = new ContentCachingResponseWrapper(response);
        }

        super.doFilterInternal(requestToUse, responseToUse, filterChain);

       logResponse(responseToUse);
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info(message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        log.info(message);
    }

    private void logResponse(HttpServletResponse response) throws IOException {
        if (response instanceof ContentCachingResponseWrapper) {
            ContentCachingResponseWrapper responseWrapper = (ContentCachingResponseWrapper) response;
            if (isLogResponse(responseWrapper)) {

                String content = new String(responseWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
                log.info("Response:{},charset={}", content, responseWrapper.getCharacterEncoding());
            }
            responseWrapper.copyBodyToResponse();
        }
    }

    private boolean isLogResponse(HttpServletResponse response) {
        String contentType = response.getContentType();
        if (StringUtils.isNotEmpty(contentType) && StringUtils.contains(contentType, "json")) {
            return true;
        }
        return false;
    }
}
