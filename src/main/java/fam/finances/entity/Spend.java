package fam.finances.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "spends")
@Data
public class Spend {
    public Spend() {
    }

    public Spend(SpendDto spendDto) {
        this.owner = spendDto.getOwner();
        this.name = spendDto.getName();
        this.price = spendDto.getPrice() ;
        this.year = spendDto.getYear();
        this.month = spendDto.getMonth();
        this.day = spendDto.getDay();
        this.additionalInformation = spendDto.getAdditionalInformation();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String owner;

    private String name;

    private Integer price;

    private Integer year;

    private Integer month;

    private Integer day;

    private String additionalInformation;

    @ManyToOne
    @JoinColumn
    private User user;
}
