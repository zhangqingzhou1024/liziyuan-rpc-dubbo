[zk: localhost:2181(CONNECTED) 11] ls /dubbo/com.liziyuan.dubbo.demo.OrderService/providers
```text
[dubbo://192.168.1.9:20880/com.liziyuan.dubbo.demo.OrderService?anyhost=true&application=provider-service&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.liziyuan.dubbo.demo.OrderService&metadata-type=remote&methods=getOrder&pid=19560&release=3.0.3&service-name-mapping=true&side=provider&timestamp=1714144945493, 
 dubbo://192.168.1.9:20881/com.liziyuan.dubbo.demo.OrderService?anyhost=true&application=provider-service&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.liziyuan.dubbo.demo.OrderService&metadata-type=remote&methods=getOrder&pid=21400&release=3.0.3&service-name-mapping=true&side=provider&timestamp=1714145436818]```



[zk: localhost:2181(CONNECTED) 12] ls /dubbo/com.liziyuan.dubbo.demo.OrderService/consumers
```text
[dubbo://192.168.1.9/com.liziyuan.dubbo.demo.OrderService?application=comsumer-service&category=consumers&check=false&dubbo=2.0.2&getOrder.return=true&getOrder.sent=true&getOrder.timeout=5000&interface=com.liziyuan.dubbo.demo.OrderService&metadata-type=remote&methods=getOrder&pid=8624&qos.enable=false&release=3.0.3&side=consumer&sticky=false&timestamp=1714145010470]
```
