package da;

public class Rectangle {
	private double xLow, yLow, xHigh, yHigh;
	
	public Rectangle ( double xLow, double yLow, double xHigh, double yHigh ) {
		this.xLow = xLow;
		this.yLow = yLow;
		this.xHigh = xHigh;
		this.yHigh = yHigh;
		if(xHigh < xLow) {
			this.xLow = xHigh;
			this.xHigh = xLow;
		}
		if(yHigh < yLow) {
			this.yLow = yHigh;
			this.yHigh = yLow;
		}
	}
	public double getXLow() {
		return xLow;
	}
	public double getYLow() {
		return yLow;
	}
	public double getXHigh() {
		return xHigh;
	}
	public double getYHigh() {
		return yHigh;
	}
	public boolean isIn( double x, double y ) {
		if( (x > xLow && x < xHigh) && (y > yLow && y < yHigh)) {
			return true;
		}
		return false;
	}
	public boolean disjoint( Rectangle o ) {
		if(((xLow > (o.xLow) && xLow > (o.xHigh)) && (xHigh > (o.xLow) && xHigh > (o.xHigh))
		|| (this.yLow > (o.yLow) && this.yLow > (o.yHigh)) && (yHigh > (o.yLow) && yHigh > (o.yHigh)) || (xLow < (o.xLow) && xLow < (o.xHigh)) && (xHigh < (o.xLow) && xHigh < (o.xHigh))
		|| (this.yLow < (o.yLow) && this.yLow < (o.yHigh)) && (yHigh < (o.yLow) && yHigh < (o.yHigh)))) {
			return true;
		}
		return false;
	}
	public double distance( double x, double y ) {
		double xLowDistance = Math.abs(x-xLow);
		double xHighDistance = Math.abs(x-xHigh);
		double yLowDistance = Math.abs(y-yLow);
		double yHighDistance = Math.abs(y-yHigh);
		
		if( (x > xLow && x < xHigh) && (y > yLow && y < yHigh)) {
			return 0;
		}
		//bottom left corner
		if((xLowDistance < xHighDistance) && (yLowDistance < yHighDistance)) {
			return Math.sqrt(Math.pow(x - xLow, 2) + Math.pow(y - yLow, 2));
		}
		//bottom right corner
		if((xLowDistance < xHighDistance) && (yLowDistance > yHighDistance)) {
			return Math.sqrt(Math.pow(x - xLow, 2) + Math.pow(y - yHigh, 2));
		}
		//top left corner
		if((xLowDistance > xHighDistance) && (yLowDistance < yHighDistance)) {
			return Math.sqrt(Math.pow(x - xHigh, 2) + Math.pow(y - yLow, 2));
		}
		//bottom right corner
		if((xLowDistance > xHighDistance) && (yLowDistance > yHighDistance)) {
			return Math.sqrt(Math.pow(x - xHigh, 2) + Math.pow(y - yHigh, 2));
		}
		return 0;
	}
	public static void main(String[] args) {
		

	}

}
