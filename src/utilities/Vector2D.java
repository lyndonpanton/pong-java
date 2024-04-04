package utilities;

public class Vector2D {
    public double x, y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector2D vO) {
            return this.x == vO.x && this.y == vO.y;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    public Vector2D add(double x, double y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Vector2D add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;

        return this;
    }

    public Vector2D addScaled(Vector2D v, double factor) {
        this.x += (v.x * factor);
        this.y += (v.y * factor);

        return this;
    }

    public double angle() {
//        return Math.acos(dotProduct(this));
        return Math.atan2(this.y, this.x);
    }

    public double angle(Vector2D v) {
        double thisAngle = this.angle();
        double vAngle = v.angle();
        double difference = vAngle - thisAngle;

        if (difference < -Math.PI)
        {
            difference += 2 * Math.PI;
        } else if (difference > Math.PI)
        {
            difference -= 2 * Math.PI;
        }

        return difference;
    }

    /**
     * Given a pair of cartesian coordinates, return a polar coordinate pair
     * @param x
     * @param y
     * @return The polar coordinate pair
     */
    public static Vector2D cartesian(double x, double y) {
        return new Vector2D(
                Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)),
                Math.atan2(y, x)
        );
    }

    public double distance(Vector2D v) {
        double xDifference = Math.abs(this.x - v.x);
        double yDifference = Math.abs(this.y - v.y);

        return Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
    }

    public double dotProduct(Vector2D v) {
        return (this.x * v.x) + (this.y * v.y);
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    public Vector2D multiply(double factor) {
        this.x *= factor;
        this.y *= factor;

        return this;
    }

    public Vector2D normalise() {
        double magnitude = magnitude();

        this.x /= magnitude;
        this.y /= magnitude;

        return this;
    }

    /**
     * Given a pair of polar coordinates, return a cartesian coordinate pair
     * @param angle
     * @param magnitude
     * @return The cartesian coordinate pair
     */
    public static Vector2D polar(double angle, double magnitude) {
        return new Vector2D(
            magnitude * Math.cos(angle),
            magnitude * Math.sin(angle)
        );
    }

//    public Vector2D rotate(double angle) {
//        double rotatedAngle = Math.abs(this.angle() + angle);
//
//        if (rotatedAngle < 0) {
//            rotatedAngle += 2 * Math.PI;
//        } else if (rotatedAngle > 2 * Math.PI) {
//            rotatedAngle -= 2 * Math.PI;
//        }
//
//        double magnitude = magnitude();
//
//        return polar(rotatedAngle, magnitude);
//    }

    public Vector2D set(double x, double y) {
        this.x = x;
        this.y = y;

        return this;
    }

    public Vector2D set(Vector2D v) {
        this.x = v.x;
        this.y = v.y;

        return this;
    }

    public Vector2D subtract(double x, double y) {
        this.x -= x;
        this.y -= y;

        return this;
    }

    public Vector2D subtract(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;

        return this;
    }

    public Vector2D wrap(double w, double h) {
        if (this.x <= 0) {
            this.x += w;
        } else if (this.x >= w) {
            this.x -= w;
        }

        if (this.y <= 0) {
            this.y += h;
        } else if (this.y >= h) {
            this.y -= h;
        }

        return this;
    }
}
