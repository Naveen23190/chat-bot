package com.jsp.chatbot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.chatbot.service.AiService;


@RestController
//@AllArgsConstructor
public class AiController 
{
	@Autowired
	private AiService aiService;
	
	@PostMapping(value = "/chat")
	
    public String ask(@RequestBody String userText)
	{
		return aiService.invokeGeminiModel(userText);
	}
}
