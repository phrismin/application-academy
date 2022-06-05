package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

import java.util.Iterator;

public class StdString2 extends StdString1 {

    public StdString2(char[] base) {
        super(base);
    }

    public StdString2() {
    }

    public StdString2(StdString2 that) {
        super(that);
    }

    public StdString2 toAsciiLowerCase() throws IllegalArgumentException {
        int i = 0;
        char[] chars = super.toCharArray();
        Iterator<Character> iterator = super.iterator();
        while (iterator.hasNext()) {
            chars[i++] = StringUtils.toAsciiLowercase(iterator.next());
        }
        return new StdString2(chars);
    }

    public StdString2 toAsciiUpperCase() throws IllegalArgumentException {
        int i = 0;
        char[] chars = super.toCharArray();
        Iterator<Character> iterator = super.iterator();
        while (iterator.hasNext()) {
            chars[i++] = StringUtils.toAsciiUppercase(iterator.next());
        }
        return new StdString2(chars);
    }

    public StdString2 subString(int from, int to) throws IndexOutOfBoundsException,
            IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException();
        }
        char[] chars = super.toCharArray();
        if (from < 0 || to > chars.length) {
            throw new IndexOutOfBoundsException();
        }
        char[] resultChar = new char[to - from];
        int count = 0;
        for (int i = from; i < to; i++) {
            resultChar[count++] = chars[i];
        }
        return new StdString2(resultChar);
    }

    public StdString2 concat(StdString2... that) throws IllegalArgumentException {
        if (that == null) {
            throw new IllegalArgumentException();
        }
        StdString1 stdString1 = new StdString1(super.toCharArray());
        for (StdString1 s : that) {
            stdString1 = stdString1.append(s);
        }
        return new StdString2(stdString1.toCharArray());
    }

    public StdString2[] split(char separator) {
        char[] chars = super.toCharArray();
        int countSep = 0;
        int start = 0;
        int end = 0;
        for (; end < chars.length; end++) {
            if (chars[end] == separator) {
                countSep++;
                if (end != start) {
                    start = end + 1;
                }
            }
        }

        StdString2[] result = new StdString2[countSep + 1];
        StdString2 stdString2 = new StdString2(super.toCharArray());
        start = 0;
        end = 0;
        int item = 0;
        for (; end < chars.length; end++) {
            if (chars[end] == separator) {
                if (end == start) {
                    result[item++] = new StdString2(new char[0]);
                } else {
                    result[item++] = stdString2.subString(start, end);
                }
                start = end + 1;
            }
        }

        if (start != end) {
            result[item] = stdString2.subString(start, end);
        }

        item = 1;
        StdString2[] result2 = new StdString2[0];
        StdString2 string2Empty = new StdString2(new char[0]);
        end = result.length - 1;
        while (result[end] == null || result[end].equals(string2Empty)) {
            result2 = new StdString2[result.length - item++];
            System.arraycopy(result, 0, result2, 0, result2.length);
            end--;
        }

        return item == 1 ? result : result2;
    }

    public StdString2 trim() {
        int left = 0;
        int right = length();
        while (left < right && charAt(left) == ' ') {
            left++;
        }
        while (right > left && charAt(right - 1) == ' ') {
            right--;
        }
        return left > 0 || right > 0 ? subString(left, right) : new StdString2(this);
    }

    public StdString2 removeCharacter(char toRemove) {
        int endIndex = 0;
        int startIndex = 0;
        int length = length();
        StdString1 result = new StdString1();
        while (endIndex < length) {
            if (charAt(endIndex) == toRemove) {
                result = result.append(subString(startIndex, endIndex));
                startIndex = endIndex + 1;
            }
            endIndex++;
        }
        if (startIndex != endIndex) {
            result = result.append(subString(startIndex, endIndex));
        }
        return endIndex == length ? new StdString2(result.toCharArray()) : new StdString2(this);
    }
}