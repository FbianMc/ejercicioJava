package com.desarrollo.Ejercicio.Java.service;

import com.desarrollo.Ejercicio.Java.repository.UserRepository;
import com.desarrollo.Ejercicio.Java.repository.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceImplTest {

    private MockMvc mockMvc;
    PodamFactory factory = new PodamFactoryImpl();
    @Mock
    private UserServiceImpl userServiceImpl;

    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userServiceImpl).build();
    }

    @Test
    public void getAllUserTest_AssertNotNull(){
        List<User> listUser = new ArrayList<>();
        listUser.add(new User());
        when(userServiceImpl.getAllUser()).thenReturn(listUser);
        assertNotNull(userServiceImpl.getAllUser());
    }

}
