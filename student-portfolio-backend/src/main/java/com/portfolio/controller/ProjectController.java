package com.portfolio.controller;

import com.portfolio.entity.Project;
import com.portfolio.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setTitle(updatedProject.getTitle());
        project.setDescription(updatedProject.getDescription());
        project.setTechStack(updatedProject.getTechStack());
        project.setStatus(updatedProject.getStatus());
        project.setGithubUrl(updatedProject.getGithubUrl());
        project.setDemoUrl(updatedProject.getDemoUrl());
        project.setMediaUrl(updatedProject.getMediaUrl());
        project.setStudentId(updatedProject.getStudentId());

        return projectRepository.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }
}
