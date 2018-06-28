import java.math.BigInteger;


public class HexagonalCenteredNumber extends AbstractHexagonalNumber{

	public HexagonalCenteredNumber(BigInteger n) {
		super(n);
	}

	@Override
	protected BigInteger calcH() {
		//3n(n-1) is a centered hexagonal number
		BigInteger nMinusOne = n.subtract(new BigInteger("1"));
		return n.multiply(new BigInteger("3")).multiply(nMinusOne);
	}
	

}
