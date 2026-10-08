package com.jsp.chatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class AiService 
{
	Client client;
	
	public AiService(
			@Value(value = "google.apikey")
			String apiKey)
	{
          this.client = Client.builder()
        		  .apiKey("AQ.Ab8RN6ID_jS1QYZqsrx7Sur0aDJR99WFMc-QbrldqglFQpRATQ")
        		  .build();
	}
	
	public String invokeGeminiModel(String userText) 
	{
		String Prompt = """
				 You are a helpful AI Teacher ,
				 
				 Answer The Following Question In Simple Language 
				 so that a beginner can exactly understand it.
				 
				 Question:
				 %s
				""".formatted(userText);
		GenerateContentResponse response = 
		client.models
		.generateContent("gemini-3.5-flash-lite",userText,null);
		return response.text();
	}
}

// Gemini API Key : AQ.Ab8RN6ID_jS1QYZqsrx7Sur0aDJR99WFMc-QbrldqglFQpRATQ