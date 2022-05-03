public class Body {

    double xxPos; //Its current x position
    double yyPos; //Its current y position
    double xxVel; // Its current velocity in the x direction
    double yyVel; // Its current velocity in the y direction
    double mass; // Its mass
    String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;

        if(this.equals(b.mass)){
            return;
        }

    }

    public double calcDistance(Body b) {
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        double r = Math.hypot(dx, dy); //直角三角形,求其斜边的长度。
        return r;
    }

    public double calcForceExertedBy(Body b) {
        double G = 6.67e-11;
        double F = (G * this.mass * b.mass) / Math.pow(this.calcDistance(b), 2);
        return F;
    }

    public double calcForceExertedByX(Body b) {
        double F = this.calcForceExertedBy(b);
        double dx = (this.xxPos - b.xxPos);
        double r = this.calcDistance(b);
        double Fx=F*dx/r;
        return Fx;
    }

    public double calcForceExertedByY(Body b) {
        double F = this.calcForceExertedBy(b);
        double dy = (this.yyPos - b.yyPos);
        double r = this.calcDistance(b);
        double Fy=F*dy/r;
        return Fy;
    }


    public double calcNetForceExertedByX(Body[] bs) {
        double FxNet = 0;
        for (Body b : bs) {
            if (!this.equals(b)) {
                FxNet += this.calcForceExertedByX(b);
            }
        }
        return FxNet;
    }

    public double calcNetForceExertedByY(Body[] bs) {
        double FyNet = 0;
        for (Body b : bs) {
            if (!this.equals(b)) {
                FyNet += this.calcForceExertedByY(b);
            }
        }
        return FyNet;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    /**
     * Draw the picture of the Body according to its position
     */


}







