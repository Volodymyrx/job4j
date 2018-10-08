package ru.job4j.converter;

/**
 * Convertor
 * make propetis of convertor
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 3.2
 * @version 1.0
 * @since 08.10.2018
 */
public class Converter {
    private int kursRubleToDollar = 60;
    private int kursRubleToEuro = 70;

    /*Getter for field kursRubleToDollar*/
    public int getKursRubleToDollar() {
        return kursRubleToDollar;
    }

    /*Setter for field kursRubleToDollar*/
    public void setKursRubleToDollar(int kursRubleToDollar) {
        this.kursRubleToDollar = kursRubleToDollar;
    }

    /*Getter for field kursRubleToEuro*/
    public int getKursRubleToEuro() {
        return kursRubleToEuro;
    }

    /*Setter for field kursRubleToEuro*/
    public void setKursRubleToEuro(int kursRubleToEuro) {
        this.kursRubleToEuro = kursRubleToEuro;
    }

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / this.kursRubleToEuro);
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return (value / this.kursRubleToDollar);
    }

    /**
     * Конвертируем рубли в евро.
     *
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return (value * this.kursRubleToEuro);
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToTuble(int value) {
        return (value * this.kursRubleToDollar);
    }


}
