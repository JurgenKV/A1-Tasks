package com.example.task3;

import com.example.task3.entity.Logins;
import com.example.task3.repository.LoginsRepository;

import java.util.ArrayList;
import java.util.List;

public class Supply {

    private String matDoc;
    private String item;
    private String docDate;
    private String pstngDate;
    private String materialDesc;
    private String quantity;
    private String bun;
    private String amountLC;
    private String crcy;
    private String userName;
    private Boolean authorizDelivery;

    public Supply() {
    }

    public Supply(String _matDoc, String _item, String _docDate, String _pstngDate, String _materialDesc,
                  String _quantity, String _bun, String _amountLC, String _crcy, String _userName) {
        matDoc = _matDoc;
        item = _item;
        docDate = _docDate;
        pstngDate = _pstngDate;
        materialDesc = _materialDesc;
        quantity = _quantity;
        bun = _bun;
        amountLC = _amountLC;
        crcy = _crcy;
        userName = _userName;
        authorizDelivery = false;
    }

    public String getMatDoc() {
        return matDoc;
    }

    public String getItem() {
        return item;
    }

    public String getDocDate() {
        return docDate;
    }

    public String getPstngDate() {
        return pstngDate;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getBun() {
        return bun;
    }

    public String getAmountLC() {
        return amountLC;
    }

    public String getCrcy() {
        return crcy;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getAuthorizDelivery() {
        return authorizDelivery;
    }

    public void setMatDoc(String matDoc) {
        this.matDoc = matDoc;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public void setPstngDate(String pstngDate) {
        this.pstngDate = pstngDate;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setAmountLC(String amountLC) {
        this.amountLC = amountLC;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAuthorizDelivery(Boolean authorizDelivery) {
        this.authorizDelivery = authorizDelivery;
    }

    public List<Supply> parseSupplyData(String path, LoginsRepository loginsRepository) throws Exception {
        CSVParser csv = new CSVParser();
        List<Supply> supplyList = csv.readSupply(path);

        Iterable<Logins> logins = loginsRepository.findAll();
        List<Logins> result = new ArrayList<Logins>();
        logins.forEach(result::add);

        return checkAuthorizDelivery(supplyList, result);
    }

    public List<Supply> checkAuthorizDelivery(List<Supply> supplyList, List<Logins> result) {
        for (int i = 0; i < supplyList.size(); i++) {
            int finalI = i;
            for (Logins a : result) {
                if (a.getAppAccountName().equals(supplyList.get(finalI).getUserName()) && a.getIsActive().equalsIgnoreCase("True")) {
                    supplyList.get(finalI).setAuthorizDelivery(Boolean.TRUE);
                }
            }
        }
        return supplyList;
    }
}
