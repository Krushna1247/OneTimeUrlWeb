package com.qt.sid.bdd.utils;

import java.util.concurrent.Callable;

public class RetryAnalyser {
    public static <T> T retry(int maxRetries, Callable<T> task) throws Exception {
        int retryCount = 0;
        while (true) {
            try {
                return task.call();
            } catch (Exception e) {
                retryCount++;
                if (retryCount >= maxRetries) {
                    throw e;
                }
                // You can adjust the delay between retries as needed
                Thread.sleep(1000); // Wait for 1 second before retrying
            }
        }
    }
}
