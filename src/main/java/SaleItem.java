import java.io.Serializable;

public class SaleItem implements Serializable {

    private String title;
    private String count;
    private String price;
    private String discount;
    private String sum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", count='" + count + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }
}
