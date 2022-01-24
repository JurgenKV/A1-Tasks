package com.example.task3;

import com.example.task3.entity.Supplies;
import com.example.task3.repository.SuppliesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.task3.repository.LoginsRepository;
import org.springframework.web.servlet.ModelAndView;


import java.text.ParseException;
import java.util.*;

@Component
@RestController
public class Controller {

    @Autowired
    public LoginsRepository loginsRepository;

    @Autowired
    public SuppliesRepository suppliesRepository;

    private DataBase db = new DataBase();

    @GetMapping("/upload")
    public ResponseEntity<String> table() throws InterruptedException, ParseException {
        Login log = new Login();
        List<Login> loginList = new ArrayList<Login>();

        try {
            loginList = log.parseLoginsData("D:\\Downloads\\logins.csv");
            db.saveLoginsData(loginList, loginsRepository);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error (login)");
        }

        Supply sup = new Supply();
        List<Supply> suppliesList = new ArrayList<Supply>();

        try {
            suppliesList = sup.parseSupplyData("D:\\Downloads\\postings.csv", loginsRepository);
            db.saveSupplyData(suppliesList, suppliesRepository);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error (supply)");
        }

        return ResponseEntity.ok("Data uploaded");
    }

    @RequestMapping(value = {"/filter"}, method = RequestMethod.GET)
    public ModelAndView viewPersonList(@RequestParam(value = "period", defaultValue = "all") String period,
                                       @RequestParam(value = "date", defaultValue = "0") String date,
                                       @RequestParam(value = "authorizDeliveryFilter", defaultValue = "")
                                               String authorizDeliveryFilter) throws InterruptedException, ParseException {

        List<Supplies> suppliesListFromFiltredDb = new ArrayList<Supplies>();

        try {
            suppliesListFromFiltredDb = db.suppliesFilterByPeriod(suppliesRepository, period, date, authorizDeliveryFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table");
        modelAndView.addObject("suppliesListFromFiltredDb", suppliesListFromFiltredDb);
        return modelAndView;
    }

}
