package com.springboot.aiagentsbackend.service;

import com.springboot.aiagentsbackend.model.Agent;
import com.springboot.aiagentsbackend.repository.AgentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @PostConstruct
    public void seedData() {
        if (agentRepository.count() == 0) {
            agentRepository.save(new Agent("AI Assistant", "Support", "Helps users answer questions"));
            agentRepository.save(new Agent("Data Analyzer", "Analytics", "Analyzes data and generates insights"));
            agentRepository.save(new Agent("Code Helper", "Development", "Assists developers with coding tasks"));
        }
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElse(null);
    }

    public Agent createAgent(Agent agent) {
        agent.setId(null);
        return agentRepository.save(agent);
    }

    public Agent updateAgent(Long id, Agent updatedAgent) {
        Agent existingAgent = agentRepository.findById(id).orElse(null);

        if (existingAgent == null) {
            return null;
        }

        existingAgent.setName(updatedAgent.getName());
        existingAgent.setRole(updatedAgent.getRole());
        existingAgent.setDescription(updatedAgent.getDescription());

        return agentRepository.save(existingAgent);
    }

    public boolean deleteAgent(Long id) {
        if (!agentRepository.existsById(id)) {
            return false;
        }

        agentRepository.deleteById(id);
        return true;
    }
}