package mvc.services;

import mvc.common.GoodInfo;
import mvc.common.Goods_users;
import mvc.common.UsersInfo;
import mvc.repositories.GoodRepositoryCustom;
import mvc.repositories.Goods_usersRepositoryCustom;
import mvc.repositories.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;
    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;
    @Autowired
    private Goods_usersRepositoryCustom goods_users;

    @Transactional
    public void add(UsersInfo usersInfo) {
        userRepositoryCustom.saveAndFlush(usersInfo);
    }

    @Transactional
    public void update(UsersInfo usersInfo) {
        userRepositoryCustom.saveAndFlush(usersInfo);
    }

    @Transactional
    public void delete(UsersInfo usersInfo) {
        userRepositoryCustom.delete(usersInfo);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepositoryCustom.delete(userRepositoryCustom.findById(id));
    }

    @Transactional
    public UsersInfo getById(Long id) {
        return userRepositoryCustom.findById(id);
    }

    @Transactional
    public UsersInfo getByLogin(String login) {
        return userRepositoryCustom.findByLogin(login);
    }

    public List<UsersInfo> getAll(){ return userRepositoryCustom.findAll(); }

    /*
    * lor - List of Recommendations
    * */
    @Transactional
    public List<GoodInfo> getRecomendations(Long userId) {
        List<GoodInfo> result = new ArrayList<GoodInfo>();
        List<Goods_users> user_books = goods_users.findByUsersInfo(userRepositoryCustom.findById(userId));
        /*
        * Sorting by Category
        */
        Map<Integer, Integer> CategoryRating = new HashMap<Integer, Integer>();
        for (Goods_users user_book : user_books) {
            if (CategoryRating.containsKey(user_book.getGoodInfo().getCategory().getId().intValue())) {
                CategoryRating.put(user_book.getGoodInfo().getCategory().getId().intValue(), CategoryRating.get(user_book.getGoodInfo().getCategory().getId().intValue()) + 1);
            } else {
                CategoryRating.put(user_book.getGoodInfo().getCategory().getId().intValue(), 1);
            }
        }

        Integer maxValue = 0;
        Integer categoryId = 0;
        for (Map.Entry map : CategoryRating.entrySet()) {
            if ((Integer) map.getValue() > maxValue) {
                maxValue = (Integer) map.getValue();
                categoryId = (Integer) map.getKey();
            }
        }
        /*
        * Sorting by Author
        * */
        Map<String, Integer> AuthorRating = new HashMap<String, Integer>();
        for (Goods_users user_book : user_books) {
            if (AuthorRating.containsKey(user_book.getGoodInfo().getAuthor())) {
                AuthorRating.put(user_book.getGoodInfo().getAuthor(), AuthorRating.get(user_book.getGoodInfo().getAuthor()) + 1);
            } else {
                AuthorRating.put(user_book.getGoodInfo().getAuthor(), 1);
            }
        }
        maxValue = 0;
        String topAuthor = "";
        for (Map.Entry map : AuthorRating.entrySet()) {
            if ((Integer) map.getValue() > maxValue) {
                maxValue = (Integer) map.getValue();
                topAuthor = (String) map.getKey();
            }
        }

        /*
        * Sorting by Century
        * */
        Map<Long, Integer> CenturyRating = new HashMap<Long, Integer>();
        for (Goods_users user_book : user_books) {
            if (CenturyRating.containsKey(user_book.getGoodInfo().getCentury())) {
                CenturyRating.put(user_book.getGoodInfo().getCentury(), CenturyRating.get(user_book.getGoodInfo().getCentury()) + 1);
            } else {
                CenturyRating.put(user_book.getGoodInfo().getCentury(), 1);
            }
        }

        maxValue = 0;
        Long topCentury = 0L;
        for (Map.Entry map : CenturyRating.entrySet()) {
            if ((Integer) map.getValue() > maxValue) {
                maxValue = (Integer) map.getValue();
                topCentury = (Long) map.getKey();
            }
        }

        /*
        * Compare goods
        * if goods equals , then take top2 good from database
        * */
        GoodInfo topCategoryGood = null, topAuthorGood = null, topCenturyGood = null;
        List<GoodInfo> thisCategoryGoods = goodRepositoryCustom.findByCategory_IdOrderByRatingDesc(Long.valueOf(categoryId));
        List<GoodInfo> thisAuthorGoods = goodRepositoryCustom.findByAuthorOrderByRatingDesc(topAuthor);
        List<GoodInfo> thisCenturyGoods = goodRepositoryCustom.findByCenturyOrderByRatingDesc(topCentury);
        if (!thisCategoryGoods.isEmpty() && !thisAuthorGoods.isEmpty() && !thisCenturyGoods.isEmpty()) {
            int countCategory = 0, countAuthor = 0, countCentury = 0;
            topCategoryGood = thisCategoryGoods.get(countCategory);

            topAuthorGood = thisAuthorGoods.get(countAuthor);
            if (topAuthorGood == null) return null;
            while (topCategoryGood.getId().equals(topAuthorGood != null ? topAuthorGood.getId() : null)) {
                countAuthor += 1;
                if(countAuthor != thisAuthorGoods.size()) {
                    topAuthorGood = thisAuthorGoods.get(countAuthor);
                    if (topAuthorGood == null) return null;
                }else topAuthorGood = null;
            }
            topCenturyGood = thisCenturyGoods.get(countCentury);
            while ((topCenturyGood != null && topCenturyGood.getId().equals(topCategoryGood.getId())) || (topCenturyGood != null && topCenturyGood.getId().equals(topAuthorGood != null ? topAuthorGood.getId() : null))) {
                countCentury += 1;
                if (countCentury != thisCenturyGoods.size()) {
                    topCenturyGood = thisCenturyGoods.get(++countCentury);
                }else topCenturyGood = null;
            }
        }else {
            return null;
        }
        result.add(topCategoryGood);
        result.add(topAuthorGood);
        result.add(topCenturyGood);

        for (GoodInfo aResult : result) {
            if (aResult == null)
                return null;
        }

        return result;

    }
}
