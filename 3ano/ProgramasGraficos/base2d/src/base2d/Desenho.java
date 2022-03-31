/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base2d;

/**
 *
 * @author 2info2021
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

public class Desenho {

    private double xwmax, xwmin, ywmax, ywmin, xvmax, xvmin, yvmax, yvmin;
    private double xmax, ymax, xcoord, ycoord, xd, yd, mx, my;
    Vector desenho = new Vector();

    public void setMundo(double x1, double y1, double x2, double y2) {
        xwmax = x2;
        ywmax = y2;
        xwmin = x1;
        ywmin = y1;
    }

    public void setDimension(Dimension d) {
        xmax = d.width;
        ymax = d.height;
    }

    public double getMouseX() {
        return mx;
    }

    public double getMouseY() {
        return my;
    }

    public void setMouse(int x, int y) {
        mx = (((x - xvmin) / ((xvmax - xvmin) / (xwmax - xwmin))) + xwmin) / xmax;
        my = (((y - yvmin) / ((yvmax - yvmin) / (ywmax - ywmin))) + ywmin) / ymax;
    }

    public void setViewPort(double x1, double y1, double x2, double y2) {
        xvmax = x2;
        yvmax = y2;
        xvmin = x1;
        yvmin = y1;
    }

    private void mapCoord(double x, double y) {
        double xv = (((x - xwmin) * ((xvmax - xvmin) / (xwmax - xwmin))) + xvmin);
        double yv = (((y - ywmin) * ((yvmax - yvmin) / (ywmax - ywmin))) + yvmin);
        xd = xv * xmax;
        yd = yv * ymax;

    }

    private void linhaAte(Graphics g, double x, double y) {
        double xi, yi;
        mapCoord(xcoord, ycoord);
        xi = xd;
        yi = yd;
        mapCoord(x, y);
        g.drawLine((int) xi, (int) yi, (int) xd, (int) yd);
        xcoord = x;
        ycoord = y;
    }

    private void movaPara(Graphics g, double x, double y, boolean pu) {
        if (pu) {
            xcoord = x;
            ycoord = y;
        } else {
            linhaAte(g, x, y);
        }
    }

    public void desenha(Graphics g) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            movaPara(g, p.getX(), p.getY(), p.isPu());
        }
    }

    public void triangulo() {
        desenho.addElement(new Ponto(10d, 9d, true));
        desenho.addElement(new Ponto(9d, 11d, false));
        desenho.addElement(new Ponto(11d, 11d, false));
        desenho.addElement(new Ponto(10d, 9d, false));
    }

    public void quadrado() {
        desenho.addElement(new Ponto(11, 9, true));;
        desenho.addElement(new Ponto(9, 9, false));
        desenho.addElement(new Ponto(9, 11, false));
        desenho.addElement(new Ponto(11, 11, false));
        desenho.addElement(new Ponto(11, 9, false));
    }
    public void espada() {
        desenho.addElement(new Ponto(12d, 9d, true));;
        desenho.addElement(new Ponto(8.3d, 9d, false));
        desenho.addElement(new Ponto(8.3d, 8d, false));
        desenho.addElement(new Ponto(8.15d, 7.8d, false));
        desenho.addElement(new Ponto(8d, 8d, false));
        desenho.addElement(new Ponto(8d, 9d, false));
        desenho.addElement(new Ponto(7d, 9d, false));
        desenho.addElement(new Ponto(7d, 9.5d, false));
        desenho.addElement(new Ponto(8d, 9.5d, false));
        desenho.addElement(new Ponto(8d, 10.5d, false));
        desenho.addElement(new Ponto(8.15d, 10.7d, false));
        desenho.addElement(new Ponto(8.3d, 10.5d, false));
        desenho.addElement(new Ponto(8.3d, 9d, false));
        desenho.addElement(new Ponto(8.3d, 9.5d, false));
        desenho.addElement(new Ponto(12d, 9.5d, false));
        desenho.addElement(new Ponto(13d, 9.25d, false));
        desenho.addElement(new Ponto(12d, 9d, false));
        desenho.addElement(new Ponto(13d, 9.25d, false));
        desenho.addElement(new Ponto(8.3d, 9.25d, false));
    }
    public void bigue(){
        
        
        
        
        desenho.addElement(new Ponto(2.8d, 10d, true));
        desenho.addElement(new Ponto(2.8d, 10d, false));
        desenho.addElement(new Ponto(2.8d, 6d, false));
        desenho.addElement(new Ponto(3.8d, 6d, false));
        desenho.addElement(new Ponto(3.8d, 8d, false));
        desenho.addElement(new Ponto(2.8d, 8d, false));
        desenho.addElement(new Ponto(4d, 8d, false));
        desenho.addElement(new Ponto(4d, 10d, false));
        desenho.addElement(new Ponto(2.8d, 10d, false));
        desenho.addElement(new Ponto(5d, 10d, true));
        desenho.addElement(new Ponto(5d, 10d, false));
        desenho.addElement(new Ponto(5d, 6d, false));
        desenho.addElement(new Ponto(5d, 10d, false));
        desenho.addElement(new Ponto(6d, 10d, true));
        desenho.addElement(new Ponto(6d, 10d, false));
        desenho.addElement(new Ponto(6d, 6d, false));
        desenho.addElement(new Ponto(7d, 6d, false));
        desenho.addElement(new Ponto(6d, 6d, false));
        desenho.addElement(new Ponto(6d, 10d, false));
        desenho.addElement(new Ponto(7d, 10d, false));
        desenho.addElement(new Ponto(7d, 8d, false));
        desenho.addElement(new Ponto(6.5d, 8d, false));
        desenho.addElement(new Ponto(7d, 8d, false));
        desenho.addElement(new Ponto(7d, 10d, false));
        desenho.addElement(new Ponto(8d, 10d, true));
        desenho.addElement(new Ponto(8d, 10d, false));
        desenho.addElement(new Ponto(8d, 6d, false));
        desenho.addElement(new Ponto(8d, 10d, false));
        desenho.addElement(new Ponto(9d, 10d, false));
        desenho.addElement(new Ponto(9d, 6d, false));
        desenho.addElement(new Ponto(9d, 10d, false));
        desenho.addElement(new Ponto(10d, 10d, true));
        desenho.addElement(new Ponto(10d, 10d, false));
        desenho.addElement(new Ponto(10d, 6d, false));
        desenho.addElement(new Ponto(11d, 6d, false));
        desenho.addElement(new Ponto(10d, 6d, false));
        desenho.addElement(new Ponto(10d, 8d, false));
        desenho.addElement(new Ponto(11d, 8d, false));
        desenho.addElement(new Ponto(10d, 8d, false));
        desenho.addElement(new Ponto(10d, 10d, false));
        desenho.addElement(new Ponto(11d, 10d, false));
        desenho.addElement(new Ponto(12d, 10d, true));
        desenho.addElement(new Ponto(12d, 10d, false));
        desenho.addElement(new Ponto(12d, 6d, false));
        desenho.addElement(new Ponto(12d, 10d, false));
        desenho.addElement(new Ponto(13d, 10d, false));
        desenho.addElement(new Ponto(14d, 10d, true));
        desenho.addElement(new Ponto(14d, 10d, false));
        desenho.addElement(new Ponto(14d, 6d, false));
        desenho.addElement(new Ponto(14d, 10d, false));
        desenho.addElement(new Ponto(15d, 10d, true));
        desenho.addElement(new Ponto(15d, 10d, false));
        desenho.addElement(new Ponto(15d, 6d, false));
        desenho.addElement(new Ponto(16d, 10d, false));
        desenho.addElement(new Ponto(16d, 6d, false));
        desenho.addElement(new Ponto(16d, 10d, false));
        desenho.addElement(new Ponto(17d, 10d, true));
        desenho.addElement(new Ponto(17d, 10d, false));
        desenho.addElement(new Ponto(17d, 6d, false));
    }
    
    public void rosto(){
        desenho.addElement(new Ponto(2d, 6d, true));
        desenho.addElement(new Ponto(2d, 6d, false));
        desenho.addElement(new Ponto(2d, 14d, false));
        desenho.addElement(new Ponto(4d, 16d, false));
        desenho.addElement(new Ponto(5d, 16d, false));
        desenho.addElement(new Ponto(7d, 14d, false));
        desenho.addElement(new Ponto(7d, 6d, false));
        desenho.addElement(new Ponto(8d,3d, false));
        desenho.addElement(new Ponto(6d,4.5d, false));
        desenho.addElement(new Ponto(6.5d,2d, false));
        desenho.addElement(new Ponto(4d,4.5d, false));
        desenho.addElement(new Ponto(4.5d,2d, false));
        desenho.addElement(new Ponto(2d, 6d, false));
        desenho.addElement(new Ponto(3d, 8d, true));
        desenho.addElement(new Ponto(3d, 10d, false));
        desenho.addElement(new Ponto(4d, 10d, false));
        desenho.addElement(new Ponto(4d, 8d, false));
        desenho.addElement(new Ponto(3d, 8d, false));
        desenho.addElement(new Ponto(5d, 8d, true));
        desenho.addElement(new Ponto(5d, 10d, false));
        desenho.addElement(new Ponto(6d, 10d, false));
        desenho.addElement(new Ponto(6d, 8d, false));
        desenho.addElement(new Ponto(5d, 8d, false));
        desenho.addElement(new Ponto(3.5, 8.5d, true));
        desenho.addElement(new Ponto(3.5, 9.5d, false));
        desenho.addElement(new Ponto(5.5, 8.5d, true));
        desenho.addElement(new Ponto(5.5, 9.5d, false));
        desenho.addElement(new Ponto(4d, 14d, true));
        desenho.addElement(new Ponto(5d, 14d, false));
        desenho.addElement(new Ponto(14d, 18d, true));
        desenho.addElement(new Ponto(14d, 2d, false));
        desenho.addElement(new Ponto(15d, 2d, false));
        desenho.addElement(new Ponto(15d, 18d, false));
        desenho.addElement(new Ponto(14d, 18d, false));
        desenho.addElement(new Ponto(13d, 15d, true));
        desenho.addElement(new Ponto(10d, 17d, false));
        desenho.addElement(new Ponto(13d, 10d, true));
        desenho.addElement(new Ponto(10d, 10d, false));
        desenho.addElement(new Ponto(13d, 5d, true));
        desenho.addElement(new Ponto(10d, 3d, false));
        desenho.addElement(new Ponto(15d, 8, true));
        desenho.addElement(new Ponto(17d, 8, false));
        desenho.addElement(new Ponto(16d, 12, true));
        desenho.addElement(new Ponto(15d, 12, false));
        desenho.addElement(new Ponto(16d, 12, false));
        desenho.addElement(new Ponto(16d, 20, false));
        desenho.addElement(new Ponto(17d, 20, true));
        desenho.addElement(new Ponto(17d, 8, false));
        desenho.addElement(new Ponto(3.5d, 15.5, true));
        desenho.addElement(new Ponto(3.5d, 18, false));
        desenho.addElement(new Ponto(1, 18, false));
        desenho.addElement(new Ponto(0, 20, false));
        desenho.addElement(new Ponto(9, 20, true));
        desenho.addElement(new Ponto(8, 18, false));
        desenho.addElement(new Ponto(5.5d, 18, false));
        desenho.addElement(new Ponto(5.5d, 15.5, false));
    }
    public void cenario(){
        desenho.addElement(new Ponto(0, 15, true));
        desenho.addElement(new Ponto(0, 15, false));
        desenho.addElement(new Ponto(20, 15, false));
        desenho.addElement(new Ponto(5, 15, true));
        desenho.addElement(new Ponto(5, 5, false));
        desenho.addElement(new Ponto(17, 5, false));
        desenho.addElement(new Ponto(17, 15, false));
        desenho.addElement(new Ponto(17, 5, false));
        desenho.addElement(new Ponto(17.5d, 5, false));
        desenho.addElement(new Ponto(17.5d, 4, false));
        desenho.addElement(new Ponto(4.5d, 4, false));
        desenho.addElement(new Ponto(4.5d, 5, false));
        desenho.addElement(new Ponto(5, 5, false));
        desenho.addElement(new Ponto(4.8d, 4, true));
        desenho.addElement(new Ponto(4.8d, 0, false));
        desenho.addElement(new Ponto(16.5d, 0, true));
        desenho.addElement(new Ponto(16.5d, 4, false));
        desenho.addElement(new Ponto(4.5d, 4, true));
        desenho.addElement(new Ponto(4.5d, 2, false));
        desenho.addElement(new Ponto(11, 4, true));
        desenho.addElement(new Ponto(11, 2, false));
        desenho.addElement(new Ponto(17.5d, 4, true));
        desenho.addElement(new Ponto(17.5d, 2, false));
        desenho.addElement(new Ponto(17.5d, 2, true));
        desenho.addElement(new Ponto(4.5d, 2, false));
        desenho.addElement(new Ponto(17.5d, 2.5d, true));
        desenho.addElement(new Ponto(4.5d, 2.5d, false));
        desenho.addElement(new Ponto(17.5d, 3, true));
        desenho.addElement(new Ponto(4.5d, 3, false));
        desenho.addElement(new Ponto(17.5d, 3.5, true));
        desenho.addElement(new Ponto(4.5d, 3.5, false));
        desenho.addElement(new Ponto(5, 5, true));
        desenho.addElement(new Ponto(2, 6.5, false));
        desenho.addElement(new Ponto(5, 6.5, false));
        desenho.addElement(new Ponto(7, 15, true));
        desenho.addElement(new Ponto(7, 7, false));
        desenho.addElement(new Ponto(9, 7, false));
        desenho.addElement(new Ponto(9, 15, false));
        desenho.addElement(new Ponto(9, 11, true));
        desenho.addElement(new Ponto(15, 11, false));
        desenho.addElement(new Ponto(15, 7, false));
        desenho.addElement(new Ponto(13, 7, false));
        desenho.addElement(new Ponto(13, 11, false));
        desenho.addElement(new Ponto(13, 7, true));
        desenho.addElement(new Ponto(11, 7, false));
        desenho.addElement(new Ponto(11, 11, false));
        desenho.addElement(new Ponto(11, 7, true));
        desenho.addElement(new Ponto(9, 7, false));
        desenho.addElement(new Ponto(11, 15, true));
        desenho.addElement(new Ponto(11, 12, false));
        desenho.addElement(new Ponto(11, 13.5, false));
        desenho.addElement(new Ponto(12, 13.5, false));
        desenho.addElement(new Ponto(12, 15, false));
        desenho.addElement(new Ponto(12.5, 15, true));
        desenho.addElement(new Ponto(12.5, 12.5, false));
        desenho.addElement(new Ponto(14, 12.5, false));
        desenho.addElement(new Ponto(14, 15, false));
        desenho.addElement(new Ponto(14.5, 15, true));
        desenho.addElement(new Ponto(14.5, 13.5, false));
        desenho.addElement(new Ponto(15.5, 13.5, false));
        desenho.addElement(new Ponto(15.5, 12, false));
        desenho.addElement(new Ponto(15.5, 15, false));
        desenho.addElement(new Ponto(6, 6.5, true));
        desenho.addElement(new Ponto(5.7, 6.5, false));
        desenho.addElement(new Ponto(5.7, 5.5, false));
        desenho.addElement(new Ponto(6, 5.5, false));
        desenho.addElement(new Ponto(6.1, 5.5, true));
        desenho.addElement(new Ponto(6.4, 5.5, false));
        desenho.addElement(new Ponto(6.4, 6.5, false));
        desenho.addElement(new Ponto(6.1, 6.5, false));
        desenho.addElement(new Ponto(6.1, 5.5, false));
        desenho.addElement(new Ponto(6.5, 5.5, true));
        desenho.addElement(new Ponto(6.5, 6.5, false));
        desenho.addElement(new Ponto(6.5, 6, true));
        desenho.addElement(new Ponto(6.8, 6, false));
        desenho.addElement(new Ponto(6.5, 5.5, true));
        desenho.addElement(new Ponto(6.8, 5.5, false));
        desenho.addElement(new Ponto(6.9, 5.5, true));
        desenho.addElement(new Ponto(6.9, 6.5, false));
        desenho.addElement(new Ponto(6.9, 6, true));
        desenho.addElement(new Ponto(7.2, 6, false));
        desenho.addElement(new Ponto(6.9, 5.5, true));
        desenho.addElement(new Ponto(7.2, 5.5, false));
        desenho.addElement(new Ponto(7.3, 5.5, true));
        desenho.addElement(new Ponto(7.3, 6.5, false));
        desenho.addElement(new Ponto(7.3, 6, true));
        desenho.addElement(new Ponto(7.6, 6, false));
        desenho.addElement(new Ponto(7.3, 5.5, true));
        desenho.addElement(new Ponto(7.6, 5.5, false));
        desenho.addElement(new Ponto(7.3, 6.5, true));
        desenho.addElement(new Ponto(7.6, 6.5, false));
    }
    
    

    public void translada(double dx, double dy) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            p = (Ponto) desenho.get(i);
            p.setX(p.getX() + dx);
            p.setY(p.getY() + dy);
            desenho.set(i, p);
        }
    }

    public void rotaciona(double ang) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {

            p = (Ponto) desenho.get(i);
            double xx = p.getX();
            double yy = p.getY();
            p.setX(xx * Math.cos(ang) + yy * (-Math.sin(ang)));
            p.setY(xx * Math.sin(ang) + yy * Math.cos(ang));
            desenho.set(i, p);
        }
    }

    public void deforma(boolean maior) {
        Ponto p;
        for (int i = 0; i < desenho.size(); i++) {
            if (maior) {
                p = (Ponto) desenho.get(i);
                p.setX(((p.getX() - mx) * 0.1) + p.getX());
                p.setY(((p.getY() - my) * 0.1) + p.getY());
                desenho.set(i, p);
            } else {
                p = (Ponto) desenho.get(i);
                p.setX(p.getX() - ((p.getX() - mx) * 0.1));
                p.setY(p.getY() - ((p.getY() - my) * 0.1));
                desenho.set(i, p);
            }
        }
    }

}
