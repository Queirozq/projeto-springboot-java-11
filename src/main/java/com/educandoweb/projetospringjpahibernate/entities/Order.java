package com.educandoweb.projetospringjpahibernate.entities;

import com.educandoweb.projetospringjpahibernate.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
   private Instant moment;

   private Integer orderStatus;


   @ManyToOne
   @JoinColumn(name = "client_id")
   private User client;

   @OneToMany(mappedBy = "id.order")
   private Set<OrderItem> items = new HashSet<>();

   public Order() {
   }

   public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
      this.id = id;
      setOrderStatus(orderStatus);
      this.moment = moment;
      this.client = client;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Instant getMoment() {
      return moment;
   }

   public void setMoment(Instant moment) {
      this.moment = moment;
   }

   public User getClient() {
      return client;
   }

   public void setClient(User client) {
      this.client = client;
   }

   public OrderStatus getOrderStatus() {
      return OrderStatus.valueOf(orderStatus);
   }

   public void setOrderStatus(OrderStatus orderStatus) {
      if (orderStatus != null) {
         this.orderStatus = orderStatus.getCode();
      }
   }

   public Set<OrderItem> getItems(){
      return items;
   }


   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Order)) return false;
      Order order = (Order) o;
      return Objects.equals(id, order.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
