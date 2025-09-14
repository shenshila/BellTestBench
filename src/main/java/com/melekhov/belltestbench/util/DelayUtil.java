package com.melekhov.belltestbench.util;

import com.melekhov.belltestbench.mapper.OrderMapper;
import com.melekhov.belltestbench.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DelayUtil {
    private final DelayManager delayManager;

    public void applyDelay(String key) {
        int delay = delayManager.getDelay(key);
        if (delay > 0) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
