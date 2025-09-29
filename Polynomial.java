import java.io.File;
import java.util.Scanner;
import java.io.Writer;

public class Polynomial {
	double[] coefficients;
	int[] exponents;

	public Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
		exponents = new int[1];
		exponents[0] = 0;
 }

	public Polynomial(double[] c,int[] e) {
		coefficients = new double[c.length];
		exponents = new int[e.length];
		for(int i=0;i<c.length;i++) {
			coefficients[i] = c[i];
			exponents[i] = e[i];		
  }
 }

	public Polynomial(File polyfile) {
		int index = 1;

		try (Scanner reader = newScanner(polyfile)) {
			String poly = reader.nextLine();
  }
		String[] nums = poly.split("x");
		coefficients = new double[nums.length];
		exponents = new int[nums.length];
		if(nums[0].length()==1&&nums.length>1) {
			exponents[0] = Integer.parseInt(Character.toString(nums[1].charAt(0)));
			coefficients[0] = Double.parseDouble(Character.toString(nums[0].charAt(0)));
   		} else if(poly.charAt(0)!='x') {
			exponents[0] = 0;
			coefficients[0] = Double.parseDouble(Character.toString(nums[0].charAt(0)));
			if(nums[0].charAt(1)=='-') {
				coefficients[1] = -1.0*Double.parseDouble(Character.toString(nums[0].charAt(2)));
    			} else {
				coefficients[1] = Double.parseDouble(Character.toString(nums[0].charAt(2)));
}
   		} else if(pol.charAt(0)=='x'){
			exponents[0] = Integer.parseInt(Character.toString(nums[0].charAt(0)));
			coefficients[0] = 1;
		} else {
			exponents[0] = 1;
			coefficients[0] = Double.parseDouble(Character.toString(nums[0].charAt(0)));
   }
		for(int i=1;i<nums.length;i++) {
			if(index+1 < nums.length) {
				if(nums[i].length()==3) {
					if(nums[i].charAt(1)=='-') {
						coefficients[index+1] = -1.0*Double.parseDouble(Character.toString(nums[i].charAt(0)));
   				} else {
					coefficients[index+1] = Double.parseDouble(Character.toString(nums[i].charAt(2)));
      }
     }
    }
			exponents[index] = Integer.parseInt(Character.toString(nums[i].charAt(0)));
			index = index + 1;
			if(nums[i].length()==1) {
				exponents[index] = Integer.parseInt(Character.toString(nums[i].charAt(0)));
   }
  }
 }

	public int[] mergesort(int[] a,int[] b) {
		int[] c = new int[a.length+b.length];

		for(int i=0;i<a.length;i++) {
			c[i] = a[i];
  }
		for(int i=0;i<b.length;i++) {
			c[a.length+i] = b[i];
  }
    		for (int lastPos=c.length - 1; lastPos >= 0; lastPos--) {
        		for (int i=0; i<=lastPos - 1;i++) {
            			if (c[i]>c[i+1]) {
                			int temp = c[i];
                			c[i] = c[i+1];
                			c[i+1] = temp;
            }
        }
    }
		return c;
 }

	public Polynomial add(Polynomial poly) {
		int[] allExponents = mergesort(poly.exponents,exponents);
		int uniqueExponents = allExponents.length;
		for(int i=0;i<allExponents.length;i++) {
			if(i+1<allExponents.length && allExponents[i] == allExponents[i+1]) {
				i = i+1;
				uniqueExponents = uniqueExponents-1;
    }
   }
		int[] newExponents = new int[uniqueExponents];
		int index = 0;
		for(int i=0;i<allExponents.length;i++) {
			newExponents[index] = allExponents[i];
			index = index + 1;
			if(i+1<allExponents.length && allExponents[i] == allExponents[i+1]) {
				i = i+1;
   }
  }
		double[] newCoefficients = new double[newExponents.length];
		for(int i=0;i<newCoefficients.length;i++) {
			double value1 = 0;
			double value2 = 0;
			for(int j=0;j<exponents.length;j++) {
				if(exponents[j]==newExponents[i]) {
					value1 = coefficients[j];
					break;
    }
   }
			for(int j=0;j<poly.exponents.length;j++) {
				if(poly.exponents[j]==newExponents[i]) {
					value2 = poly.coefficients[j];
					break;
    }
   }
			newCoefficients[i] = value1 + value2;
  }
		Polynomial newpoly = new Polynomial(newCoefficients,newExponents);
		return newpoly;
 }
	public double evaluate(double x) {
		double sum = 0;
		for(int i=0;i<coefficients.length;i++) {
			double value = 1;
			for(int j=0;j<exponents[i];j++) {
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

	public Polynomial multiply(Polynomial poly) {
		int greatest1 = 1;
		int greatest2 = 1;
		int index = 0;

		for(int i=0;i<exponents.length;i++) {
			if(exponents[i]>greatest1) {
				greatest1 = exponents[i];
 }
}
		for(int i=0;i<poly.exponents.length;i++) {
			if(poly.exponents[i]>greatest2) {
				greatest2 = poly.exponents[i];
 }
}
		double[] allCoefficients1 = new double[greatest1+1];
		double[] allCoefficients2 = new double[greatest2+1];
		for(int i=0;i<allCoefficients1.length;i++) {
			allCoefficients1[i] = 0;
			for(int j=0;j<exponents.length;j++) {
				if(exponents[j]==i) {
				allCoefficients1[i] = coefficients[j];
     }
    }
   }
		for(int i=0;i<allCoefficients2.length;i++) {
			allCoefficients2[i] = 0;
			for(int j=0;j<poly.exponents.length;j++) {
				if(poly.exponents[j]==i) {
				allCoefficients2[i] = poly.coefficients[j];
     }
    }
   }
		int length = allCoefficients1.length + allCoefficients2.length - 1;
		double[] newAllCoefficients = new double[length];
		for(int i=0;i<allCoefficients1.length;i++) {
			for(int j=0;j<allCoefficients2.length;j++) {
				newAllCoefficients[i+j] += allCoefficients1[i]*allCoefficients2[j];
   }
  }
		int newArrayLength = 0;
		for(int i=0;i<length;i++) {
			if(newAllCoefficients[i] != 0) {
				newArrayLength = newArrayLength + 1;
   }
  }
		int[] newExponents = new int[newArrayLength];
		double[] newCoefficients = new double[newArrayLength];
		for(int i=0;i<length;i++) {
			if(newAllCoefficients[i] != 0) {
				newExponents[index] = i;
				newCoefficients[index] = newAllCoefficients[i];
				index = index + 1;
   }
  }
		Polynomial newpoly = new Polynomial(newCoefficients,newExponents);
		return newpoly;
 }

	public saveToFile(String fileName) {
		File poly = new File(fileName+".txt");
		poly.createNewFile();
		String polyText = "";
		for(int i=0;i<exponents;i++) {
			if(exponents[i]==0) {
				polyText = polyText + String.valueOf(coefficients[i]);
		} else {
			if(coefficients[i]>0) {
				polyText = polyText + "+" + String.valueOf(coefficients[i]) + "x" + String.valueOf(exponents[i]);
     		} else {
			polyText = polyText + String.valueOf(coefficients[i]) + "x" + String.valueOf(exponents[i]);
     }
    }
   }
		try (Printwriter out = new Printwriter(fileName+".txt")) {
			out.println(polyText);
  }
 }
}