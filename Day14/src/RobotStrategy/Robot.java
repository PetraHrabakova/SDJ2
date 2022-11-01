package RobotStrategy;
import java.awt.geom.Point2D;

public class Robot
{
  private String name;
  private GameBoard board;
  private Behaviour behaviour;

  public Robot(String name, GameBoard board) {
    this.name = name;
    this.board = board;
  }

  public Behaviour getBehaviourStrategy() {
    return behaviour;
  }

  public void setBehaviourStrategy(Behaviour behaviourStrategy) {
    this.behaviour = behaviourStrategy;
  }

  public void move() {
    Point2D newPoint = new Point2D.Double(2,3);
    behaviour.moveCommand(board, newPoint);
    System.out.println("Robot's position: [" + newPoint.getX() + ", " + newPoint.getY() + "]");
  }
}
