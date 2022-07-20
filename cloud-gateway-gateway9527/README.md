Gateway的三大核心概念
    1.  Route路由
    路由是构建网关的基本模块，它由ID，目标URI，一些列的断言和过滤器组成，如果断言为true则匹配该路由。
    路由转发：
    发送请求调用微服务时，负载均衡分派到微服务之前，会经过网关。
    具体分派到哪个微服务，要符合网关的路由转发规则，才能转发到指定微服务

    2.  Predicate断言
    参考的是Java8的java.util.function.Predicate
    开发人员可以匹配HTTP请求中的所有内容（例如请求头或请求参数），如果请求与断言相匹配则进行路由。

    3.  Filter过滤
    指的是Spring框架中GatewayFliter的实例，使用过滤器，可以在请求被路由前或者之后对请求进行修改。
    处理请求前和处理请求后都可能有Filter

    4.  总体流程
    核心逻辑：路由转发+执行过滤器链

    指的是Spring框架中GatewayFilter的实例，使用过滤器，可以在请求被路由前或者之后对请求进行修改。
    Filter链：同时满足一系列的过滤链。
    路由过滤器可用于修改进去的HTTP请求和返回的HTTP响应，路由过滤器只能指定路由进行使用。
    SpringCloudGateway内置了多种路由过滤器，他们都由GatewayFilter的工厂类产生。

        1.  生命周期
        pre
        post

        2.  种类
        单一的：GatewayFilter
        全局的：GlobalFilter

        3.  自定义过滤器
        两个主要接口介绍：implements GlobalFilter, Ordered
        定义一个全局过滤器
