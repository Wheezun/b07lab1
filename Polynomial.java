public class Polynomial {
	double[] coefficients;

	public Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
 }

	public Polynomial(double[] c) {
		coefficients = new double[c.length];
		for(int i=0;i<c.length;i++) {
			coefficients[i] = c[i];
  }
 }
	public Polynomial add(Polynomial poly) {
		int newarraylength = 0;
		if (poly.coefficients.length>coefficients.length) {
			newarraylength = poly.coefficients.length;
	}	else {
			newarraylength = coefficients.length;
  }
		double[] newarray = new double[newarraylength];
		for(int i=0;i<newarray.length;i++) {
			double value1 = 0;
			double value2 = 0;
			if(i<poly.coefficients.length) {
				value1 = poly.coefficients[i];
   }
			if(i<coefficients.length) {
				value2 = coefficients[i];
   }
			newarray[i] = value1 + value2;
  }
		Polynomial newpoly = new Polynomial(newarray);
		return newpoly;
 }
	public double evaluate(double x) {
		double sum = 0;
		sum = sum + coefficients[0];
		for(int i=1;i<coefficients.length;i++) {
			double value = x;
			for(int j=1;j<i;j++) {
				value = value*x;
   }
			sum = sum + coefficients[i]*value;
  }
		return sum;
 }
	public boolean hasRoot(double x) {
		if(evaluate(x)==0) {
			return true;
  	}	else {
			return false;
  }
 }
}