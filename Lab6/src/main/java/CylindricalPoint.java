public class CylindricalPoint {

    private double rho;
    private double phi;
    private double z;

    CylindricalPoint(double rho,
                     double phi,
                     double z) {

        this.phi = phi;
        this.rho = rho;
        this.z = z;
    }

    double getRho() {
        return this.rho;
    }

    double getPhi() {
        return this.phi;
    }

    double getZ() {
        return this.z;
    }

    Point toCartessian() {
        double convertFromX = this.rho * Math.cos(this.phi);
        double convertFromY = this.rho * Math.sin(this.phi);

        return new Point(convertFromX, convertFromY, this.z);
    }
}
