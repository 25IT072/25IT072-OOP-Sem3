class OutOfStockException extends Exception{
    int shortfall;
    OutOfStockException(String msg, int shortfall){
        super(msg);
        this.shortfall = shortfall;
    }
    public int getShortfall(){
        return shortfall;
    }
}

class InvalidQuantityException extends Exception{
    InvalidQuantityException(String msg){
        super(msg);
    }
}

class Warehouse{
    int stock = 5;

    public void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException{
        if(qty <= 0){
            throw new InvalidQuantityException("Quantity must be greater than 0");
        }

        if(qty > stock){
            int shortfall = qty - stock;
            throw new OutOfStockException("Not enough stock for " + item, shortfall);
        }
        stock = stock - qty;

        System.out.println("Issued " + qty + " " + item + "(s) successfully.");
    }
}

public class StockIssue {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();

        String[] items = {"Laptop", "Laptop", "Laptop"};
        int[] quantities = {2, 5, 0};

        for (int i = 0; i < items.length; i++){
            try{
                w.issue(items[i], quantities[i]);
            }
            catch(OutOfStockException e){
                System.out.println("Error: " + e.getMessage());
                System.out.println("Shortfall: " + e.getShortfall());
            }
            catch(InvalidQuantityException e){
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("----------------");
        }
        System.out.println("All requests processed.");
    }
}


