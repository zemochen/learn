package org.zemo.concert.aspect;

import org.aspectj.lang.annotation.*;

/**
 * @ClassName: Audience
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 01/10/2016 17:57
 * @Description ${TODO}
 */
@Aspect
public class Audience {
    @Pointcut("execution(* org.zemo.concert.Performance.perform(..))")
    public void performance(){}

    @Before("performance")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP! CLAP! CLAP!");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }
}
