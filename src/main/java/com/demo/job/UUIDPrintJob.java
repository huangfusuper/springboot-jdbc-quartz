package com.demo.job;

import java.util.UUID;

/**
 * @author huangfu
 */
public class UUIDPrintJob {
    public void print(){
        System.out.println(UUID.randomUUID().toString());
    }
}
