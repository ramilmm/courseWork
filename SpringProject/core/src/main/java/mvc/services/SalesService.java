package mvc.services;

import mvc.common.Sales;
import mvc.repositories.GoodRepositoryCustom;
import mvc.repositories.SalesRepositoryCustom;
import mvc.repositories.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepositoryCustom salesRepositoryCustom;
    @Autowired
    private UserRepositoryCustom userRepositoryCustom;
    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;


    @Transactional
    public void add(Sales sale){
        if (salesRepositoryCustom.findByGood(sale.getGood()) == null) {
            salesRepositoryCustom.saveAndFlush(sale);
        }
    }

    @Transactional
    public void update(Sales sale){
        salesRepositoryCustom.save(sale);
    }

    @Transactional
    public void delete(Sales sale){
        salesRepositoryCustom.delete(sale);
    }


    public List<Sales> getById(Long id){
        return salesRepositoryCustom.findById(id);
    }

    public List<Sales> getByAdmin(Long id){
        return salesRepositoryCustom.findByAdmin(userRepositoryCustom.findById(id));
    }

    public Sales getByGood(Long id){
        return salesRepositoryCustom.findByGood(goodRepositoryCustom.findById(id));
    }

}
