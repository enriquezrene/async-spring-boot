package com.enriquezrene.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by rene on 13/09/16.
 */
@Component
public class AsyncService {

    @Async
    public void process(String message, DeferredResult<String> result) {
        result.setResult(processMessage(message));
    }

    public String processMessage(String message) {
        try {
            Thread.sleep(3000L);
            if (message == null) {
                message = "";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message.toUpperCase();
    }
}
