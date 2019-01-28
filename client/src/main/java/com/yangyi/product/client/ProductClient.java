package com.yangyi.product.client;

import com.yangyi.product.common.DecreaseStockInput;
import com.yangyi.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 对外暴露
 *
 * @author yiyang
 */
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 商品列表
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 减库存
     *
     * @param decreaseStockInputList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
