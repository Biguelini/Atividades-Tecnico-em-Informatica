/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programabase3d;

/**
 *
 * @author 2info2021
 */
public class Ponto {
    private double x;
    private double y;
    private double z;
    private boolean pu;
    public Ponto(double x, double y, double z, boolean pu){
        this.x = x;
        this.y =y;
        this.z = z;
        this.pu = pu;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @return the pu
     */
    public boolean isPu() {
        return pu;
    }

    /**
     * @param pu the pu to set
     */
    public void setPu(boolean pu) {
        this.pu = pu;
    }
}
