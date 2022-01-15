package ss12_Collection.bai_tap.collectionMVC.model.Service.iml;

import ss12_Collection.bai_tap.collectionMVC.model.model.ProductModel;

import java.util.Comparator;

public class SortPriceIncrease implements Comparator<ProductModel> {

    @Override
    public int compare(ProductModel price1, ProductModel price2) {
        if (price1.getPrice() > price2.getPrice()){
            return 1;
        }else if (price1.getPrice() < price2.getPrice()){
            return -1;
        }else {
            return 0;
        }
    }
}
