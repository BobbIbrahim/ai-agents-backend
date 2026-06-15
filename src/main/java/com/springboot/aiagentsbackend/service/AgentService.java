package com.springboot.aiagentsbackend.service;

import com.springboot.aiagentsbackend.model.Agent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {

    private final List<Agent> agents = new ArrayList<>();
    private Long nextId = 1L;

    public AgentService() {
        agents.add(new Agent(nextId++, "AI Assistant", "Support", "Helps users answer questions"));
        agents.add(new Agent(nextId++, "Data Analyzer", "Analytics", "Analyzes data and generates insights"));
        agents.add(new Agent(nextId++, "Code Helper", "Development", "Assists developers with coding tasks"));
    }

    public List<Agent> getAllAgents() {
        return agents;
    }

    public Agent getAgentById(Long id) {
        return agents.stream()
                .filter(agent -> agent.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Agent createAgent(Agent agent) {
        agent.setId(nextId++);
        agents.add(agent);
        return agent;
    }

    public Agent updateAgent(Long id, Agent updatedAgent) {
        Agent existingAgent = getAgentById(id);

        if (existingAgent == null) {
            return null;
        }

        existingAgent.setName(updatedAgent.getName());
        existingAgent.setRole(updatedAgent.getRole());
        existingAgent.setDescription(updatedAgent.getDescription());

        return existingAgent;
    }

    public boolean deleteAgent(Long id) {
        return agents.removeIf(agent -> agent.getId().equals(id));
    }
}