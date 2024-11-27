package com.soudivs.Pooduct.Service.Exception;

import org.aspectj.asm.IModelFilter;

public class ResourceNotFoundException extends RuntimeException{

    private String message;
    private String module;

    public ResourceNotFoundException(String message,String module)
    {
        super(message);
        this.message=message;
        this.module= module;
    }

}
