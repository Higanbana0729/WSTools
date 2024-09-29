package com.tools.wstools.db;

import com.tools.wstools.db.user.entity.User;
import com.tools.wstools.db.user.mapper.UserMapper;
import com.tools.wstools.db.user.service.UserService;
import com.tools.wstools.db.user.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * @author zp
 * @date 2024/9/29 17:16
 */
public class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);
        user.setEmail("john.doe@example.com");

        when(userMapper.insert(user)).thenReturn(1);

        boolean result = userService.addUser(user);

        verify(userMapper, times(1)).insert(user);
        Assertions.assertTrue(result);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Jane Doe");
        user.setAge(28);
        user.setEmail("jane.doe@example.com");

        when(userMapper.update(user)).thenReturn(1);

        boolean result = userService.updateUser(user);

        verify(userMapper, times(1)).update(user);
        Assertions.assertTrue(result);
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;

        when(userMapper.delete(userId)).thenReturn(1);

        boolean result = userService.deleteUser(userId);

        verify(userMapper, times(1)).delete(userId);
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setAge(30);
        user.setEmail("john.doe@example.com");

        when(userMapper.selectById(1L)).thenReturn(user);

        User result = userService.getUser(1L);

        verify(userMapper, times(1)).selectById(1L);
        Assertions.assertEquals("John Doe", result.getName());
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setName("John Doe");
        user1.setAge(30);
        user1.setEmail("john.doe@example.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Jane Doe");
        user2.setAge(28);
        user2.setEmail("jane.doe@example.com");

        userList.add(user1);
        userList.add(user2);

        when(userMapper.selectAll()).thenReturn(userList);

        List<User> result = userService.getAllUsers();

        verify(userMapper, times(1)).selectAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
    }
}