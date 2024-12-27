package week.week.year2023;

public class 圆和矩形是否有重叠 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = 0, y = 0;
        if (xCenter < x1 || xCenter > x2)
            x = Math.min(Math.abs(xCenter - x1), Math.abs(xCenter - x2));
        if (yCenter < y1 || yCenter > y2)
            y = Math.min(Math.abs(yCenter - y1), Math.abs(yCenter - y2));
        return x * x + y * y <= radius * radius;
    }
}
