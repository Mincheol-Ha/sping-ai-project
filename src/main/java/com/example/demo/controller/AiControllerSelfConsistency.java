package com.example.demo.controller;

import com.example.demo.service.AiServiceSelfConsistency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerSelfConsistency {
  // ##### 필드 ##### 

  private final AiServiceSelfConsistency aiService;

    public AiControllerSelfConsistency(AiServiceSelfConsistency aiService) {
        this.aiService = aiService;
    }

    // ##### 메소드 #####
  @PostMapping(
    value = "/self-consistency",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String selfConsistency(@RequestParam("content") String content) {
    String answer = aiService.selfConsistency(content);
    return answer;
  }  
}
