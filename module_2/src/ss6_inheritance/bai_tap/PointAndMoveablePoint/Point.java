package ss6_inheritance.bai_tap.PointAndMoveablePoint;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(){

    }

    public Point(float x, float y){
        this.x =x;
        this.y =y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.setX(x);
        this.setY(y);
    }
    public float[] getXY(){
        float[] xy = {x,y};
        return xy;
    }

    @Override
    public String toString() {
        return "(" + x +", "+ y +
                ')';
    }

    public static void main(String[] args) {
        Point point =new Point();
        System.out.println(point);

        Point point1 = new Point(5.0f,12.0f);
        System.out.println(point1);
    }
}
