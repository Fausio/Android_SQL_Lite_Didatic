package com.ustm.domains;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.math.BigInteger;

public class household implements Serializable {

    private Integer id;
    private  String name;
    private  String address;
    private Integer cell;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCell() {
        return cell;
    }

    public void setCell(Integer cell) {
        this.cell = cell;
    }

    @Override
    public String toString()  {
        return  getName();
    }
}
