package com.pezesha.sampleproducer.models;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TMwaura on 21/03/2022
 * @Project sample-producer
 */
@ToString
@Builder
public class PaymentDetails {

    private String name;
    private Double amount;
    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
