package ReadFileWriteDatabase.fruits;

import java.time.LocalDate;

public class Fruits {
    private int id;
    private String name;
    private String buyer;
    private String seller;
    private double price;
    private LocalDate buyDate;
    private LocalDate sellDate;


    public Fruits(int id, String name, String buyer, String seller, double price, LocalDate buyDate, LocalDate sellDate) {
        this.id = id;
        this.name = name;
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.buyDate = buyDate;
        this.sellDate = sellDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }
}
