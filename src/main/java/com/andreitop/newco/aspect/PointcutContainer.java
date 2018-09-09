package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {
    }

    @Pointcut("within(com.andreitop.newco.controller.*)")
    public void controllerFind(){
    }

    @Pointcut("this(com.andreitop.newco.repository..TripRepository)")
    public void thisFind(){
    }

    @Pointcut("execution( * com.andreitop.newco.controller.*Controller.find*())")
    public void controllerFindAll(){
    }
}
