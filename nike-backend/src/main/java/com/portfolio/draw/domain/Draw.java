package com.portfolio.draw.domain;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Draw {

    @Id
    @GeneratedValue
    @Column(name = "draw_id")
    private Long id;

    private String date;
    private String product;
    @Column(unique = true)
    private String url;
    private String message;
    @Column(name = "is_sent")
    private boolean isSent;

}
