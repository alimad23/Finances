package fam.finances.controller;

import fam.finances.config.IAuthenticationFacade;
import fam.finances.entity.MoneyDto;
import fam.finances.entity.SearchDto;
import fam.finances.entity.Spend;
import fam.finances.entity.SpendDto;
import fam.finances.manager.SpendManager;
import fam.finances.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private SpendManager spendManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
        //how to get username
        //Authentication authentication = authenticationFacade.getAuthentication();
        //String username = authentication.getName();
    }

    @GetMapping("/addMoney")
    public ModelAndView addMoney(){
        ModelAndView modelAndView = new ModelAndView("add-money.html");
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}")
    public ModelAndView getSpendsByOwner(@PathVariable("owner") String owner) {
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwner(username, owner);
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/name/{name}")
    public ModelAndView getSpendsByName(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByName(name, username);
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/name/{name}/{year}")
    public ModelAndView getSpendsByNameAndYear(@PathVariable("name") String name, @PathVariable("year") Integer year) {
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByNameAndYear(name, year, username);
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/name/{name}/{year}/{month}")
    public ModelAndView getSpendsByNameAndYearAndMonth(@PathVariable("name") String name, @PathVariable("year") Integer year,
                                                       @PathVariable("month") Integer month) {
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByNameAndYearAndMonth(name, year, month, username);
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/name/{name}/{year}/{month}/{day}")
    public ModelAndView getSpendsByNameAndDate(@PathVariable("name") String name, @PathVariable("year") Integer year,
                                               @PathVariable("month") Integer month, @PathVariable("day") Integer day) {
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByNameAndDate(name, year, month, day, username);
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/{year}")
    public ModelAndView getSpendsByYear(@PathVariable("year") Integer year) {
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByYear(year, username);
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/{year}/{month}")
    public ModelAndView getSpendsByYearAndMonth(@PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByYearAndMonth(year, month, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/{year}/{month}/{day}")
    public ModelAndView getSpendsByDate(@PathVariable("year") Integer year, @PathVariable("month") Integer month, @PathVariable("day") Integer day) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByDate(year, month, day, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/{year}")
    public ModelAndView getSpendsByOwnerAndYear(@PathVariable("owner") String owner, @PathVariable("year") Integer year) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndYear(owner, year, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/{year}/{month}")
    public ModelAndView getSpendsByOwnerAndYearAndMonth(@PathVariable("owner") String owner, @PathVariable("year") Integer year,
                                                        @PathVariable("month") Integer month) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndYearAndMonth(owner, year, month, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/{year}/{month}/{day}")
    public ModelAndView getSpendsByOwnerAndDate(@PathVariable("owner") String owner, @PathVariable("year") Integer year,
                                                @PathVariable("month") Integer month, @PathVariable("day") Integer day) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndDate(owner, year, month, day, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/name/{name}")
    public ModelAndView getSpendsByOwnerAndName(@PathVariable("owner") String owner, @PathVariable("name") String name) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndName(owner, name, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/name/{name}/{year}")
    public ModelAndView getSpendsByOwnerAndNameAndYear(@PathVariable("owner") String owner, @PathVariable("name") String name
            , @PathVariable("year") Integer year) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndNameAndYear(owner, name, year, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/name/{name}/{year}/{month}")
    public ModelAndView getSpendsByOwnerAndNameAndYearAndMonth(@PathVariable("owner") String owner, @PathVariable("name") String name
            , @PathVariable("year") Integer year, @PathVariable("month") Integer month) {
        System.out.println("shit happened");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndNameAndYearAndMonth(owner, name, year, month, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/spend/owner/{owner}/name/{name}/{year}/{month}/{day}")
    public ModelAndView getSpendsByOwnerAndNameAndDate(@PathVariable("owner") String owner, @PathVariable("name") String name
            , @PathVariable("year") Integer year, @PathVariable("month") Integer month, @PathVariable("day") Integer day) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        List<Spend> spends = spendManager.loadSpendsByOwnerAndNameAndDate(owner, name, year, month, day, username);
        ModelAndView modelAndView = new ModelAndView("show-result.html");
        modelAndView.addObject("list", spends);
        modelAndView.addObject("total", total(spends));
        modelAndView.addObject("remainder", userManager.loadRemainderByUsername(username));
        return modelAndView;
    }

    @GetMapping("/add")
    @ResponseBody
    public ModelAndView showAddPage() {
        return new ModelAndView("add.html");
    }

    @PostMapping("/added")
    public ModelAndView addSpend(SpendDto spendDto) {
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        boolean flag = spendManager.saveSpend(spendDto, username);
        ModelAndView modelAndView = new ModelAndView("added.html");
        if (!flag) {
            modelAndView.addObject("error", "an error has been occurred");
        }
        if (flag) {
            modelAndView.addObject("error", "OK!, and remainder of your account is : " + userManager.loadRemainderByUsername(username));
        }
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchPage() {
        ModelAndView modelAndView = new ModelAndView("search2.html");
        modelAndView.addObject("message", "this is some message");
        return modelAndView;
    }

    @PostMapping("/searchProcess")
    public ModelAndView searchProcess(SearchDto searchDto) {
        if (!searchDto.getOwner().isEmpty()) {
            if (!searchDto.getName().isEmpty()) {//owner + name
                if (searchDto.getYear() == null) {//owner + name
                    return getSpendsByOwnerAndName(searchDto.getOwner(), searchDto.getName());
                } else {
                    if (searchDto.getMonth() == null) {//owner + name + year
                        return getSpendsByOwnerAndNameAndYear(searchDto.getOwner(), searchDto.getName(), searchDto.getYear());
                    } else {//owner + name + year + month
                        if (searchDto.getDay() == null) {//owner + name + year + month
                            return getSpendsByOwnerAndNameAndYearAndMonth(searchDto.getOwner(), searchDto.getName(), searchDto.getYear(), searchDto.getMonth());
                        } else {//owner + name + year + month + day
                            return getSpendsByOwnerAndNameAndDate(searchDto.getOwner(), searchDto.getName(), searchDto.getYear(), searchDto.getMonth(), searchDto.getDay());
                        }
                    }
                }
            } else {
                if (searchDto.getYear() == null) {//owner
                    System.out.println("owner is : " + searchDto.getOwner());
                    return getSpendsByOwner(searchDto.getOwner());
                } else {//owner + year
                    if (searchDto.getMonth() == null) {//owner + year
                        return getSpendsByOwnerAndYear(searchDto.getOwner(), searchDto.getYear());
                    } else {//owner + year + month
                        if (searchDto.getDay() == null) {//owner + year + month
                            return getSpendsByOwnerAndYearAndMonth(searchDto.getOwner(), searchDto.getYear(), searchDto.getMonth());
                        } else {//owner + year + month + day
                            return getSpendsByOwnerAndDate(searchDto.getOwner(), searchDto.getYear(), searchDto.getMonth(), searchDto.getDay());
                        }
                    }
                }
            }
        } else {
            if (searchDto.getName().isEmpty()) {
                if (searchDto.getYear() == null) {
                    return new ModelAndView("redirect:/search");
                }
                if (searchDto.getMonth() == null) {//year
                    return new ModelAndView("redirect:/spend/" + searchDto.getYear());
                } else {
                    if (searchDto.getDay() == null) {// year + month
                        return new ModelAndView("redirect:/spend/" + searchDto.getYear() + "/" + searchDto.getMonth());
                    } else {//year + month + day
                        return new ModelAndView("redirect:/spend/" + searchDto.getYear() + "/" + searchDto.getMonth() + "/" + searchDto.getDay());
                    }
                }
            } else {//name
                if (searchDto.getYear() == null) {//name
                    return getSpendsByName(searchDto.getName());
                } else {
                    if (searchDto.getMonth() == null) {//name + year
                        return getSpendsByNameAndYear(searchDto.getName(), searchDto.getYear());
                    } else {
                        if (searchDto.getDay() == null) {//name + year + month
                            return getSpendsByNameAndYearAndMonth(searchDto.getName(), searchDto.getYear(), searchDto.getMonth());
                        } else {// name + year + month + day
                            return getSpendsByNameAndDate(searchDto.getName(), searchDto.getYear(), searchDto.getMonth(), searchDto.getDay());

                        }
                    }
                }
            }

        }
    }

    @PostMapping("/addMoney")
    public ModelAndView addMoney(MoneyDto moneyDto){
        ModelAndView modelAndView = new ModelAndView("added.html");
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        boolean flag = spendManager.addMoney(moneyDto.getAmount(), username);
        if (!flag) {
            modelAndView.addObject("error", "an error has been occurred");
        }
        if (flag) {
            modelAndView.addObject("error", "OK!, and remainder of your account is : " + userManager.loadRemainderByUsername(username));
        }
        return modelAndView;
    }


    //=============NON-API=================
    private Integer total(List<Spend> spends) {
        Integer result = 0;
        for (int i = 0; i < spends.size(); i++) {
            result += spends.get(i).getPrice();
        }
        return result;
    }
}
