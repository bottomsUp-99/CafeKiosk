public class Menu
{
    String product_name;
    int price;
    public Menu(){
    }
    public Menu(String procduct_name, int price){
        this.product_name = procduct_name;
        this.price = price;
    }
    public Menu(int price){
        this.price = price;
    }
    public String toString(){
        return "주문하신 상품 :" + product_name + "           상품의 가격:" + price + "\n";
    }
    public void orderDetail(){
        System.out.println(toString());
    }
}