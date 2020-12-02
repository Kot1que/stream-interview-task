package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<Hotel> hotelsSource = Arrays.asList(
        new Hotel("California", 100, RoomClass.FIVE, false),
        new Hotel("Gold Zanzibar", 300, RoomClass.FIVE, true),
        new Hotel("Pushka Inn", 200, RoomClass.FIVE, true),
        new Hotel("Ali", 190, RoomClass.FIVE, true),
        new Hotel("Come Inn", 225, RoomClass.FOUR, true),
        new Hotel("Orfe", 60, RoomClass.THREE, false),
        new Hotel("Cromwell Crown", 80, RoomClass.THREE, false),
        new Hotel("Corbigoe", 145, RoomClass.TWO, false),
        new Hotel("Club Aqua Gumbet", 40, RoomClass.TWO, true),
        new Hotel("Hello Jo", 25, RoomClass.ONE, false)
    );

    //  Task:
    //  Использовать стримы.
    //  Вывести по одному отелю для курящих из каждого класса с минимальной ценой за день.
    //  Результат представить в виде Map<RoomClass, pricePerDay>

    Map<RoomClass, Integer> result = hotelsSource.stream()
        .filter(Hotel::isSmoking)
        .collect(
            Collectors.groupingBy(
                Hotel::getRoomClass,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    hotels -> hotels.stream().min(
                        Comparator.comparing(Hotel::getPricePerDay, Integer::compareTo)
                    ).get().getPricePerDay()
                )
            )
        );

    result.forEach((k, v) -> System.out.println(k + " " + v));
  }
}
