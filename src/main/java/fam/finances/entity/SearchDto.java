package fam.finances.entity;

import lombok.Data;

@Data
public class SearchDto {

    private String owner;

    private String name;

    private Integer year;

    private Integer month;

    private Integer day;
}
