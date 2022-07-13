package entity;

public class Skein {
   

    private int id;
    private String brand;
    private String color;
    
  
    public Skein(int id, String brand, String color) {
      this.setId(id);
      this.setBrand(brand); 
      this.setColor(color); 
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getBrand() {
      return brand;
    }

    public void setBrand(String brand) {
      this.brand = brand;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }
}  