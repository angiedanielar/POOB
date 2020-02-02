package shapes;

import java.awt.*;
import java.awt.geom.*;

/**
* A circle that can be manipulated and that draws itself on a canvas.
* 
* @author  Michael Kolling and David J. Barnes
* @version 1.0.  (15 July 2000) 
*/
public class Circle extends Figura {
    public static double PI=3.1416;
    private int diameter;
    
    /**
    * Create a new circle at default position with default color.
    */
    public Circle(){
        diameter = 30;
    }
    
    /**
    * Change the size.
    * @param newDiameter the new size (in pixels). Size must be >=0.
    */
    public void changeSize(int newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }
    
    /**
    * Draw the circle with current specifications on screen.
    */
    public void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, super.getColor(), 
                new Ellipse2D.Double(super.getX(), super.getY(), 
                diameter, diameter));
            canvas.wait(10);
        }
    }
    
    public int getDiameter(){
        return diameter;
    }
    
    public void setDiameter(int newDiameter){
        diameter = newDiameter;
    }
    
    /**
     * growUp
     * @param int times el numero de veces que aumenta su tamaño por 1
     */
    public void growUp(int times){
        for (int i=0; i< times;i++){
            changeSize(i);
        } 
    }
    
    /**
     * area
     * escribe el valor del area del circulo
     */
    public void area(){
        double area;
        area= PI * ((diameter/2)*(diameter/2));
        System.out.println("el area es igual a "+ area);
    }
    
    /**
     * jump
     * hace que el circulo salte a la drecha
     */
    public void jump(){
      for (int i= 0; i< 5; i++){
            moveVertical(-i);
            moveHorizontal(i);
        }
      for (int j= 5; j> 0;j--){
            slowMoveVertical(j);
            slowMoveHorizontal(j);
        }
    }
}
