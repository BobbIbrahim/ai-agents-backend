package com.springboot.aiagentsbackend.controller;

import com.springboot.aiagentsbackend.model.Agent;
import com.springboot.aiagentsbackend.service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    @GetMapping("/{id}")
    public Agent getAgentById(@PathVariable Long id) {
        return agentService.getAgentById(id);
    }

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

    @PutMapping("/{id}")
    public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agent) {
        return agentService.updateAgent(id, agent);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAgent(@PathVariable Long id) {
        return agentService.deleteAgent(id);
    }
}