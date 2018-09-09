package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution( * com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {
    }

    @Pointcut("within(com.andreitop.newco.repository.*Repository.save*)")
    public void repositorySave(){
    }

    @Pointcut("execution( * com.andreitop.newco.repository.*Repository.update*()))")
    public void repositoryUpdate(){
    }


}
