package ru.job4j.coffeemachine;

import java.util.Arrays;

/**
 * class Cash
 * project Coffee Machine
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.2
 * @since 18.11.2018
 */
public class Cash {
    /**
     * boxes for unit of coins
     */
    private UnitCoins[] coinsMachin;
    private UnitCoins[] coinsChanges;

    /**
     * upload cash machine
     *
     * @param units     int[] with value of coins
     * @param quantites how mach coins to upload
     */
    void uploadCashCoins(int[] units, int quantites) {
        this.coinsMachin = new UnitCoins[units.length];
        this.coinsChanges = new UnitCoins[units.length];
        Arrays.sort(units);
        for (int i = units.length - 1; i >= 0; i--) {
            coinsMachin[i] = new UnitCoins(quantites, units[units.length - 1 - i]);
            coinsChanges[i] = new UnitCoins(0, units[units.length - 1 - i]);
        }
    }

    /**
     * calculate how mach minimum coins to changes return
     * if not enough coin denominations - print string
     * if value less them price - no return any coin
     *
     * @param value 100 or 50
     * @param price any int less then value, else return ziro
     * @return int of conits {10,10,5,}
     */
    public int[] changes(int value, int price) {
        int change = (value > price) ? value - price : 0;
        int lengthArrayChanges = 0;
        for (int i = 0; i < coinsMachin.length; i++) {
            change = this.calculateUnit(coinsMachin[i], coinsChanges[i], change);
            lengthArrayChanges += coinsChanges[i].getQuantityConis();
            if (change == 0) {
                break;
            }
        }
        int[] coints = new int[lengthArrayChanges];
        int i = 0;
        for (UnitCoins coinsChange : coinsChanges) {
            for (int coin = 0; coin < coinsChange.getQuantityConis(); coin++) {
                coints[i++] = coinsChange.getCoinValue();
            }
        }
        if (change > 0) {
            System.out.println("not enough coin denominations");
            coinsMachinToDisplay(coinsMachin);
        }
        return coints;
    }

    /**
     * calculate how much coins take from machin coin box and put in changes coin box
     *
     * @param unitCoins   unit of macine
     * @param changeCoins unit of change
     * @param change      int change
     * @return int change after calculate this stage
     */
    private int calculateUnit(UnitCoins unitCoins, UnitCoins changeCoins, int change) {
        int coinValue = unitCoins.getCoinValue();
        int resQualityCoins;
        int qualityConisIs = unitCoins.getQuantityConis();
        int qualityCoinsNeed = change / coinValue;
        if (qualityCoinsNeed < qualityConisIs) {
            resQualityCoins = qualityCoinsNeed;
        } else {
            resQualityCoins = qualityConisIs;
        }
        unitCoins.takeCoins(resQualityCoins);
        changeCoins.addCoins(resQualityCoins);
        return (change - resQualityCoins * coinValue);
    }

    /**
     * print coins units box
     *
     * @param coinsMachin all box of units of coins machin or change
     */
    private void coinsMachinToDisplay(UnitCoins[] coinsMachin) {
        for (UnitCoins unitCoins : coinsMachin) {
            System.out.println(String.format("Coint value: %d is %d coins.", unitCoins.getCoinValue(), unitCoins.getQuantityConis()));
        }
    }
}