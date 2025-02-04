package org.example.systemdesign.loadbalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobin {
    private List<String> servers;
    private AtomicInteger index;

    public RoundRobin(List<String> servers) {
        this.servers = servers;
        this.index = new AtomicInteger(-1) ;
    }

    public String getNextServer(){
        int currentIndex = index.getAndIncrement() % servers.size();
        return servers.get(currentIndex);
    }

    public static void main(String[] args) {
        List<String> servers = List.of("server1", "server2", "Server3");
        RoundRobin roundRobinLB = new RoundRobin(servers);
        for(int i = 0; i <6 ; i++){
            System.out.println("Server : "+ roundRobinLB.getNextServer());
        }
    }
}
