package org.example.systemdesign.loadbalancer;

import java.util.List;

public class WeightedRoundRobin {

    List<String> servers;
    List<Integer> weights;
    private int currentIndex;
    private int currentWeight;

    public WeightedRoundRobin(List<String> servers, List<Integer> weights) {
        this.servers = servers;
        this.weights = weights;
        this.currentIndex = -1;
        this.currentWeight = 0;
    }

    public String getNextServer() {
        while (true) {
            this.currentIndex = (this.currentIndex + 1) % servers.size();
            if (currentIndex == 0) {
                this.currentWeight--;
                if (currentWeight <= 0) {
                    currentWeight = getMaxWeight();
                }
            }
            if (weights.get(currentIndex) >= currentWeight) {
                return servers.get(currentIndex);
            }
        }
    }

    private int getMaxWeight() {
        return weights.stream().max(Integer::compare).orElse(0);
    }

    public static void main(String[] args) {
        List<String> servers = List.of("server1", "server2", "Server3");
        List<Integer> weights = List.of(5, 1, 1);
        WeightedRoundRobin weightedRoundRobinLB = new WeightedRoundRobin(servers, weights);
        for (int i = 0; i < 6; i++) {
            System.out.println("Server : " + weightedRoundRobinLB.getNextServer());
        }
    }

}
