package com.enriquezrene.controller;

import com.enriquezrene.async.AsyncService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;


/**
 * Created by rene on 13/09/16.
 */
@RestController
public class AsyncEndpoint {

    @Autowired
    AsyncService asyncService;

    private static Logger LOG = Logger.getLogger(AsyncEndpoint.class);

    @RequestMapping(path = "/deferred-approach", method = RequestMethod.POST)
    public DeferredResult<String> process(@RequestBody String message) {
        DeferredResult<String> response = new DeferredResult<>();
        asyncService.process(message, response);
        LOG.info("---> Task started with: " + message);
        return response;
    }

    @RequestMapping(path = "/callable-approach", method = RequestMethod.POST)
    public Callable<String> processTask(final @RequestBody String message) {
        Callable<String> response = () -> asyncService.processMessage(message);
        return response;
    }

    @RequestMapping(path="/web-async-approach", method=RequestMethod.POST)
    public WebAsyncTask<String> processWebTask(final @RequestBody String message) {
        Callable<String> response = () -> asyncService.processMessage(message);
        WebAsyncTask<String> task = new WebAsyncTask<>(response);
        return task;
    }
}
