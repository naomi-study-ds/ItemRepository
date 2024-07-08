package com.sparta.hanghaemarket.dto;

import com.sparta.hanghaemarket.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private int price;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.contents = item.getContents();
        this.price = item.getPrice();
        this.createAt = item.getCreatedAt();
        this.modifiedAt = item.getModifiedAt();
    }
}
