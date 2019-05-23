package com.mercury.mallproject.common.id;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;


public final class DefaultIdGenerator implements IdGenerator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultIdGenerator.class);
	
    public static final long EPOCH;
    
    private static final long SEQUENCE_BITS = 12L;
    
    private static final long WORKER_ID_BITS = 10L;
    
    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;
    
    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;
    
    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;
    
    private static final long WORKER_ID_MAX_VALUE = 1L << WORKER_ID_BITS;
    
    private static TimeService timeService = new TimeService();
    
    private static long workerId = Long.parseLong(System.getProperty("idGenerator.worker", "1"));
    
    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
    }
    
    private static DefaultIdGenerator instance = new DefaultIdGenerator();
    
    
    private long sequence;
    
    private long lastTime;
    
    /**
     * Set work process id.
     * 
     * @param workerId work process id
     */
    public static void setWorkerId(final long workerId) {
        Preconditions.checkArgument(workerId >= 0L && workerId < WORKER_ID_MAX_VALUE);
        DefaultIdGenerator.workerId = workerId;
    }
    
    public static DefaultIdGenerator getInstance(){
    	return instance;
    }
    
    /**
     * Generate key.
     * 
     * @return key type is @{@link Long}.
     */
    @Override
    public synchronized Long generateId() {
        long currentMillis = timeService.getCurrentMillis();
        try {
			Preconditions.checkState(lastTime <= currentMillis, "Clock is moving backwards, last time is %d milliseconds, current time is %d milliseconds", lastTime, currentMillis);
		} catch (Exception e) {
			LOGGER.error("Error Occured!", e);
			try {
				Thread.sleep(lastTime - currentMillis);
			} catch (InterruptedException e1) {
				
			}
		}
        if (lastTime == currentMillis) {
            if (0L == (sequence = ++sequence & SEQUENCE_MASK)) {
                currentMillis = waitUntilNextTime(currentMillis);
            }
        } else {
            sequence = 0;
        }
        lastTime = currentMillis;
        return ((currentMillis - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (workerId << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }
    
    private long waitUntilNextTime(final long lastTime) {
        long time = timeService.getCurrentMillis();
        while (time <= lastTime) {
            time = timeService.getCurrentMillis();
        }
        return time;
    } 
    
}
