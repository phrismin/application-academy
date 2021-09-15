package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;

public class PointWithLabel extends PointWithValue<String> {

  public PointWithLabel(int coordinateX, int coordinateY, String value) {
    super(coordinateX, coordinateY, value);
  }

  public String getLabel() {
    return (String) getValue();
  }

  public int compareTo(Point other) {
    if (other.getClass() != this.getClass()) {
      return super.compareTo(other);
    }
    PointWithLabel pointWithLabel = (PointWithLabel) other;
    return this.getLabel().compareTo(pointWithLabel.getLabel());
  }
}
