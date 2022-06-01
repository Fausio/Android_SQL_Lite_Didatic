package com.ustm.domains;

import java.io.Serializable;
import java.math.BigInteger;

public class household implements Serializable {

    private Integer id;
    private  String name;
    private  String address;
    private BigInteger cell;

    public String getName() {
        return name;
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

    public BigInteger getCell() {
        return cell;
    }

    public void setCell(BigInteger cell) {
        this.cell = cell;
    }
}
