/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ruserba.beans;

/**
 *
 * @author Ahmad Fauzan
 */
public class Item {
    int id;
    String name;
    int category;
    int price;
    String picturePath; 
    int tersedia;
    String ket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    
    public int getTersedia() {
        return tersedia;
    }

    public void setTersedia(int tersedia) {
        this.tersedia = tersedia;
    }
    
    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
    
}
