package com.sparta.hanghaemarket.entity;

import com.sparta.hanghaemarket.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Column(name = "contents", nullable = true, length = 500)
    private String contents;
    @Column(name = "price", nullable = true)
    private int price;


    public Item(ItemRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.price = requestDto.getPrice();
    }

    public void update(ItemRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.price = requestDto.getPrice();
    }
}
