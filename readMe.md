# 客户端
1. ```ApplicationContext  getBean```方法获取```RpcProxyClient```类
2. ```RpcProxyClient```类动态代理获得需要调用的```servcie```，并把参数传进去
3. ```RemoteInvocationHandler``` 会封装请求信息到```RpcRequest```，然后```RpcNetTransport```发起远程```socket```调用远程接口
# 服务端
1. ```GpRpcServer```类死循环 通过```ServerSocket```监听端口，接收请求。 此类实现```ApplicationContextAware, InitializingBean```
通过重写```setApplicationContext``` 把类信息set到```handlerMap```里面去。
2. 收到的请求都交给```ProcessorHandler``` 线程池去处理业务
3. ```ProcessorHandler```是线程池管理的线程，拿到网络输入流之后。根据请求里面的信息，通过反射拿到实现类执行业务逻辑。
4. ```@RpcService``` 注解用来标记具体的实现类，在第一步就是用```applicationContext.getBeansWithAnnotation``` 扫描到所有的实现类