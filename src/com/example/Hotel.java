package com.example;

import java.util.Objects;

public class Hotel {
  private final String name;
  private final int pricePerDay;
  private final RoomClass roomClass;
  private final boolean isSmoking;

  public Hotel(String name, int pricePerDay, RoomClass roomClass, boolean isSmoking) {
    this.name = name;
    this.pricePerDay = pricePerDay;
    this.roomClass = roomClass;
    this.isSmoking = isSmoking;
  }

  public String getName() {
    return name;
  }

  public int getPricePerDay() {
    return pricePerDay;
  }

  public RoomClass getRoomClass() {
    return roomClass;
  }

  public boolean isSmoking() {
    return isSmoking;
  }

  @Override
  public String toString() {
    return "Hotel{" +
        "name='" + name + '\'' +
        ", pricePerDay=" + pricePerDay +
        ", roomClass=" + roomClass +
        ", isSmoking=" + isSmoking +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hotel hotel = (Hotel) o;
    return getPricePerDay() == hotel.getPricePerDay() &&
        isSmoking() == hotel.isSmoking() &&
        getName().equals(hotel.getName()) &&
        getRoomClass() == hotel.getRoomClass();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPricePerDay(), getRoomClass(), isSmoking());
  }
}
