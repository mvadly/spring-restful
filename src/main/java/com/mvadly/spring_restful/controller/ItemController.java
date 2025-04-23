package com.mvadly.spring_restful.controller;
import com.mvadly.spring_restful.common.Response;
import com.mvadly.spring_restful.entity.ItemEntity;
import com.mvadly.spring_restful.model.RequestItem;
import com.mvadly.spring_restful.model.ResponseItem;
import com.mvadly.spring_restful.service.ItemService;

import com.mvadly.spring_restful.service.ResponseService;
import com.mvadly.spring_restful.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;
    Response response = new Response();

    @Autowired
    private ValidationService validationService;

    public ResponseEntity<Response> getAll() {
        ResponseService service = itemService.findAll();
        response.rc = service.rc;
        response.Json(service.message, service.data);
        return ResponseEntity
                .status(service.statusCode)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    public ResponseItem create(RequestItem req) {
        validationService.validate(req);
        ItemEntity item = new ItemEntity();
        item.setName(req.getName());
        item.setPrice(req.getPrice());
        item.setStock(req.getStock());
        ResponseService service = itemService.create(item);
        response.rc = service.rc;
        response.Json(service.message, service.data);
        return ResponseItem.builder().
                name(item.getName()).
                price(item.getPrice()).
                stock(item.getStock()).
                build();
    }

}