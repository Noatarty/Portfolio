public class ExBonus {
    public static class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
    public static class Segment {
        private Point point1;
        private Point point2;
        public Segment(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }
        public double getLength() {
            int xDiff = point2.getX() - point1.getX();
            int yDiff = point2.getY() - point1.getY();
            return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        }
    }
    public static class Main {
        public static void main(String[] args) {
            Point point1 = new Point(1, 2);
            System.out.println("Point 1: (" + point1.getX() + ", " + point1.getY() + ")");
            Point point2 = new Point(3, 4);
            Segment segment = new Segment(point1, point2);
            System.out.println("Segment from point 1 to point 2");
            double length = segment.getLength();
            System.out.println("Length: " + length);
        }
    }
}
