/* 63010035 Kitsadag Sawangsiripol */

package lsp;
public class Main {

    private static final int width = 4;
    private static final int height = 5;

    public static void main(String[] args) {
        Shape reg1 = new Rectangle(width, height);
        System.out.println("==== Rectangle ====");
        System.out.println("Width = " + width);
        System.out.println("Height = " + height);
        System.out.println("Area = " + reg1.getArea());

        Shape reg2 = new Square(width);
        System.out.println("====   Square  ====");
        System.out.println("Width = " + width);
        System.out.println("Area = " + reg2.getArea());
        reg2.setHeight(height);
        System.out.println("height = " + height);
        System.out.println("Area = " + reg2.getArea());
    }
}
