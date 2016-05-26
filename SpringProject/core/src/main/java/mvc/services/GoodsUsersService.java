package mvc.services;

import mvc.common.Goods_users;
import mvc.common.UsersInfo;
import mvc.repositories.Goods_usersRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsUsersService {

    @Autowired
    private Goods_usersRepositoryCustom goods_users;


    @Transactional
    public void add(Goods_users g_u){
        List<Goods_users> list = goods_users.findByUsersInfo(g_u.getUsersInfo());
        for (Goods_users gu : list){
            if (gu.getUsersInfo().getId().equals(g_u.getUsersInfo().getId())){
                return;
            }
        }
        goods_users.saveAndFlush(g_u);
    }

    @Transactional
    public void delete(Goods_users g_u){
        goods_users.delete(g_u);
    }

    public List<Goods_users> getByUser(UsersInfo user){
        return goods_users.findByUsersInfo(user);
    }

}
