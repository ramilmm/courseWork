import mvc.common.UsersInfo;
import mvc.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    UserService service;

    @Before
    public void setUp(){
        UsersInfo user = new UsersInfo("ramilmmk@gmail.com","13523523twe","ramilmmk@gmail.com","Ramil","ROLE_ADMIN");
        service = mock(UserService.class);
        when(service.getByLogin("ramilmmk@gmail.com")).thenReturn(user);
    }

    @Test
    public void usernameTest(){
        UsersInfo user = service.getByLogin("ramilmmk@gmail.com");
        Assert.assertEquals("ramilmmk@gmail.com",user.getLogin());
    }

    @Test
    public void emailTest(){
        UsersInfo user = service.getByLogin("ramilmmk@gmail.com");
        Assert.assertEquals("ramilmmk@gmail.com",user.getEmail());
    }

    @Test
    public void nameTest(){
        UsersInfo user = service.getByLogin("ramilmmk@gmail.com");
        Assert.assertEquals("Ramil",user.getName());
    }

    @Test
    public void roleTest(){
        UsersInfo user = service.getByLogin("ramilmmk@gmail.com");
        Assert.assertEquals("ROLE_ADMIN",user.getRole());
    }

}
