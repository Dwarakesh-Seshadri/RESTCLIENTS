package com.example.RESTCLIENTS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class RestclientsApplication {

	public static void main(String[] args) {
		// 1. Initialize modern RestClient
		RestClient restClient = RestClient.create();

		// 2. Prepare payload
		Message1 payload = new Message1("Hello from the external client!");

		System.out.println("Sending initial message to First Service via RestClient...");

		// 3. Fire the request over to Service One
		Message1 finalResponse = restClient.post()
				.uri("http://localhost:8081/forward")
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload)
				.retrieve()
				.body(Message1.class);

		System.out.println("Workflow Complete! Final server answer: " + finalResponse.message());
	}
	}


