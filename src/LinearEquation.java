class v2 {
    double x;
    double y;
    public v2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public v2 subtract(v2 a) {
        return new v2(x - a.x, y - a.y);
    }
    public double mag() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public String format() {
        return String.format("(%f, %f)", x, y);
    }
}
public class LinearEquation {
    v2 first;
    v2 second;
    public LinearEquation(v2 first, v2 second) {
        this.first = first;
        this.second = second;
    }
    public static v2 parse(String coordinate) {
        String first = coordinate.substring(1, coordinate.indexOf(","));
        String second = coordinate.substring(coordinate.indexOf(",") + 2, coordinate.length() - 1);
        return new v2(Integer.parseInt(first), Integer.parseInt(second));
    }

    public static double roundedToHundreth(double toRound) {
        return Double.parseDouble(String.format("%.2f", toRound));
    }

    public double distance() {
        return first.subtract(second).mag();
    }

    public double slope() {
        v2 line = second.subtract(first);
        return line.y / line.x;
    }

    public double yIntercept() {
        return first.y - (slope() * first.x);
    }

    public String equation() {
        v2 line = second.subtract(first);
        return String.format("y= %s + %f", line.y == 0 ? "" : line.y + "/" + line.x + "x", yIntercept());
    }

    public String coordinateForX(double x) {
        v2 pair = new v2(x, slope() * x + yIntercept());
        return pair.format();
    }
    public String lineInfo() {
        return String.format(
                "The two points are: %s and %s\nThe equation of the line between these points is: %s\nThe slope of this line is: %f\nThe y-intercept of this line is: %f\nThe distance between these points is %f",
                first.format(), second.format(), equation(), slope(), yIntercept(), distance()
        );
    }

    public boolean valid() {
        return !(first.x == second.x);
    }
}
