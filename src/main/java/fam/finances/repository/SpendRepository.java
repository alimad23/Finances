package fam.finances.repository;

import fam.finances.entity.Spend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendRepository extends JpaRepository<Spend, Long> {
    List<Spend> findByOwner(String owner);

    List<Spend> findByName(String name);

    List<Spend> findByYear(Integer year);

    List<Spend> findByYearAndMonth(Integer year, Integer month);

    List<Spend> findByYearAndMonthAndDay(Integer year, Integer month, Integer day);

    List<Spend> findByOwnerAndYear(String owner, Integer year);

    List<Spend> findByOwnerAndYearAndMonth(String owner, Integer year, Integer month);

    List<Spend> findByNameAndYear(String name, Integer year);

    List<Spend> findByNameAndYearAndMonth(String name, Integer year, Integer month);

    List<Spend> findByOwnerAndName(String owner, String name);

    List<Spend> findByOwnerAndNameAndYear(String owner, String name, Integer year);

    List<Spend> findByOwnerAndNameAndYearAndMonth(String owner, String name, Integer year, Integer month);

    List<Spend> findByOwnerAndNameAndYearAndMonthAndDay(String owner, String name, Integer year, Integer month, Integer day);

    List<Spend> findByNameAndYearAndMonthAndDay(String name, Integer year, Integer month, Integer day);

    List<Spend> findByOwnerAndYearAndMonthAndDay(String owner, Integer year, Integer month, Integer day);
}
