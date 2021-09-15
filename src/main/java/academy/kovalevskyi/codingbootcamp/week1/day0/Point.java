package academy.kovalevskyi.codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {
  private int coordinateX;
  private int coordinateY;

  public Point(final int coordinateX, final int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  public int getX() {
    return coordinateX;
  }

  public int getY() {
    return coordinateY;
  }

  public Point sum(final Point that) {
    return new Point(getX() + that.getX(), getY() + that.getY());
  }

  public Point updateX(int newX) {
    return new Point(newX, getY());
  }

  public Point updateY(int newY) {
    return new Point(getX(), newY);
  }

  public int distanceTo(Point that) {
    int distanceX = getX() - that.getX();
    int distanceY = getY() - that.getY();
    int distanceSquareX = distanceX * distanceX;
    int distanceSquareY = distanceY * distanceY;
    return distanceSquareX + distanceSquareY;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o == null || getClass() != o.getClass()) {
      return false;
    } else {
      Point point = (Point) o;
      return getX() == point.getX() && getY() == point.getY();
    }
  }

  public int hashCode() {
    return getX() + getY();
  }

  public String toString() {
    return String.format("Point{X: %d, Y: %d}", getX(), getY());
  }

  public int compareTo(Point that) {
    return (this.getX() + this.getY()) - (that.getX() + that.getY());
  }
}
