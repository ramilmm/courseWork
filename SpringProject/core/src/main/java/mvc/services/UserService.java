package mvc.services;

import mvc.common.UsersInfo;
import mvc.repositories.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;


    @Transactional
    public void add(UsersInfo usersInfo){
        userRepositoryCustom.saveAndFlush(usersInfo);
    }
    @Transactional
    public void update(UsersInfo usersInfo){ userRepositoryCustom.saveAndFlush(usersInfo);}
    @Transactional
    public void delete(UsersInfo usersInfo) {
        userRepositoryCustom.delete(usersInfo);
    }
    @Transactional
    public void deleteById(Long id){
        userRepositoryCustom.delete(userRepositoryCustom.findById(id));
    }
    @Transactional
    public UsersInfo getById(Long id){
        return userRepositoryCustom.findById(id);
    }
    @Transactional
    public UsersInfo getByLogin(String login){
        return userRepositoryCustom.findByLogin(login);
    }
}
