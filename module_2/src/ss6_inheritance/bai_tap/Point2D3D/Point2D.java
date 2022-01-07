package ss6_inheritance.bai_tap.Point2D3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(){

    }
    public Point2D(float x, float y){
        this.x =x;
        this.y = y;
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

    public void  setXY(float x,float y){
        this.x= x;
        this.y = y;
    }
    public float[] getXY(float x, float y){
        return new float[]{this.x, this.y};
    }
    public String toString(){
        return "("+x+", "+y+")";
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        Point2D point2D1 =new Point2D(5,6);
        System.out.println(point2D1.toString());
    }
}
