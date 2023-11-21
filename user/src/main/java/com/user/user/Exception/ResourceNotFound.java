package com.user.user.Exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){
        super("Resource Not Found!!!");
        }

    public ResourceNotFound(String message){
        super(message);
    }
}
