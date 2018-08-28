package entity;

import java.util.Date;

public class Order {
    private int orderId;
    private String receiver;
    private String money;
    private int orderStaus;
    private int payStaus;
    private int sendGoodStaus;
    private String payWay;
    private String sendWay;
    private Date buyTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getOrderStaus() {
        return orderStaus;
    }

    public void setOrderStaus(int orderStaus) {
        this.orderStaus = orderStaus;
    }

    public int getPayStaus() {
        return payStaus;
    }

    public void setPayStaus(int payStaus) {
        this.payStaus = payStaus;
    }

    public int getSendGoodStaus() {
        return sendGoodStaus;
    }

    public void setSendGoodStaus(int sendGoodStaus) {
        this.sendGoodStaus = sendGoodStaus;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getSendWay() {
        return sendWay;
    }

    public void setSendWay(String sendWay) {
        this.sendWay = sendWay;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", receiver='" + receiver + '\'' +
                ", money='" + money + '\'' +
                ", orderStaus=" + orderStaus +
                ", payStaus=" + payStaus +
                ", sendGoodStaus=" + sendGoodStaus +
                ", payWay='" + payWay + '\'' +
                ", sendWay='" + sendWay + '\'' +
                ", buyTime=" + buyTime +
                '}';
    }
}
