import java.util.Comparator;
import java.util.Objects;

public class Buyer extends BuyerComparator {
    private String name;
    private int age;
    private Card cardType;

    public Buyer(String name, int age, Card cardType) {
        this.name = name;
        this.age = age;
        this.cardType = cardType;
    }

    public Buyer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Card getCardType() {
        return cardType;
    }

    public void setCardType(Card cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cardType=" + cardType +
                '}' + "\n";
    }

}
