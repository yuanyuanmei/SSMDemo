package com.dm.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {

    private Integer pageNo = 1;

    private Integer pageSize = 10;

}
