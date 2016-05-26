package mvc.common;

import java.util.List;


public class WishlistUtil {

    /**
     * key - id товара, value - кол-во товара
     */
    private List<GoodInfo> goods;

    public List<GoodInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodInfo> goods) {
        this.goods = goods;
    }

    /**
     * Есть ли в корзине товар с этим id
     * Для FreeMarker, так как он не умеет работать с числовыми ключами
     *
     * @param goodId id товара
     */
    public boolean containsGoodId(Long goodId){
        if (goods == null || goodId == null)
            return false;
//        for (GoodInfo good : goods){
////            if(good.getId().equals(goodId)){
////                return true;
////            }
//        }
        return false;
    }

}
