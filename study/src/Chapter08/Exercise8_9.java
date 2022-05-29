package Chapter08;

class UnsupportedFuctionException extends RuntimeException {
	final private int ERR_CODE;
	
	UnsupportedFuctionException(String errMessage, int errCode) {
		super(errMessage);
		ERR_CODE = errCode;
	}
	
	UnsupportedFuctionException(String errMessage) {
		this(errMessage, 100);
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "[" + getErrorCode() + "]" + super.getMessage();
	}
}


public class Exercise8_9 {

	public static void main(String[] args) {
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100);
	}

}
