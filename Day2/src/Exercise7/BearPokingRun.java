package Exercise7;

public class BearPokingRun
{
  public static void main(String[] args)
  {
    Thread bear2Thread = new Thread(new Bear2());
    Thread bear3Thread = new Thread(new Bear3());
    Thread bear1Thread = new Thread(new Bear1(bear2Thread, bear3Thread));


    Thread pokingMan1Thread = new Thread(new PokingMan(bear1Thread));

    bear1Thread.start();
    pokingMan1Thread.start();

  }
}
