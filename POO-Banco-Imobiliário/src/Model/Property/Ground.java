package Model.Property;

import java.awt.Color;

public class Ground extends Property {

    private Color color;
    private int priceBuilding = 0;
    private int numHotels = 0;
    private int numHouses = 0;
    private int priceHouses = 0;

    public Ground(String name, int[] rent, int[] price, int x, int y, Color c, int cardNumber) {
        super(name, rent, price[0], x, y, cardNumber);
        priceBuilding = price[0];
        priceHouses = price[1];
        color = c;
    }

    public int getRent() {
        return rent[numHouses + numHotels];
    }

    public Color getColor() {
        return color;
    }

    // Building
    public int getPriceToSellBuildings() {

        return (priceBuilding + (numHouses + numHotels) * priceHouses);

    }

    public int sellBuildings() {
        int price = getPriceToSellBuildings();
        numHouses = 0;
        numHotels = 0;
        return price;
    }

    // House
    public int buyHouse() {
        numHouses += 1;
        return priceHouses;
    }

    public int getPriceHouse() {
        return priceHouses;
    }

    public int getHouses() {
        return numHouses;
    }

    public void setHouses(int h) {
        this.numHouses = h;
        return;
    }

    public void setHotels(int h) {
        this.numHotels = h;
        return;
    }

    // Hotel
    public int buyHotel() {
        numHotels += 1;
        return priceHouses;
    }

    public int getHotels() {
        return numHotels;
    }

    public String genSaveString() {
        int p = getProprietario();
        if (p != -1)
            p += 1;
        return String.format("\n\tProprietario: %d;\n\tCasa: %d;\n\tHotel: %d", p, numHouses,
                numHotels);
    }

}
