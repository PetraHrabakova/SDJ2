package valuables;

public interface Deposit<ValuablesMultiton>
{
	void put(ValuablesMultiton valuable);
	ValuablesMultiton take();
	boolean isEmpty();
	boolean isFull();
}
