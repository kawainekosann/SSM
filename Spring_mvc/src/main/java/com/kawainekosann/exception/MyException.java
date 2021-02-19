package com.kawainekosann.exception;

public class MyException extends Exception{
    //用详细信息指定一个异常
    public MyException(String message){
        super(message);
    }
}
