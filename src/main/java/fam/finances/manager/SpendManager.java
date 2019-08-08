package fam.finances.manager;

import fam.finances.entity.Spend;
import fam.finances.entity.SpendDto;
import fam.finances.repository.SpendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpendManager {
    @Autowired
    private SpendRepository spendRepository;

    public List<Spend> loadSpendsByOwner(String owner) {
        List<Spend> spends = spendRepository.findByOwner(owner);
        return spends;
    }

    public List<Spend> loadSpendsByName(String name) {
        List<Spend> spends = spendRepository.findByName(name);
        return spends;
    }

    public List<Spend> loadSpendsByYear(Integer year) {
        List<Spend> spends = spendRepository.findByYear(year);
        return spends;
    }

    public List<Spend> loadSpendsByYearAndMonth(Integer year, Integer month) {
        List<Spend> spends = spendRepository.findByYearAndMonth(year, month);
        return spends;
    }

    public List<Spend> loadSpendsByDate(Integer year, Integer month, Integer day) {
        List<Spend> spends = spendRepository.findByYearAndMonthAndDay(year, month, day);
        return spends;
    }

    public boolean saveSpend(SpendDto spendDto) {
        try {
            Spend spend = new Spend(spendDto);
            spendRepository.save(spend);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Spend> loadSpendsByOwnerAndYear(String owner, Integer year) {
        List<Spend> spends = spendRepository.findByOwnerAndYear(owner, year);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndYearAndMonth(String owner, Integer year, Integer month) {
        List<Spend> spends = spendRepository.findByOwnerAndYearAndMonth(owner, year, month);
        return spends;
    }

    public List<Spend> loadSpendsByNameAndYear(String name, Integer year) {
        List<Spend> spends = spendRepository.findByNameAndYear(name, year);
        return spends;
    }

    public List<Spend> loadSpendsByNameAndYearAndMonth(String name, Integer year, Integer month) {
        List<Spend> spends = spendRepository.findByNameAndYearAndMonth(name, year, month);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndName(String owner, String name) {
        List<Spend> spends = spendRepository.findByOwnerAndName(owner, name);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndNameAndYear(String owner, String name, Integer year) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndYear(owner, name, year);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndNameAndYearAndMonth(String owner, String name, Integer year, Integer month) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndYearAndMonth(owner, name, year, month);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndNameAndDate(String owner, String name, Integer year, Integer month, Integer day) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndYearAndMonthAndDay(owner, name, year, month, day);
        return spends;
    }

    public List<Spend> loadSpendsByNameAndDate(String name, Integer year, Integer month, Integer day) {
        List<Spend> spends = spendRepository.findByNameAndYearAndMonthAndDay(name, year, month, day);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndDate(String owner, Integer year, Integer month, Integer day) {
        List<Spend> spends = spendRepository.findByOwnerAndYearAndMonthAndDay(owner, year, month, day);
        return spends;
    }
}
