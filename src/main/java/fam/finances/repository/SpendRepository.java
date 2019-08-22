package fam.finances.repository;

import fam.finances.entity.Spend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendRepository extends JpaRepository<Spend, Long> {
    List<Spend> findByOwnerAndUser_Username(String owner, String username);

    List<Spend> findByNameAndUser_Username(String name, String username);

    List<Spend> findByYearAndUser_Username(Integer year, String username);

    List<Spend> findByYearAndMonthAndUser_Username(Integer year, Integer month, String username);

    List<Spend> findByYearAndMonthAndDayAndUser_Username(Integer year, Integer month, Integer day, String username);

    List<Spend> findByOwnerAndYearAndUser_Username(String owner, Integer year, String username);

    List<Spend> findByOwnerAndYearAndMonthAndUser_Username(String owner, Integer year, Integer month, String username);

    List<Spend> findByNameAndYearAndUser_Username(String name, Integer year, String username);

    List<Spend> findByNameAndYearAndMonthAndUser_Username(String name, Integer year, Integer month, String username);

    List<Spend> findByOwnerAndNameAndUser_Username(String owner, String name, String username);

    List<Spend> findByOwnerAndNameAndYearAndUser_Username(String owner, String name, Integer year, String username);

    List<Spend> findByOwnerAndNameAndYearAndMonthAndUser_Username(String owner, String name, Integer year, Integer month, String username);

    List<Spend> findByOwnerAndNameAndYearAndMonthAndDayAndUser_Username(String owner, String name, Integer year, Integer month, Integer day, String username);

    List<Spend> findByNameAndYearAndMonthAndDayAndUser_Username(String name, Integer year, Integer month, Integer day, String username);

    List<Spend> findByOwnerAndYearAndMonthAndDayAndUser_Username(String owner, Integer year, Integer month, Integer day, String username);
}
