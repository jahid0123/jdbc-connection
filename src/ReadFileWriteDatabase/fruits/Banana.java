package ReadFileWriteDatabase.fruits;

import java.time.LocalDate;

public class Banana extends Fruits {
    public Banana(int id, String name, String buyer, String seller, double price, LocalDate buyDate, LocalDate sellDate) {
        super(id, name, buyer, seller, price, buyDate, sellDate);
    }
}
