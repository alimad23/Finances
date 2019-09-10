package fam.finances.manager;

import fam.finances.entity.Spend;
import fam.finances.entity.SpendDto;
import fam.finances.repository.SpendRepository;
import fam.finances.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpendManager {
    @Autowired
    private SpendRepository spendRepository;

    @Autowired
    private UserManager userManager;


    public List<Spend> loadSpendsByOwner(String username, String owner) {
        List<Spend> spends = spendRepository.findByOwnerAndUser_Username(owner, username);
        return spends;
    }

    public List<Spend> loadSpendsByName(String name, String username) {
        List<Spend> spends = spendRepository.findByNameAndUser_Username(name, username);
        return spends;
    }

    public List<Spend> loadSpendsByYear(Integer year, String username) {
        List<Spend> spends = spendRepository.findByYearAndUser_Username(year, username);
        return spends;
    }

    public List<Spend> loadSpendsByYearAndMonth(Integer year, Integer month, String username) {
        List<Spend> spends = spendRepository.findByYearAndMonthAndUser_Username(year, month, username);
        return spends;
    }

    public List<Spend> loadSpendsByDate(Integer year, Integer month, Integer day, String username) {
        List<Spend> spends = spendRepository.findByYearAndMonthAndDayAndUser_Username(year, month, day, username);
        return spends;
    }

    public boolean saveSpend(SpendDto spendDto, String username) {
        try {
            Spend spend = new Spend(spendDto);
            spend.setUser(userManager.laodUserByUsername(username));
            spendRepository.save(spend);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        userManager.costThisMuch(spendDto.getPrice(), username);
        return true;
    }

    public List<Spend> loadSpendsByOwnerAndYear(String owner, Integer year, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndYearAndUser_Username(owner, year, username);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndYearAndMonth(String owner, Integer year, Integer month, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndYearAndMonthAndUser_Username(owner, year, month, username);
        return spends;
    }

    public List<Spend> loadSpendsByNameAndYear(String name, Integer year, String username) {
        List<Spend> spends = spendRepository.findByNameAndYearAndUser_Username(name, year, username);
        return spends;
    }

    public List<Spend> loadSpendsByNameAndYearAndMonth(String name, Integer year, Integer month, String username) {
        List<Spend> spends = spendRepository.findByNameAndYearAndMonthAndUser_Username(name, year, month, username);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndName(String owner, String name, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndUser_Username(owner, name, username);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndNameAndYear(String owner, String name, Integer year, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndYearAndUser_Username(owner, name, year, username);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndNameAndYearAndMonth(String owner, String name, Integer year, Integer month, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndYearAndMonthAndUser_Username(owner, name, year, month, username);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndNameAndDate(String owner, String name, Integer year, Integer month, Integer day, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndNameAndYearAndMonthAndDayAndUser_Username(owner, name, year, month, day, username);
        return spends;
    }

    public List<Spend> loadSpendsByNameAndDate(String name, Integer year, Integer month, Integer day, String username) {
        List<Spend> spends = spendRepository.findByNameAndYearAndMonthAndDayAndUser_Username(name, year, month, day, username);
        return spends;
    }

    public List<Spend> loadSpendsByOwnerAndDate(String owner, Integer year, Integer month, Integer day, String username) {
        List<Spend> spends = spendRepository.findByOwnerAndYearAndMonthAndDayAndUser_Username(owner, year, month, day, username);
        return spends;
    }

    public boolean addMoney(Integer amount, String username) {
        try {
            userManager.addMoney(amount, username);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
