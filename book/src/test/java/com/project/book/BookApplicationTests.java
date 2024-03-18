package com.project.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.book.model.dto.BookRequest;
import com.project.book.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class BookApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");


	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private BookRepository bookRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void testSaveBook() throws Exception {
		BookRequest bookRequest = getBookRequest();
		String bookRequestAsString = objectMapper.writeValueAsString(bookRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/book/save")
						.contentType(MediaType.APPLICATION_JSON)
						.content(bookRequestAsString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, bookRepository.findAll().size());
	}

	private BookRequest getBookRequest() {
		return BookRequest.builder()
				.name("Content")
				.author("Content")
				.description("Desciption")
				.price(2500)
				.build();
	}

}
