package assignment1;

public class Item {

    private String name;
    private String type;
    private double price;
    private int quantity;

    public Item(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type.toLowerCase();
        this.price = price;
        this.quantity = quantity;
    }

    private double calculateTax() {
        double tax = 0;
        switch (type.toLowerCase()) {
            case "raw":
                tax = price * 0.125;
                break;
            case "manufactured":
                tax = price * 0.125 + (price * 1.125) * 0.02;
                break;
            case "imported":
                double importDuty = price * 0.10;
                double surcharge = 0;
                double costAfterTax = price + importDuty;
                if (costAfterTax <= 100) {
                    surcharge = 5;
                } else if (costAfterTax <= 200) {
                    surcharge = 10;
                } else {
                    surcharge = costAfterTax * 0.05;
                }
                tax = importDuty + surcharge;
                break;
            default:
                throw new IllegalArgumentException("Invalid item type: " + type);
        }
        return tax;
    }

    private double calculateFinalPrice() {
        return price + calculateTax();
    }

    public String showItemValues() {
        return "\nItem: " + name + "\n" + "Type: " + type + "\n" + "Price: " + price + "\n" + "Quantity: " + quantity +
                "\n" + "Tax: " + calculateTax() + "\n" + "Final Price: " + calculateFinalPrice() + "\n";
    }
}