

import java.util.Arrays;


public class ConvexPolygon extends Polygon {
    public ConvexPolygon(Vector2D[] vertices) {
        this.vertices = vertices;
    }
    public ConvexPolygon(ConvexPolygon polygon) {
        this.vertices = polygon.vertices;
    }
    @Override
    public double area() {
        double area = 0;
        for (int i = 0; i < vertices.length; i++) {
            area += vertices[i].getX() * vertices[(i+1)%vertices.length].getY() - vertices[i].getY() * vertices[(i+1)%vertices.length].getX();
        }
        area /= 2;
        return Math.abs(area);
    }
    @Override
    public String toString() {
        return "ConvexPolygon{" +
                "vertices=" + Arrays.toString(vertices) +
                '}';
    }
    @Override
    public double perimeter() {
        double perimeter = 0;

        for (int i = 0; i < vertices.length; i++) {
            perimeter += vertices[i].length();
        }
        return perimeter;
    }
    public static double totalArea(Polygon[] polygons){
        double totalArea = 0;
        for (Polygon polygon : polygons) {
            totalArea += polygon.area();
        }
        return totalArea;
    }
    public static Polygon[] somePolygons(){
        Vector2D a = new Vector2D(0, 0);
        Vector2D b = new Vector2D(10, 0);
        Vector2D c =  new Vector2D(5, 5);
        Polygon polygon = new ConvexPolygon(new Vector2D[]{a, b, c});
        System.out.println(polygon);
        return new Polygon[]{polygon};
    }
}


