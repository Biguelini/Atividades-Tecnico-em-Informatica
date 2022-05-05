/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programabase3d;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

/**
 *
 * @author 2info2021
 */
public class Desenho3D {

    double xwmax, xwmin, ywmax, ywmin, zwmax, zwmin, xvmax, xvmin, yvmax, yvmin, zvmax, zvmin;
    double xmax, ymax, xcoord, ycoord, zcoord;
    private double centrox;
    private double centroy;
    double xd, yd;
    Vector desenho = new Vector();

    public void setMundo(double x1, double y1, double z1, double x2, double y2, double z2) {
        xwmax = x2;
        ywmax = y2;
        zwmax = z2;
        xwmin = x1;
        ywmin = y1;
        zwmin = z1;
        setCentrox((x1 + x2) / 2);
        centroy = (y1 + y2) / 2;
    }

    public void setViewPort(double x1, double y1, double x2, double y2) {
        xvmax = x2;
        yvmax = y2;
        xvmin = x1;
        yvmin = y1;
    }

    public void setDimension(Dimension dim) {
        xmax = dim.width;
        ymax = dim.height;
    }

    private void mapCoord(double x, double y, double z) {
        double zv;
        if (z < 0) {
            zv = 1 / (1 + Math.abs(z) / (zwmax - zwmin));
        } else {
            zv = (1 + Math.abs(z) / (zwmax - zwmin));
        }
        x = x / zv;
        y = y / zv;
        double xv = (((x - xwmin) * ((xvmax - xvmin) / (xwmax - xwmin))) + xvmin);
        double yv = (((y - ywmin) * ((yvmax - yvmin) / (ywmax - ywmin))) + yvmin);
        xd = xv * xmax;
        yd = yv * ymax;
    }
    
    private void linhaAte(Graphics g, double x, double y, double z) {
        double xi, yi;
        mapCoord(xcoord, ycoord, zcoord);
        xi = xd;
        yi = yd;
        mapCoord(x, y, z);
        g.drawLine((int) xi, (int) yi, (int) xd, (int) yd);
        xcoord = x;
        ycoord = y;
        zcoord = z;
    }
    private void movaPAra(Graphics g, double x, double y, double z, boolean pu){
        if(pu){
            xcoord = x;
            ycoord = y;
            zcoord = z;
        } else {
            linhaAte(g, x, y, z);
        }
    }
    
    public void desenha(Graphics g){
        Ponto p;
        for (int i = 0; i <desenho.size(); i++){
            p = (Ponto) desenho.get(i);
            movaPAra(g, p.getX(), p.getY(), p.getZ(), p.isPu());
        }
    }
    public void cubo(){
        desenho.addElement(new Ponto(11, 10, 1, true));
        desenho.addElement(new Ponto(11, 11, 1, false));
        desenho.addElement(new Ponto(12, 11, 1, false));
        desenho.addElement(new Ponto(12, 10, 1, false));
        desenho.addElement(new Ponto(11, 10, 1, false));
        desenho.addElement(new Ponto(11, 10, 2, false));
        desenho.addElement(new Ponto(11, 11, 2, false));
        desenho.addElement(new Ponto(12, 11, 2, false));
        desenho.addElement(new Ponto(12, 10, 2, false));
        desenho.addElement(new Ponto(11, 10, 2, false));
        desenho.addElement(new Ponto(11, 11, 2, false));
        desenho.addElement(new Ponto(11, 11, 1, false));
        desenho.addElement(new Ponto(12, 11, 1, false));
        desenho.addElement(new Ponto(12, 11, 2, false));
        desenho.addElement(new Ponto(12, 10, 2, false));
        desenho.addElement(new Ponto(12, 10, 1, false));
        
    }
    
    public void translada(double dx, double dy, double dz) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
            p.setZ(p.getZ() + dz);
            desenho.set(i, p);
        }
    }
    
    public void rotaciona(double h, double q, double b) {
        double m[][] = new double [4][4];
        double ch = Math.cos(h);
        double cp = Math.cos(q);
        double cb = Math.cos(b);
        double sh = Math.sin(h);
        double sp = Math.sin(q);
        double sb = Math.sin(b);
        m[1][1] = ch * cb - sh * sp * sb;
        m[1][2] = sb * ch + cb * sp * sh;
        m[1][3] = -cp * sh;
        m[2][1] = -sb * cp;
        m[2][2] = cb * cp;
        m[2][3] = sp;
        m[3][1] = cb * sh + sb * sp * ch;
        m[3][2] = sb * sh - cb * sp * ch;
        m[3][3] = ch * cp;
        
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            double x = p.getX();
            double y = p.getY();
            double z = p.getZ();
            double xx = (x * m[1][1] + y * m[1][2] + z * m[1][3]);
            double yy = (x * m[2][1] + y * m[2][2] + z * m[2][3]);
            double zz = (x * m[3][1] + y * m[3][2] + z * m[3][3]);
            p.setX(xx);
            p.setY(yy);
            p.setZ(zz);
            desenho.set(i, p);
        }
    }
    
    public void deforma(boolean maior) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            if (maior) {
                p = (Ponto) desenho.get(i);
                p.setX(((p.getX() - getCentrox()) * 0.1) + p.getX());
                p.setY(((p.getY() - getCentroy()) * 0.1) + p.getY());
                p.setZ((p.getZ() * 0.1) + p.getZ());
                desenho.set(i, p);
            } else {
                p = (Ponto) desenho.get(i);
                p.setX(p.getX() - ((p.getX() - getCentrox()) * 0.1));
                p.setY(p.getY() - ((p.getY() - getCentroy()) * 0.1));
                p.setZ(p.getZ() - (p.getZ() * 0.1));
                desenho.set(i, p);
            }
        }
    }
    
    public double getCentroy() {
        return centroy;
    }
    public void setCentroy(double centroy){
        this.centroy = centroy;
    }

    /**
     * @return the centrox
     */
    public double getCentrox() {
        return centrox;
    }

    /**
     * @param centrox the centrox to set
     */
    public void setCentrox(double centrox) {
        this.centrox = centrox;
    }
}
