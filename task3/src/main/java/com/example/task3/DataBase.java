package com.example.task3;

import com.example.task3.entity.Logins;
import com.example.task3.entity.Supplies;
import com.example.task3.repository.LoginsRepository;
import com.example.task3.repository.SuppliesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {

    public void saveLoginsData(List<Login> loginList, LoginsRepository loginsRepository) {
        loginList.stream().forEach(a -> {
            loginsRepository.save(new Logins(a));
        });
    }

    public void saveSupplyData(List<Supply> suppliesList, SuppliesRepository suppliesRepository) {
        suppliesList.stream().forEach(a -> {
            suppliesRepository.save(new Supplies(a));
        });
    }

    public List<Logins> selectLoginData(LoginsRepository loginsRepository) {
        Iterable<Logins> logins = loginsRepository.findAll();
        List<Logins> result = new ArrayList<Logins>();
        logins.forEach(result::add);
        return result;
    }

    public List<Supplies> selectSupplyData(SuppliesRepository suppliesRepository) {
        Iterable<Supplies> supplies = suppliesRepository.findAll();
        List<Supplies> result = new ArrayList<Supplies>();
        supplies.forEach(result::add);
        return result;
    }

    public List<Supplies> suppliesFilterByPeriod(SuppliesRepository suppliesRepository, String period, String date, String authorizDeliveryFilter) {
        List<Supplies> result = new ArrayList<Supplies>();
        period.toLowerCase();
        DataBase db = new DataBase();
        switch (period.toLowerCase()) {
            case "all":
                result = db.selectSupplyData(suppliesRepository);
                break;
            case "day":
                result = suppliesRepository.getAllByPstngDateContains(date);
                break;
            case "month":
                result = suppliesRepository.getAllByPstngDateContains("." + date);
                break;
            case "year":
                result = suppliesRepository.getAllByPstngDateContains("." + date);
                break;
            case "quarter":
                String[] quart = date.split("-");
                result = suppliesRepository.getAllByPstngDateContains("." + quart[1]);

                Integer x = (Integer.parseInt(quart[0]) * 3);
                Integer y = x - 1;
                Integer z = x - 2;
                result = result.stream().filter(a -> a.getPstngDate().contains("." + x.toString() + ".") ||
                        a.getPstngDate().contains("." + y.toString() + ".") ||
                        a.getPstngDate().contains("." + z.toString() + ".") ||
                        a.getPstngDate().contains(".0" + x.toString() + ".") ||
                        a.getPstngDate().contains(".0" + y.toString() + ".") ||
                        a.getPstngDate().contains(".0" + z.toString() + ".")).collect(Collectors.toList());
                break;
            default:
                return null;
        }
        result = suppliesFilterByAuthorizDelivery(result, authorizDeliveryFilter);

        return result;
    }

    public List<Supplies> suppliesFilterByAuthorizDelivery(List<Supplies> supplies, String authorizDeliveryFilter) {
        if (!authorizDeliveryFilter.equals("")) {
            supplies = supplies.stream().filter(a -> a.getAuthorizDelivery().toString().equalsIgnoreCase(authorizDeliveryFilter)).collect(Collectors.toList());
        }

        return supplies;
    }
}
