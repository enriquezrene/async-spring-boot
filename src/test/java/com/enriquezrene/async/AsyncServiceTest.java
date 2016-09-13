package com.enriquezrene.async;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;

/**
 * Created by rene on 13/09/16.
 */
public class AsyncServiceTest {

    private static final int TWO_SECONDS = 2;

    @Test
    public void theProcessingTakesAtLeastTwoSeconds() throws Exception {
        long timeStartProcessingInSecondsInMiliseconds = new Date().getTime();
        new AsyncService().process(null, new DeferredResult<>());
        long timeEndProcessingInMiliseconds= new Date().getTime();
        int processingTime = (int) ((timeEndProcessingInMiliseconds - timeStartProcessingInSecondsInMiliseconds) / 1000);
        Assert.assertTrue(processingTime > TWO_SECONDS);
    }

    @Test
    public void onNullMessageAnEmptyStringIsUsed() throws Exception {
        DeferredResult<String> result = new DeferredResult<>();
        new AsyncService().process(null, result);
        Assert.assertEquals(result.getResult(), "");
    }
}
