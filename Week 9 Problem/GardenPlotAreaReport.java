import java.util.*;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
    abstract String shape();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Plot> plots = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            String owner = parts[1];

            if (type.equals("CIRCLE")) {
                plots.add(new CirclePlot(owner, Double.parseDouble(parts[2])));
            } else if (type.equals("RECTANGLE")) {
                plots.add(new RectanglePlot(owner,
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])));
            } else if (type.equals("TRIANGLE")) {
                plots.add(new TrianglePlot(owner,
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3])));
            }
        }

        for (Plot p : plots) {
            double area = p.area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), area);
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
