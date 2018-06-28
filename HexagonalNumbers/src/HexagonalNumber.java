import java.math.BigInteger;


public class HexagonalNumber extends AbstractHexagonalNumber{

	public HexagonalNumber(BigInteger n) {
		super(n);
	}

	@Override
	protected BigInteger calcH() {
		//n(2n-1) is a hexagonal number
		BigInteger twoNMinusOne = n.multiply(new BigInteger("2")).subtract(new BigInteger("1"));
		return n.multiply(twoNMinusOne);
	}
	

}
