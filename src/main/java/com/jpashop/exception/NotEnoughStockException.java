package com.jpashop.exception;

public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException(String msg) {
        super(msg);
    }
}