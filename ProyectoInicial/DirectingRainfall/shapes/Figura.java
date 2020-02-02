package shapes;

public abstract class Figura{
    private int xPosition;
    private int yPosition;
    private String color;
    public boolean isVisible;
    
    /**
     * Constructor for objects of class Figure
     */
    public Figura() {
        xPosition = 0;
        yPosition = 0;
        color = "black";
        isVisible = false;
    }
    
    public int getX(){
        return xPosition;
    }
    
    public int getY(){
        return yPosition;
    }
    
    public String getColor(){
        return color;
    }
    
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the rectangle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the rectangle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the rectangle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }
    
    public void setX(int x){
        erase();
        xPosition = x;
        draw();
    }
    
    public void setY(int y){
        erase();
        yPosition = y;
        draw();
    }
    
    /**
     * Slowly move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }
    
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }
    
    /**
     * Erase the rectangle on screen.
     */
    public void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * Draw the rectangle with current specifications on screen.
     */
    public abstract void draw();
    
    /**
     * Cambia las coordenadas de la figura
     * @param newx nueva coordenada de x
     * @param newy nueva coordenada de y
     */public void changePosition(int newx, int newy){
        erase();
        this.xPosition= newx;
        this.yPosition= newy;
        draw();
    }
}
