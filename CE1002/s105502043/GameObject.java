package s105502043;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
/*
* This class is the basic object in Game.
* It has the basic property for game object,
* such like position, width, height, image.
* It also has some basic method : draw, isclick, onclick,move.
*/
public abstract class GameObject {
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Image image;

    public GameObject(double x,double y,double width,double height,Image image){
        this.x = x+width/2;
        this.y = y+height/2;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw(GraphicsContext gc){
        gc.drawImage(image,x-width/2,y-height/2,width,height);
        //the position of the image, now it's drawn from x,y to x+width,y+height
        //and it's draw from the top left corner of the image.
    }
    public void move(double deltaX,double deltaY){
        x+=deltaX;
        y+=deltaY;
    }
    public boolean isClick(MouseEvent event){
    	if(event.getX()<x+width/2&&event.getX()>x-width/2&&event.getY()<y+height/2&&event.getY()>y-height/2)
    		return true;
    	else
    		return false;
        // if event.getX is in x - width/2 to x + width/2
        // and event.getX is in y - height/2 to y + height/2 then return true, otherwise, false.

        //return true;// you should change this line to make the program work.
    }
    public abstract void OnClick();
}
