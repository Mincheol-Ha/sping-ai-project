package com.example.demo.controller;

import com.example.demo.service.AiServiceRoleAssignmentPrompt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerRoleAssignmentPrompt {
  // ##### 필드 ##### 

  private final AiServiceRoleAssignmentPrompt aiService;

    public AiControllerRoleAssignmentPrompt(AiServiceRoleAssignmentPrompt aiService) {
        this.aiService = aiService;
    }

    //##### 메소드 #####
  @PostMapping(
    value = "/role-assignment",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.APPLICATION_NDJSON_VALUE     
  )
  public Flux<String> roleAssignment(@RequestParam("requirements") String requirements) {
    Flux<String> travelSuggestions = aiService.roleAssignment(requirements);
    return travelSuggestions;
  }  
}
