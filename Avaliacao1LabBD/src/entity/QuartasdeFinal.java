package entity;

public class QuartasdeFinal {
	
	private String timeA;
	private String timeB;
	
	/**
	 * @return the timeA
	 */
	@Coluna(nome="TimeA", posicao=0)
	public String getTimeA() {
		return timeA;
	}
	/**
	 * @param timeA the timeA to set
	 */
	public void setTimeA(String timeA) {
		this.timeA = timeA;
	}
	/**
	 * @return the timeB
	 */
	@Coluna(nome="TimeB", posicao=1)
	public String getTimeB() {
		return timeB;
	}
	/**
	 * @param timeB the timeB to set
	 */
	public void setTimeB(String timeB) {
		this.timeB = timeB;
	}
	
	
	
}
