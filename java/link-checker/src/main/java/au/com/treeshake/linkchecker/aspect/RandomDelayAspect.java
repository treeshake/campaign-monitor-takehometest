package au.com.treeshake.linkchecker.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Aspect
@Component
public class RandomDelayAspect {

    private static final Logger LOG = LoggerFactory.getLogger(RandomDelayAspect.class);
    private static final int MAX_DELAY = 5000;
    private final Random random = new Random();

    @Around("execution(* au.com.treeshake.linkchecker.service.AsyncFetchUrlRestClientService.performHttpRequest(..))")
    public Object addRandomDelay(ProceedingJoinPoint joinPoint) throws Throwable {
        int delay = random.nextInt(MAX_DELAY); // Random delay between 0 and 3000 milliseconds
        LOG.info("Adding random delay of {} milliseconds", delay);
        Thread.sleep(delay);
        return joinPoint.proceed();
    }
}
