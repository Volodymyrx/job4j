package com.volodiax;
/**
 * для интереса
 * считает сколько раз случайное число выпало
 * проверить вероятность.
 *
 * */
public class StudyRandom {
    public static void main(String[] args) {
        StudyRandom study = new StudyRandom();
        study.go();
    }
/**
 * главный метод
 * считает сколько раз случайное число выпало
 * результат в виде масива передает в метод по пересчету в отностильные процентное выпадение чисел
 * получает относительный массив и передает его на рисование
 *
 *
 * */
    private void go() {
        //сколько чесел использовать для проверки частоты выпадения
        int numbers = 2;
        //сколько раз повторять.
        int endNumTry = 100;
        int[] countResult = new int[numbers];
        int tempResult;
        for (int i = 0; i < endNumTry; i++) {
            tempResult = (int) (Math.random() * numbers);
            countResult[tempResult]++;
        }
        int[] relativResult = makeRelativResult(countResult);
        paintTrend(relativResult);
    }
/**
 * выводит результат на консоль
 * */
    private void paintTrend(int[] datas) {
        for (int data : datas) {
            System.out.println(data);
        }
    }
/**
 * пересчитывает массив в относительный доля в процентах
 * */
    private int[] makeRelativResult(int[] countResult) {
        int[] relativResultPersent = new int[countResult.length];
        int summAll = 0;
        for (int i : countResult) {
            summAll += i;
        }
        for (int i = 0; i < relativResultPersent.length; i++) {
            relativResultPersent[i] = (100 * countResult[i]) / summAll;
        }
        return relativResultPersent;
    }


}
