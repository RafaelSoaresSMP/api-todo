package com.apitodo.todo;

import com.apitodo.todo.models.TaskModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.config.Task;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class ToDoApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateSucess() {
		TaskModel task = new TaskModel("teste task", "descricao teste", false, 3);
		webTestClient.post().uri("/tasks").bodyValue(task).exchange().expectStatus().isOk();
	}

}
