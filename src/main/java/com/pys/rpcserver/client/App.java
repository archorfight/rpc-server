package com.pys.rpcserver.client;

import com.pys.rpcserver.api.IHelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*RpcProxyClient rpcProxyClient=new RpcProxyClient();

        IHelloService iHelloService=rpcProxyClient.clientProxy
                (IHelloService.class,"localhost",8080);

        String result=iHelloService.sayHello("Mic");
        System.out.println(result);*/

        ApplicationContext context=new
                AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient=context.getBean(RpcProxyClient.class);

        IHelloService iHelloService=rpcProxyClient.clientProxy
                (IHelloService.class,"localhost",8080);
        iHelloService.sayHello("hello");
        /*IPaymentService iPaymentService=rpcProxyClient.clientProxy(IPaymentService.class,
                "localhost",8080);

        iPaymentService.doPay();*/
    }
}
