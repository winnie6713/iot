package com.iot.elasticsearch.vo;

import lombok.Data;

@Data
public class FullSearchVo {
    private String keyword;

    private int page;

    private int size;
}
