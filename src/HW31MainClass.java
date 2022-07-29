import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HW31MainClass {
    public static void main(String[] args) throws Exception {
        // Hardcoded buyers
        LinkedHashSet<Buyer> buyerHashSet = new LinkedHashSet<>();

        Buyer buyer1 = new Buyer("buyer1", 33, Card.STANDARD);
        Buyer buyer2 = new Buyer("buyer2", 75, Card.STANDARD);
        Buyer buyer3 = new Buyer("buyer3", 25, Card.GOLD);
        Buyer buyer4 = new Buyer("buyer4", 96, Card.VIP);
        Buyer buyer5 = new Buyer("buyer5", 15, Card.GOLD);
        Buyer buyer6 = new Buyer("buyer6", 21, Card.VIP);
        Buyer buyer7 = new Buyer("buyer7", 69, Card.GOLD);
        Buyer buyer8 = new Buyer("buyer8", 45, Card.VIP);
        Buyer buyer9 = new Buyer("buyer9", 66, Card.STANDARD);

        buyerHashSet.add(buyer1);
        buyerHashSet.add(buyer2);
        buyerHashSet.add(buyer3);
        buyerHashSet.add(buyer4);
        buyerHashSet.add(buyer5);
        buyerHashSet.add(buyer6);
        buyerHashSet.add(buyer7);
        buyerHashSet.add(buyer8);
        buyerHashSet.add(buyer9);

        // Adding our own buyers
        System.out.println("How many buyers you want to create?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(reader.readLine());
        int counter = 0;
        while (counter < amount) {
            System.out.println("#" + (counter + 1) + ":");
            buyerHashSet.add(createBuyer());
            counter++;
        }

        /*
        Comparator (almost useless in this case, just to not fall with exception).
        Treesets are needed to provide the order.
         */
        BuyerComparator buyerComparator = new BuyerComparator();

        // Sets depend on buyer's type
        TreeSet<Buyer> sortedBuyers = new TreeSet<>(buyerComparator);
        TreeSet<Buyer> oldBuyers = new TreeSet<>(buyerComparator);
        TreeSet<Buyer> platinumBuyers = new TreeSet<>(buyerComparator);
        TreeSet<Buyer> regularBuyers = new TreeSet<>(buyerComparator);

        // Sorting our buyers
        buyerHashSet.forEach(x -> {
            while (buyerHashSet.iterator().hasNext()) {
                if (x.getAge() > 65) {
                    oldBuyers.add(x);
                    break;
                } else if (x.getCardType().equals(Card.VIP)) {
                    platinumBuyers.add(x);
                    break;
                } else {
                    regularBuyers.add(x);
                    break;
                }
            }
        });

        // Adding sorted buyers
        sortedBuyers.addAll(oldBuyers);
        sortedBuyers.addAll(platinumBuyers);
        sortedBuyers.addAll(regularBuyers);
        System.out.println(sortedBuyers);
    }

    // Method to create new buyers
    public static Buyer createBuyer() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Buyer buyer = new Buyer();
        System.out.println("Enter buyer's name:");
        buyer.setName(reader.readLine());
        System.out.println("Enter buyer's age:");
        buyer.setAge(Integer.parseInt(reader.readLine()));
        System.out.println("Enter buyer's status.\n" +
                "1. Standard.\n" +
                "2. Gold.\n" +
                "3. V.I.P.");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1 :
                buyer.setCardType(Card.STANDARD);
                break;
            case 2 :
                buyer.setCardType(Card.GOLD);
                break;
            case 3 :
                buyer.setCardType(Card.VIP);
                break;
        }
        return buyer;
    }
}
