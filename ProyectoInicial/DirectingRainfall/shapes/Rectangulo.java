package shapes;

import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */
public class Rectangulo extends Figura {
    private int height;
    private int width;

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangulo(int height, int width, int xPosition, String color){
        super();
        this.height = height;
        this.width = width;
        super.setX(xPosition);
        super.changeColor(color);
        isVisible = false;
    }
    
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        super.erase();
        height = newHeight;
        width = newWidth;
        draw();
    }
    
    /**
     * Draw the rectangle with current specifications on screen.
     */

    public void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, super.getColor(),
                new java.awt.Rectangle(super.getX(), super.getY(), width, height));
            canvas.wait(10);
        }
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
}

