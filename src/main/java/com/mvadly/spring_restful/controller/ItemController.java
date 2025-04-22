package com.mvadly.spring_restful.controller;
import com.mvadly.spring_restful.common.Response;
import com.mvadly.spring_restful.entity.ItemEntity;
import com.mvadly.spring_restful.service.ItemService;

import com.mvadly.spring_restful.service.ResponseService;
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

    public ResponseEntity<Response> getAll() {
        ResponseService service = itemService.findAll();
        response.rc = service.rc;
        response.Json(service.message, service.data);
        return ResponseEntity
                .status(service.statusCode)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    public ResponseEntity<Response> create(ItemEntity item) {
        ResponseService service = itemService.create(item);
        response.rc = service.rc;
        response.Json(service.message, service.data);
        return ResponseEntity
                .status(service.statusCode)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}