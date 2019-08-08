package fam.finances.entity;

import lombok.Data;

@Data
public class SpendDto {

    private String owner;

    private String name;

    private Integer price;

    private Integer year;

    private Integer month;

    private Integer day;

    private String additionalInformation;
}
