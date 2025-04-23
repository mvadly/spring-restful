package com.mvadly.spring_restful.routes;

import com.mvadly.spring_restful.common.Response;
import com.mvadly.spring_restful.controller.ItemController;

import com.mvadly.spring_restful.entity.ItemEntity;

import com.mvadly.spring_restful.model.ApiResponse;
import com.mvadly.spring_restful.model.RequestItem;
import com.mvadly.spring_restful.model.ResponseItem;
import jakarta.validation.Valid;

import org.hibernate.mapping.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemRoutes {

    private final ItemController controller;

    public ItemRoutes(ItemController controller) {
        this.controller = controller;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Response> getAllItems() {
        return controller.getAll();
    }

    @PostMapping
    public ApiResponse<ResponseItem> createItem(@RequestBody RequestItem item) {
        return ApiResponse.<ResponseItem>builder().data(item).build();
    }

}