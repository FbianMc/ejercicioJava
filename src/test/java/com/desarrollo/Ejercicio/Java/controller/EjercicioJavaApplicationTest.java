package com.desarrollo.Ejercicio.Java.controller;

import com.desarrollo.Ejercicio.Java.repository.UserRequest;
import com.desarrollo.Ejercicio.Java.repository.UserResponse;
import com.desarrollo.Ejercicio.Java.repository.entity.User;
import com.desarrollo.Ejercicio.Java.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EjercicioJavaApplicationTest {
	private MockMvc mockMvc;
	PodamFactory factory = new PodamFactoryImpl();

	@Mock
	private UserController userController;
	@Mock
	private UserService userService;

	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void CreateUserTest_OKAssertEqualsCREATED() throws Exception {
		UserRequest user = factory.manufacturePojo(UserRequest.class) ;
		ResponseEntity<UserResponse> responseEntity = userController.createUser(user);
		assertEquals(HttpStatus.CREATED ,responseEntity.getStatusCode());
	}

	@Test
	public void listarUserTest_AssertNotNull(){
		List<User> listUser = new ArrayList<>();
		listUser.add(new User());
		when(userService.getAllUser()).thenReturn(listUser);
		assertNotNull(userController.getAllUser());
	}

	@Test
	public void getAllUserTest_AssertEquals(){
		List<User> listUser = new ArrayList<>();
		listUser.add(new User());
		when(userService.getAllUser()).thenReturn(listUser);
		ResponseEntity<List<User>> responseEntity = userController.getAllUser();
		assertEquals(HttpStatus.OK ,responseEntity.getStatusCode());
	}
}
