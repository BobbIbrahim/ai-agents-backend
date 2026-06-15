package com.springboot.aiagentsbackend.service;

import com.springboot.aiagentsbackend.exception.ResourceNotFoundException;
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
        return agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent with id " + id + " was not found")); //404
    }

    public Agent createAgent(Agent agent) {
        agent.setId(null);
        return agentRepository.save(agent);
    }

    public Agent updateAgent(Long id, Agent updatedAgent) {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent with id " + id + " was not found")); //404

        existingAgent.setName(updatedAgent.getName());
        existingAgent.setRole(updatedAgent.getRole());
        existingAgent.setDescription(updatedAgent.getDescription());

        return agentRepository.save(existingAgent);
    }

    public void deleteAgent(Long id) {
        if (!agentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Agent with id " + id + " was not found"); //404
        }

        agentRepository.deleteById(id); // 204 no content
    }
}
