import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class CafeSystem
{
    static Vector <Menu> hot_drink = new Vector<Menu>();
    static Vector <Menu> ice_drink = new Vector<Menu>();
    static Vector <Menu> ade_drink = new Vector<Menu>();
    static Vector <Menu> dessert = new Vector<Menu>();
    static Vector <Menu> order = new Vector<Menu>();
    static Vector <Integer> price = new Vector<Integer>();

    static void new_Hot_Drink(String product_name, int price){
        Menu new_Hot_Drink = new Menu(product_name, price);
        CafeSystem.addToHotDrink(new_Hot_Drink);
    }
    static void new_Ice_Drink(String product_name, int price) {
        Menu new_Ice_Drink = new Menu(product_name,price);
        CafeSystem.addToIceDrink(new_Ice_Drink);
    }

    static void new_Ade_Drink(String product_name, int price) {
        Menu new_Ade_Drink = new Menu(product_name,price);
        CafeSystem.addToAdeDrink(new_Ade_Drink);
    }

    static void new_Dessert(String product_name, int price) {
        Menu new_Dessert = new Menu(product_name,price);
        CafeSystem.addToDessert(new_Dessert);
    }
    static Integer new_Price(int price) {
        Integer new_Price = new Integer(price);
        CafeSystem.addToPrice(new_Price);
        return new_Price;
    }

    static  String total_Price(int sum) {
        sum = 0;
        int m;
        for(int i = 0; i < CafeSystem.getNumPrices() ; i++) {
            m = CafeSystem.getPrice(i);
            sum = sum + m;
        }
        return "총 가격 :" + sum + "원\n\n";
    }
    static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight){
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private static void addToPrice(Integer new_Price) {
        price.add(new_Price);
    }

    private static void addToDessert(Menu new_Dessert) {
        dessert.add(new_Dessert);
    }

    private static void addToAdeDrink(Menu new_Ade_Drink) {
        ade_drink.add(new_Ade_Drink);
    }

    private static void addToIceDrink(Menu new_Ice_Drink) {
        ice_drink.add(new_Ice_Drink);
    }

    private static void addToHotDrink(Menu new_Hot_Drink) {
        hot_drink.add(new_Hot_Drink);

    }

    static void setupMenu() {
        CafeSystem.new_Hot_Drink("(Hot)아메리카노", 4000);
        CafeSystem.new_Hot_Drink("(Hot)카푸치노", 4900);
        CafeSystem.new_Hot_Drink("(Hot)에스프레소", 4500);
        CafeSystem.new_Hot_Drink("(Hot)핫초코", 4200);
        CafeSystem.new_Hot_Drink("(Hot)얼그레이티", 4400);
        CafeSystem.new_Hot_Drink("(Hot)루이보스티", 4400);

        CafeSystem.new_Ice_Drink("(ICE)아메리카노", 4500);
        CafeSystem.new_Ice_Drink("(ICE)카페라떼", 5400);
        CafeSystem.new_Ice_Drink("(ICE)돌체라떼", 5100);
        CafeSystem.new_Ice_Drink("(ICE)카라멜마끼아또", 4900);
        CafeSystem.new_Ice_Drink("(ICE)콜드브루", 5100);
        CafeSystem.new_Ice_Drink("(ICE)아이스티", 4000);

        CafeSystem.new_Ade_Drink("레몬에이드", 4800);
        CafeSystem.new_Ade_Drink("자몽에이드", 5100);
        CafeSystem.new_Ade_Drink("블루레몬에이드", 5300);
        CafeSystem.new_Ade_Drink("청포도에이드", 4900);
        CafeSystem.new_Ade_Drink("메가에이드", 5000);
        CafeSystem.new_Ade_Drink("핑크에이드", 4700);

        CafeSystem.new_Dessert("초코케이크 (1조각)", 5300);
        CafeSystem.new_Dessert("딸기케이크 (1조각)", 6200);
        CafeSystem.new_Dessert("티라미수 (1조각)", 6500);
        CafeSystem.new_Dessert("샌드위치 (1조각)", 5500);
        CafeSystem.new_Dessert("베이글 (1조각)", 5500);
        CafeSystem.new_Dessert("샐러드", 6400);
    }
/*

    @SuppressWarnings("unused")
    private static void new_Order_HotDrink(Menu new_Hot_Drink) {
        order.add(new_Hot_Drink);
    }
*/

    static void Customer_order() {
        Menu m;
        System.out.println("\n--모든 주문 리스트 --");
        for(int i=0; i<CafeSystem.getNumOrders(); i++) {
            m=CafeSystem.getOrder(i);
            System.out.print(i+1+". ");
            m.orderDetail();
        }
    }
    static Menu getOrder(int witch) {
        return order.elementAt(witch);
    }
    static int getNumOrders() {
        return order.size();
    }
    static int getNumPrices() {
        return price.size();
    }
    static Integer getPrice(int witch) {
        return price.elementAt(witch);
    }
    static Integer get_Price(int witch) {
        return price.get(witch);
    }

    public static void main(String[] args) {
        Customer_order();
        price.get(1);
    }
}