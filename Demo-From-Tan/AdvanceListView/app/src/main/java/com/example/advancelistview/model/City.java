package com.example.advancelistview.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

//@Data
//@AllArgsConstructor
//@Setter
//@Getter
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class City {
   private String NameCity;
   private int Hinh;
   private String linkWiki;

   public City() {
   }

   public City(String nameCity, int hinh, String linkWiki) {
      NameCity = nameCity;
      Hinh = hinh;
      this.linkWiki = linkWiki;
   }

   public String getNameCity() {
      return NameCity;
   }

   public void setNameCity(String nameCity) {
      NameCity = nameCity;
   }

   public String getLinkWiki() {
      return linkWiki;
   }

   public void setLinkWiki(String linkWiki) {
      this.linkWiki = linkWiki;
   }

   public int getHinh() {
      return Hinh;
   }

   public void setHinh(int hinh) {
      Hinh = hinh;
   }
}
