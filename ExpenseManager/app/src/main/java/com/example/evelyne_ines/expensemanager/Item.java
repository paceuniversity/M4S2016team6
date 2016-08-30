package com.example.evelyne_ines.expensemanager;

import android.view.View;
import java.util.ArrayList;

/**
 * Created by evelyne-ines on 06/08/16.
 */
public class Item {

    private String price;
    private String pledgePrice;
    private String fromAddress;
    private String toAddress;
    private String Pcasino;
    private String Pcitydia;
    private String Patac;

    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String price, String pledgePrice, String fromAddress, String toAddress, String Pcasino, String Pcitydia, String Patac) {
        this.price = price;
        this.pledgePrice = pledgePrice;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.Pcasino = Pcasino;
        this.Pcitydia= Pcitydia;
        this.Patac = Patac;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(String pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String  getPcasino() {
        return Pcasino;
    }

    public void setPcasino(String Pcasino) {
        this.Pcasino = Pcasino;
    }

    public String getPcitydia() {
        return Pcitydia;
    }

    public void setPcitydia(String Pcitydia) {
        this.Pcitydia = Pcitydia;
    }

    public String getPatac() {
        return Patac;
    }

    public void setPatac(String Patac) {
        this.Patac = Patac;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Pcasino != item.Pcasino) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (pledgePrice != null ? !pledgePrice.equals(item.pledgePrice) : item.pledgePrice != null)
            return false;
        if (fromAddress != null ? !fromAddress.equals(item.fromAddress) : item.fromAddress != null)
            return false;
        if (toAddress != null ? !toAddress.equals(item.toAddress) : item.toAddress != null)
            return false;
        if (Pcitydia != null ? !Pcitydia.equals(item.Pcitydia) : item.Pcitydia != null) return false;
        return !(Patac != null ? !Patac.equals(item.Patac) : item.Patac != null);

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (pledgePrice != null ? pledgePrice.hashCode() : 0);
        result = 31 * result + (fromAddress != null ? fromAddress.hashCode() : 0);
        result = 31 * result + (toAddress != null ? toAddress.hashCode() : 0);
        result = 31 * result + (Pcasino !=null ? Pcasino.hashCode() : 0);
        result = 31 * result + (Pcitydia != null ? Pcitydia.hashCode() : 0);
        result = 31 * result + (Patac != null ? Patac.hashCode() : 0);
        return result;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Laicran     ", "Prix max: 1650 F.CFA", "W 79th St, NY, 10024", "Prix min: 1390 F.CFA", "1650 F.CFA", "1650 F.CFA", "1390 F.CFA"));
        items.add(new Item("Thé Lipton", "Prix max: 2890 F.CFA", "W 36th St, NY, 10015", "Prix min: 2690 F.CFA", "2890 F.CFA", "2790 F.CFA", "2690 F.CFA"));
        items.add(new Item("Savon Lux", "Prix max: 590 F.CFA", "W 36th St, NY, 10029", "Prix min: 550 F.CFA", "590 F.CFA", "610 F.CFA", "550 F.CFA"));
        items.add(new Item("Yaourt Cremor", "Prix max: 247.5 F.CFA", "12th Ave, NY, 10012", "Prix min: 220 F.CFA","247.5 F.CFA", "250 F.CFA", "220 F.CFA"));
        items.add(new Item("Lait Caillé Dolima", "Prix max: 575 F.CFA", "56th Ave, NY, 10041", "Prix min: 500 F.CFA", "575 F.CFA", "550 F.CFA", "220 F.CFA"));
        return items;

    }
}
