package RobotStrategy;

import java.awt.geom.Point2D;

public class AgressiveBehaviour implements Behaviour
{
  @Override
  public int moveCommand(GameBoard board, Point2D robotLocation)
  {
    System.out.println("Robot is aggressive.");
    return 1;
  }
}
