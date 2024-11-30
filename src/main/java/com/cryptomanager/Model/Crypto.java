package com.cryptomanager.Model;

public class Crypto {
    private static int nextId=1;  //pro unikatni id
    int id;
    String name;
    String symbol;
    double price;
    double quantity;

    public Crypto() {
        this.id = nextId++;
    }

    public Crypto(String name, String symbol, double price, double quantity) {
        this.id = nextId++;
        this.setName(name);
        this.setSymbol(symbol);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Crypto.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
           throw new IllegalArgumentException("Name is required and cannot be empty");
        }
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        if (symbol == null || symbol.trim().isEmpty()) {
            throw new IllegalArgumentException("Symbol is required and cannot be empty");
        }
        this.symbol = symbol;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <=0){
            throw new IllegalArgumentException("Price must be higher than 0");
        }
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        if(quantity<0){
            throw new IllegalArgumentException("Quantity cannot be less than 0"); //ponechana moznost nastaveni na 0 pri prodeji kryptomeny
        }
        this.quantity = quantity;
    }
}
