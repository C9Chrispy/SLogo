package slogo_turtle_ui;

import java.util.Observable;
import java.util.Observer;

import slogo_logic.Turtle;

/**
 * Observed a Turtle object for changes and upon change
 * it called the update function, which updates the turtle sprite 
 * and it's associated objects.
 *
 */
public class TurtleObserver implements Observer{
	
	private TurtleSprite turtleSprite;
	
	private Turtle turtle;
	private Animator animator;
	private Pen pen;
	
	private boolean pendown;
	
	public TurtleObserver (TurtleSprite turtleSprite) {
		this.turtle = turtleSprite.getTurtle();
		turtle.addObserver(this);
		this.animator = turtleSprite.getAnimator();
		this.pen = turtleSprite.getPen();
		this.pendown = turtleSprite.getPendown();
		this.turtleSprite = turtleSprite;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// if observable is the correct instance of turtle
				if (o == turtle) {
					double distMoved = turtle.getDPosition();
					String change = (String) arg;
					
					// turtle has moved somewhere new
					if (change.equals("move")) {
						
						animator.move(turtle.getX(), turtle.getY(), pendown, distMoved);
					} 
					
					// pen down has changed
					else if (change.equals("pen")) {
						pendown = turtle.isPendown()==1 ? true : false;
					}
					
					// clear screen was called
					else if (change.equals("clear")) {
						
						//clear all lines
						pen.clearLines();
						
						// move to 0,0 with pen down = false
						animator.move(0, 0, false, distMoved);
						
						turtleSprite.setPrevX(animator.getTranslatedOriginX());
						turtleSprite.setPrevY(animator.getTranslatedOriginY());
					}
					
					// turtle has rotated to a new heading
					else if (change.equals("rotate")) {
						animator.rotate(turtle.getDHeading());
					} 
					
					// turtle show has changed
					else if (change.equals("show")) {
						if (turtle.isShowing() == 0) {
							animator.fade(1,0);
						} else {
							animator.fade(0,1);
						}
					}
					
					animator.playAnimations();	
				}
	}

}
