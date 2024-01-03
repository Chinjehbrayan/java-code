
// A class to represent a point in a 2D plane
class Point {
  private double x; // the x-coordinate
  private double y; // the y-coordinate

  // A constructor to initialize the point
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // A getter method for the x-coordinate
  public double getX() {
    return x;
  }

  // A getter method for the y-coordinate
  public double getY() {
    return y;
  }
}

// A class to represent a quadrilateral
class Quadrilateral {
  private Point p1; // the first point
  private Point p2; // the second point
  private Point p3; // the third point
  private Point p4; // the fourth point

  // A constructor to initialize the quadrilateral
  public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }

  // A getter method for the first point
  public Point getP1() {
    return p1;
  }

  // A getter method for the second point
  public Point getP2() {
    return p2;
  }

  // A getter method for the third point
  public Point getP3() {
    return p3;
  }

  // A getter method for the fourth point
  public Point getP4() {
    return p4;
  }
}

// A class to represent a trapezoid, which is a subclass of quadrilateral
class Trapezoid extends Quadrilateral {
  // A constructor to initialize the trapezoid
  public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4); // invoke the superclass constructor
  }

  // A method to calculate the height of the trapezoid
  public double getHeight() {
    // Use the distance formula to find the length of the perpendicular line between the two bases
    double x1 = getP1().getX(); // the x-coordinate of the first point
    double y1 = getP1().getY(); // the y-coordinate of the first point
    double x2 = getP2().getX(); // the x-coordinate of the second point
    double y2 = getP2().getY(); // the y-coordinate of the second point
    double x3 = getP3().getX(); // the x-coordinate of the third point
    double y3 = getP3().getY(); // the y-coordinate of the third point
    double x4 = getP4().getX(); // the x-coordinate of the fourth point
    double y4 = getP4().getY(); // the y-coordinate of the fourth point

    // Find the slope and the intercept of the line passing through the first and the second point
    double m1 = (y2 - y1) / (x2 - x1); // the slope
    double b1 = y1 - m1 * x1; // the intercept

    // Find the slope and the intercept of the line passing through the third and the fourth point
    double m2 = (y4 - y3) / (x4 - x3); // the slope
    double b2 = y3 - m2 * x3; // the intercept

    // Find the x-coordinate of the intersection point of the two lines
    double x = (b2 - b1) / (m1 - m2);

    // Find the y-coordinate of the intersection point of the two lines
    double y = m1 * x + b1;

    // Find the distance between the intersection point and the first point
    double height = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));

    // Return the height
    return height;
  }

  // A method to calculate the area of the trapezoid
  public double getArea() {
    // Use the distance formula to find the length of the two bases
    double base1 = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2)); // the length of the first base
    double base2 = Math.sqrt(Math.pow(getP3().getX() - getP4().getX(), 2) + Math.pow(getP3().getY() - getP4().getY(), 2)); // the length of the second base

    // Use the formula for the area of a trapezoid: A = (b1 + b2) * h / 2
    double area = (base1 + base2) * getHeight() / 2;

    // Return the area
    return area;
  }
}

// A class to represent a parallelogram, which is a subclass of trapezoid
class Parallelogram extends Trapezoid {
  // A constructor to initialize the parallelogram
  public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4); // invoke the superclass constructor
  }

  // A method to calculate the area of the parallelogram
  public double getArea() {
    // Use the distance formula to find the length of the base
    double base = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2)); // the length of the base

    // Use the formula for the area of a parallelogram: A = b * h
    double area = base * getHeight();

    // Return the area
    return area;
  }
}

// A class to represent a rectangle, which is a subclass of parallelogram
class Rectangle extends Parallelogram {
  // A constructor to initialize the rectangle
  public Rectangle(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4); // invoke the superclass constructor
  }

  // A method to calculate the area of the rectangle
  public double getArea() {
    // Use the distance formula to find the length and the width of the rectangle
    double length = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2)); // the length of the rectangle
    double width = Math.sqrt(Math.pow(getP1().getX() - getP4().getX(), 2) + Math.pow(getP1().getY() - getP4().getY(), 2)); // the width of the rectangle

    // Use the formula for the area of a rectangle: A = l * w
    double area = length * width;

    // Return the area
    return area;
  }
}

// A class to represent a square, which is a subclass of rectangle
class Square extends Rectangle {
  // A constructor to initialize the square
  public Square(Point p1, Point p2, Point p3, Point p4) {
    super(p1, p2, p3, p4); // invoke the superclass constructor
  }

  // A method to calculate the area of the square
  public double getArea() {
    // Use the distance formula to find the side of the square
    double side = Math.sqrt(Math.pow(getP1().getX() - getP2().getX(), 2) + Math.pow(getP1().getY() - getP2().getY(), 2)); // the length of the side

    // Use the formula for the area of a square: A = s^2
    double area = Math.pow(side, 2);

    // Return the area
    return area;
  }
}

// A class to test the inheritance hierarchy
class Test {
  public static void main(String[] args) {
    // Create some points
    Point p1 = new Point(0, 0);
    Point p2 = new Point(10, 0);
    Point p3 = new Point(10, 5);
    Point p4 = new Point(0, 5);
    Point p5 = new Point(5, 10);
    Point p6 = new Point(15, 10);

    // Create some shapes
    Quadrilateral q = new Quadrilateral(p1, p2, p3, p4);
    Trapezoid t = new Trapezoid(p1, p2, p6, p5);
    Parallelogram p = new Parallelogram(p1, p2, p3, p4);
    Rectangle r = new Rectangle(p1, p2, p3, p4);
    Square s = new Square(p1, p2, p3, p4);

    // Output the area of each shape (except Quadrilateral)
    System.out.println("The area of the trapezoid is " + t.getArea());
    System.out.println("The area of the parallelogram is " + p.getArea());
    System.out.println("The area of the rectangle is " + r.getArea());
    System.out.println("The area of the square is " + s.getArea());
  }
}