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
}
