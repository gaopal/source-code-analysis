package com.gaopal.pattern.builder.general;

public class Client {
  public static void main(String[] args) {
    IBuilder builder = new ConcreteBuilder();

    System.out.println(builder.build());
  }

  interface IBuilder {
    Product build();
  }

  //    @Data
  static class Product {

    private String name;

    @Override
    public String toString() {
      return "Product{" + "name='" + name + '\'' + '}';
    }
  }

  static class ConcreteBuilder implements IBuilder {

    private Product product = new Product();

    public Product build() {
      return product;
    }
  }
}
