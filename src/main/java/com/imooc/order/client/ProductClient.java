package com.imooc.order.client;

import com.imooc.order.dataobject.DecreaseStockInput;
import com.imooc.order.dataobject.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {


    @GetMapping("/msg")
    public String productMsg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
