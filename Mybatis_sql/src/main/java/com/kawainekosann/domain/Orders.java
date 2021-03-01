package com.kawainekosann.domain;

import java.util.Date;

public class Orders {
    private int id;
    private Date ordertimes;
    private double total;
    //表示当前订单属于哪个用户
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertimes() {
        return ordertimes;
    }

    public void setOrdertimes(Date ordertimes) {
        this.ordertimes = ordertimes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordertimes=" + ordertimes +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
