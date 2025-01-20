package ReadFileWriteDatabase.fruits;

import java.time.LocalDate;

public class Apple extends Fruits {

    public Apple(int id, String name, String buyer, String seller, double price, LocalDate buyDate, LocalDate sellDate) {
        super(id, name, buyer, seller, price, buyDate, sellDate);
    }
}
