public class PolarPoint {

    private double rho;
    private double phi;

    private PolarPoint(double rho,
                       double phi) {

        this.phi = phi;
        this.rho = rho;
    }

    double getRho() {
        return this.rho;
    }

    double getPhi() {
        return this.phi;
    }
}
