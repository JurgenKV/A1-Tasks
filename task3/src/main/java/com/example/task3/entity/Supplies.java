package com.example.task3.entity;


import com.example.task3.Supply;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "postings")
public class Supplies {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "mat_doc")
    private String matDoc;

    @Column(name = "item")
    private String item;

    @Column(name = "doc_date")
    private String docDate;

    @Column(name = "pstng_date")
    private String pstngDate;

    @Column(name = "material_desc")
    private String materialDesc;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "bun")
    private String bun;

    @Column(name = "amount_l_c")
    private String amountLC;

    @Column(name = "crcy")
    private String crcy;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "authoriz_delivery")
    private Boolean authorizDelivery;

    public Supplies() {
    }

    public Supplies(String matDoc, String item, String docDate, String pstngDate, String materialDesc, String quantity, String bun, String amountLC, String crcy, String userName, Boolean authorizDelivery) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.materialDesc = materialDesc;
        this.quantity = quantity;
        this.bun = bun;
        this.amountLC = amountLC;
        this.crcy = crcy;
        this.userName = userName;
        this.authorizDelivery = authorizDelivery;
    }

    public Supplies(Supply supply) {
        this.matDoc = supply.getMatDoc();
        this.item = supply.getItem();
        this.docDate = supply.getDocDate();
        this.pstngDate = supply.getPstngDate();
        this.materialDesc = supply.getMaterialDesc();
        this.quantity = supply.getQuantity();
        this.bun = supply.getBun();
        this.amountLC = supply.getAmountLC();
        this.crcy = supply.getCrcy();
        this.userName = supply.getUserName();
        this.authorizDelivery = supply.getAuthorizDelivery();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(String matDoc) {
        this.matDoc = matDoc;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getPstngDate() {
        return pstngDate;
    }

    public void setPstngDate(String pstngDate) {
        this.pstngDate = pstngDate;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public String getAmountLC() {
        return amountLC;
    }

    public void setAmountLC(String amountLC) {
        this.amountLC = amountLC;
    }

    public String getCrcy() {
        return crcy;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getAuthorizDelivery() {
        return authorizDelivery;
    }

    public void setAuthorizDelivery(Boolean authorizDelivery) {
        this.authorizDelivery = authorizDelivery;
    }

}
