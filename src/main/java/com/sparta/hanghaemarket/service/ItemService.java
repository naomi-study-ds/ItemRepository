package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import com.sparta.hanghaemarket.dto.ItemResponseDto;
import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository ItemRepository;

    public ItemService(ItemRepository ItemRepository) {
        this.ItemRepository = ItemRepository;
    }

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item Item = new Item(requestDto);

        // DB 저장
        Item saveItem = ItemRepository.save(Item);

        ItemResponseDto ItemResponseDto = new ItemResponseDto(Item);

        return ItemResponseDto;
    }

    public List<ItemResponseDto> getItems() {
        return ItemRepository.findAllByOrderByModifiedAtDesc().stream().map(ItemResponseDto::new).toList();
    }

    public Long updateItem(Long id, ItemRequestDto requestDto) {
        Item Item = findItem(id);
        Item.update(requestDto);
        return id;
    }

    public Long deleteItem(Long id) {
        Item Item = findItem(id);
        return id;
    }

    private Item findItem(Long id) {
        return ItemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
