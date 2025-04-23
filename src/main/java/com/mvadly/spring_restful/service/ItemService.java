package com.mvadly.spring_restful.service;

import com.mvadly.spring_restful.entity.ItemEntity;
import com.mvadly.spring_restful.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    ResponseService findAll();
    ResponseService create(ItemEntity item);
}


@Service
class ItemServiceImpl implements ItemService {
    @Autowired(required = true)
    private ItemRepository itemRepository;


    public ResponseService findAll() {

        ResponseService res = new ResponseService();
        try {
            var data = itemRepository.findAll();
            if (data.toArray().length == 0) {
                return res.badRequest("0404","Data not found!", null);
            }

            return res.success(data);
        } catch (Exception e) {
            return res.internalServerError(e.toString());
        }
    }

    public ResponseService create(ItemEntity item) {
        ResponseService res = new ResponseService();
        // if (item == null) {
        //     return res.badRequest("0400", "Item cannot be null", null);
        // }
        // if (item.getName() == null || item.getName().isEmpty()) {
        //     return res.badRequest("0400", "Item name is required", null);
        // }
        // if (item.getPrice() == null || item.getPrice().doubleValue() <= 0) {
        //     return res.badRequest("0400", "Item price must be greater than zero", null);
        // }
        try {
            itemRepository.save(item);
            return res.success(item);
        } catch (Exception e) {
            return res.internalServerError(e.getMessage());
        }
    }
}