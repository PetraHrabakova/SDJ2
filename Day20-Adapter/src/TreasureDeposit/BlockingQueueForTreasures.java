package TreasureDeposit;

public interface BlockingQueueForTreasures
{
	public void enqueue(Valuable valuable);
	public Valuable dequeue();
	public Valuable first();
	public int size();
	public boolean isEmpty();
	public int indexOf(Valuable valuable);
	public boolean contains(Valuable valuable);
}
