package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Iterator;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character> {
  private char[] base;

  public StdString1(char[] base) {
    this.base = base.clone();
  }

  public StdString1() {
    base = new char[0];
  }

  public StdString1(StdString1 stdString1) {
    base = stdString1.base.clone();
    new StdString1(base);
  }

  @Override
  public Iterator<Character> iterator() {
    return new Iterator<>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < base.length;
      }

      @Override
      public Character next() {
        return base[index++];
      }
    };
  }

  public int length() {
    return base.length;
  }

  public char[] toCharArray() {
    char[] result = new char[base.length];
    System.arraycopy(base, 0, result, 0, base.length);
    return result;
  }

  public char charAt(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= base.length) {
      throw new IndexOutOfBoundsException();
    }
    return base[index];
  }

  public int indexOf(char target) {
    for (int i = 0; i < base.length; i++) {
      if (base[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public boolean equals(final Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (otherObject == null || getClass() != otherObject.getClass()) {
      return false;
    }
    StdString1 stdString1 = (StdString1) otherObject;
    if (base.length != stdString1.base.length) {
      return false;
    }
    for (int i = 0; i < stdString1.base.length; i++) {
      if (base[i] != stdString1.base[i]) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    if (base.length == 0) {
      return 0;
    }
    int sum = 0;
    for (char c : base) {
      sum += c;
    }
    return sum;
  }

  public String toString() {
    return new String(base);
  }

  public void forEach(final Consumer<? super Character> action) {
    for (char i : base) {
      action.accept(i);
    }
  }

  public StdString1 append(StdString1 stdString1) {
    char[] resChar = new char[base.length + stdString1.length()];
    int i = 0;
    Iterator<Character> stdIter = stdString1.iterator();
    Iterator<Character> baseIter = iterator();

    while (i < resChar.length) {
      if (baseIter.hasNext()) {
        resChar[i++] = baseIter.next();
      } else {
        resChar[i++] = stdIter.next();
      }
    }
    return new StdString1(resChar);
  }
}