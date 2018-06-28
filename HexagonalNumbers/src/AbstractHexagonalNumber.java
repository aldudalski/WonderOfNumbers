import java.math.BigInteger;


public abstract class AbstractHexagonalNumber implements HexagonalBase{
	
	@Override
	public String toString() {
		return "n=" + n + ", H(n)=" + H + "";
	}

	BigInteger n;
	BigInteger H;

	public AbstractHexagonalNumber(BigInteger n){
		this.n = n;
		H = calcH();
	}
	
	public BigInteger getN() {
		return n;
	}

	public BigInteger getH() {
		return H;
	}
	
	public Boolean isMorphic(){
		String nStr = n.toString();
		String HStr = H.toString();
		return (HStr.endsWith(nStr));
	}
	
   protected abstract BigInteger calcH();

}
