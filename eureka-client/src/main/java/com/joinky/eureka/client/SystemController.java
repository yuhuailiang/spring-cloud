package com.joinky.eureka.client;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SystemController {

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("eureka-instance")
    public String getEurekaInstance(String applicationName) {
        if (null == applicationName || "".equals(applicationName)) {
            return "<p style='color:red'>请携带 applicationName 参数...</p>";
        }

        InstanceInfo instanceInfo;
        instanceInfo = eurekaClient.getNextServerFromEureka(applicationName, false);

        String actionTypeName = instanceInfo.getActionType().name();
        String appGroupName = instanceInfo.getAppGroupName();
        String hostname = instanceInfo.getHostName();
        String id = instanceInfo.getId();
        String instanceId = instanceInfo.getInstanceId();
        String ipAddr = instanceInfo.getIPAddr();
        String healthCheckUrl = instanceInfo.getHealthCheckUrl();
        String homePageUrl = instanceInfo.getHomePageUrl();

        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;

        ObjectNode objectNode = nodeFactory.objectNode();
        objectNode.put("actionTypeName", actionTypeName);
        objectNode.put("appGroupName", appGroupName);
        objectNode.put("hostname", hostname);
        objectNode.put("id", id);
        objectNode.put("instanceId", instanceId);
        objectNode.put("ipAddr", ipAddr);
        objectNode.put("healthCheckUrl", healthCheckUrl);
        objectNode.put("homePageUrl", homePageUrl);
        return objectNode.toString();
    }

    @RequestMapping("/getService/{type}")
    public String getService(@PathVariable String type) {
        return type + " >>>>>>>>这是需要访问的服务";
    }

    @RequestMapping("/hello")
    public String sayHello(){
        return "the service on prot: 8762 says hello!";
    }
}
