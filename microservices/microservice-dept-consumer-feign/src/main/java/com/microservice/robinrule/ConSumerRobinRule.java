package com.microservice.robinrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class ConSumerRobinRule extends AbstractLoadBalancerRule {

    private int total = 0;

    private int index = 0;

    private final int MAX_COUNTS = 5;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }



                if(total>=MAX_COUNTS){
                    index ++;
                    total = 0;
                }

                if(index>=upList.size()){
                    index =0;
                }

                //int index = this.rand.nextInt(serverCount);
                server = (Server) upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        total ++;
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    @Override
    public Server choose(Object o) {
        return this.choose(getLoadBalancer(),o);
    }
}
