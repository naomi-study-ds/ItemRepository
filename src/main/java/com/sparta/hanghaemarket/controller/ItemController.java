package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService ItemService;

    public ItemController(ItemService ItemService) {
        this.ItemService = ItemService;
    }

    @PostMapping("/post")
    public ItemResponseDto creeateItem(@RequestBody ItemRequestDto requestDto) {
        return ItemService.createItem(requestDto);
    }

    @GetMapping("/post")
    public List<ItemResponseDto> getItems() {
        return ItemService.getItems();
    }

    @PutMapping("post/{id}")
    public Long updateMardet(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return ItemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deleteItem(@PathVariable Long id) {
        return ItemService.deleteItem(id);
    }


}
