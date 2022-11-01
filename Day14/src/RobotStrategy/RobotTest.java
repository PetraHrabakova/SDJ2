package RobotStrategy;

public class RobotTest
{
  public static void main(String[] args)
  {
    GameBoard board = new GameBoard();
    Robot robot = new Robot("Robot Mike", board);
    Behaviour behaviour = new AgressiveBehaviour();
    robot.setBehaviourStrategy(behaviour);
    robot.move();
  }
}
