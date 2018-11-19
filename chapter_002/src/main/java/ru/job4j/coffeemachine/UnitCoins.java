package ru.job4j.coffeemachine;

/**
 * class UnitCoins
 * project Coffee Machine
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.2
 * @since 18.11.2018
 */
public class UnitCoins {
    private final Coin[] unitCoins = new Coin[100];
    private final int coinValue;

    /**
     * constructor
     *
     * @param quantityCoins int quantity coins
     * @param coinValue     int coin value
     */
    public UnitCoins(int quantityCoins, int coinValue) {
        this.coinValue = coinValue;
        for (int i = 0; i < quantityCoins; i++) {
            unitCoins[i] = new Coin();
        }
    }

    /**
     * calculate noNull cells in this.unitCoins[]
     *
     * @return int noNull cells
     */
    public int getQuantityConis() {
        int quantity = 0;
        for (Coin coin : this.unitCoins) {
            if (coin != null) {
                quantity++;
            }
        }
        return quantity;
    }

    /**
     * getter coin value
     *
     * @return this coin value
     */
    public int getCoinValue() {
        return this.coinValue;
    }

    /**
     * delete coin from this unitCoint
     *
     * @param coinsTaken int coint to delete
     */
    public void takeCoins(int coinsTaken) {
        int coins = 0;
        for (int i = 0; i < unitCoins.length; i++) {
            if (coinsTaken <= coins) {
                break;
            }
            if (unitCoins[i] != null) {
                unitCoins[i] = null;
                coins++;
            }
        }
    }

    /**
     * add coin to array unitCoins
     *
     * @param quantityCoins quantity of coints to add in this array unitCoins
     */
    public void addCoins(int quantityCoins) {
        int coins = 0;
        for (int i = 0; i < unitCoins.length; i++) {
            if (quantityCoins <= coins) {
                break;
            }
            if (unitCoins[i] == null) {
                unitCoins[i] = new Coin();
                coins++;
            }
        }
    }
}
