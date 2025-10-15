package com.example.demo.controller;

import com.example.demo.service.AiServiceZeroShotPrompt;
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
public class AiControllerZeroShotPrompt {
  // ##### 필드 ##### 

  private final AiServiceZeroShotPrompt aiService;

    public AiControllerZeroShotPrompt(AiServiceZeroShotPrompt aiService) {
        this.aiService = aiService;
    }

    //##### 메소드 #####
  @PostMapping(
    value = "/zero-shot-prompt",
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE
  )
  public String zeroShotPrompt(@RequestParam("review") String review) {
    String reviewSentiment = aiService.zeroShotPrompt(review);
    return reviewSentiment;
  }  
}
