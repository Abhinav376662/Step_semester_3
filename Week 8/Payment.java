import java.util.Scanner;

abstract class Payment {
    protected double amount;
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    public abstract double getAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }
    
    @Override
    public double getAdjustedAmount() {
        return amount * 1.02; // 2% fee
    }
    
    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }
    
    @Override
    public double getAdjustedAmount() {
        return amount * 1.01; // 1% fee
    }
    
    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }
    
    @Override
    public double getAdjustedAmount() {
        return amount; // No fee
    }
    
    @Override
    public String getType
