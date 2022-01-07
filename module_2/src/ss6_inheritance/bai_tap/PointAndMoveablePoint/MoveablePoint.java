package ss6_inheritance.bai_tap.PointAndMoveablePoint;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {

    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = {xSpeed, ySpeed};
        return speed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);
    }

    @Override
    public String toString() {
        return super.toString() + ", speed = " + Arrays.toString(getSpeed());
    }

    public MoveablePoint move() {
        super.setX(getX() + getxSpeed());
        super.setY(getY() + getySpeed());
        return this;
    }

    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);

        MoveablePoint moveablePoint1 = new MoveablePoint(5.0f,12.0f);
        System.out.println(moveablePoint1);

        MoveablePoint moveablePoint2 =new MoveablePoint(4.0f, 9.0f,13.0f,20.0f);
        System.out.println(moveablePoint2);
        System.out.println(moveablePoint2.move());
    }
}

