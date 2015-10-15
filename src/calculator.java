import java.util.Scanner;
public class Project1Reboot {
	public static int getWholeNumber(String fraction_1){
		if (fraction_1.indexOf("_") != -1){
		//get the value of the whole number
		int indexOfUnderscore = fraction_1.indexOf("_");
		String wholeNumber = fraction_1.substring(0,indexOfUnderscore); 
		int wholeNumberInt = Integer.parseInt(wholeNumber);
		return wholeNumberInt;
		} else{
			return 0;
		}
	}
	
	public static int getNumerator(String fraction_1){
		//get the value of the numerator
		int indexOfUnderscore = fraction_1.indexOf("_");
		int indexOfSlash = fraction_1.indexOf("/");
		if(indexOfSlash != -1){
			if (fraction_1.indexOf("_") != -1){
			String numerator = fraction_1.substring(indexOfUnderscore + 1,indexOfSlash);
			int numeratorInt = Integer.parseInt(numerator);
			return numeratorInt;
			}else{
			String numerator = fraction_1.substring(0,indexOfSlash);
			int numeratorInt = Integer.parseInt(numerator);
			return numeratorInt;
			}
		}else{
			return Integer.parseInt(fraction_1);
		}
		
	}
	
	public static int getDenominator(String fraction_1){
		//get the value of the numerator
		int indexOfSlash = fraction_1.indexOf("/");
		if(indexOfSlash != -1){
			String denominator = fraction_1.substring(indexOfSlash + 1);
			int denominatorInt = Integer.parseInt(denominator);
			return denominatorInt;
		}else{
			return 1;
		}
		
		}
	public static int getImproperNumerator(int wholeNumber,int numerator, int denominator){
		//improper numerator
		if(wholeNumber > 0 ){
			int improperNumerator = (wholeNumber * denominator) + numerator;
			return improperNumerator;
		}else if(wholeNumber < 0){
			int improperNumerator = (wholeNumber * denominator) - numerator;
			return improperNumerator;
		}else{//return the same numerator
			return numerator;
		}
	}
	
	public static String multiply(int numerator_1, int denominator_1, int numerator_2, int denominator_2){
		//multiplication
		int multNum = numerator_1 * numerator_2;//get the numerator of the multiplication
		int multDen = denominator_1 * denominator_2;//get the denominator of the multiplication
		
		return multNum + "/" + multDen;
	}
	
	public static String divide(int numerator_1, int denominator_1, int numerator_2, int denominator_2){
		//division
		int divNum = numerator_1 * denominator_2;//get the numerator of the division
		int divDen = denominator_1 * numerator_2;//get the denominator of the division
		if (divNum < 0 && divDen < 0){
			return Math.abs(divNum) + "/" + Math.abs(divDen);
		}else if (divDen < 0){
			return -divNum + "/" + Math.abs(divDen);
		}else{
			return divNum + "/" + divDen;
		}
		
	}
	
	public static int getLeastCommonMultiple(int denominator_1, int denominator_2){
		int denominator1 = denominator_1; 
		int denominator2 = denominator_2;
		//find the least common multiple
		while(denominator_1 != denominator_2){
			if(denominator_1 < denominator_2){
				denominator_1 = denominator1 + denominator_1;
			}else if(denominator_2 < denominator_1){
				denominator_2 = denominator2 + denominator_2;
			}
		}
		
		return denominator_1;
	}
	
	public static String add(int impNumerator_1, int impNumerator_2, int LCM, int denominator_1, int denominator_2){
		int firstNum = (LCM / denominator_1) * impNumerator_1;
		int secondNum = (LCM / denominator_2) * impNumerator_2;
		int add = (firstNum + secondNum);
		
		if (add < 0 && LCM < 0){
			return Math.abs(add) + "/" + Math.abs(LCM);
		}else if (LCM < 0){
			return add + "/" + Math.abs(LCM);
		}else{
			return add + "/" + LCM;
		}
	}
	
	public static String subtract(int impNumerator_1, int impNumerator_2, int LCM, int denominator_1, int denominator_2){
		int firstNum = (LCM / denominator_1) * impNumerator_1;
		int secondNum = (LCM / denominator_2) * impNumerator_2;
		int subtract = (firstNum - secondNum);
		
		if (subtract < 0 && LCM < 0){
			return Math.abs(subtract) + "/" + Math.abs(LCM);
		}else if (LCM < 0){
			return subtract + "/" + Math.abs(LCM);
		}else{
			return subtract + "/" + LCM;
		}
		
	}

	public static void makeProperFraction(String impFraction){
		int indexOfSlash = impFraction.indexOf("/");
		String num = impFraction.substring(0, indexOfSlash);
		String den = impFraction. substring(indexOfSlash + 1);
		int numeratorInt = Integer.parseInt(num);
		int denominatorInt = Integer.parseInt(den);
		int wholeNumber = numeratorInt / denominatorInt;
		int numerator = numeratorInt % denominatorInt;
		
		if(wholeNumber == 0){
			System.out.println(numerator + "/" + denominatorInt);
		}else if(numerator != 0){
			System.out.println(wholeNumber + "_" + numerator + "/" + denominatorInt);
		}else if(numerator == 0){
			System.out.println(wholeNumber);
		}
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the FracCalc Program. Please enter equations and type \"quit\" to end the program");
		
		System.out.print("> ");
		String fraction1 = input.next();
		String operator = input.next();
		String fraction2 = input.next();
		System.out.println("fraction 1: " + fraction1);
		System.out.println("operator: " + operator);
		System.out.println("fraction 2: " + fraction2);
		
		int wholeNumber1 = getWholeNumber(fraction1);
		int wholeNumber2 = getWholeNumber(fraction2);
		int numerator1 = getNumerator(fraction1);
		int numerator2 = getNumerator(fraction2);
		int denominator1 = getDenominator(fraction1);
		int denominator2 = getDenominator(fraction2);
		int impNumerator1 =  getImproperNumerator(getWholeNumber(fraction1),getNumerator(fraction1),getDenominator(fraction1));
		int impNumerator2 = getImproperNumerator(getWholeNumber(fraction2),getNumerator(fraction2),getDenominator(fraction2));
		int LCM = getLeastCommonMultiple(getDenominator(fraction1), getDenominator(fraction2));
		
		// 4/2 + -4_5/6 (sample)
		
		//Objective 2
		System.out.println("whole number #1: " + wholeNumber1 + " whole number #2: " + wholeNumber2); //print out the value of the whole number
		System.out.println("numerator #1: " + numerator1 + " numerator #2: " + numerator2); //get the value of the numerator
		System.out.println("denominator #1: " + denominator1 + " denominator #2: " + denominator2); //get the value of the denominator
		
		//improper fractions
		System.out.println("Improper fraction #1: " + impNumerator1 + "/" + getDenominator(fraction1) +
				" Improper fraction #2: " + impNumerator2 + "/" + getDenominator(fraction2));
		
		if(operator.equals("*")){
			//multiply
			System.out.print("Multiplication: ");
			makeProperFraction(multiply(impNumerator1, denominator1, impNumerator2, denominator2));
		}else if(operator.equals("/")){
			//divide
			System.out.print("Division: ");
			makeProperFraction(divide(impNumerator1, denominator1, impNumerator2, denominator2));
		}else if(operator.equals("+")){
			//add
			System.out.print("Addition: ");
			makeProperFraction(add(impNumerator1, impNumerator2, LCM, denominator1, denominator2));
		}else if(operator.equals("-")){
			//subtract
			System.out.print("Subtraction: ");
			makeProperFraction(subtract(impNumerator1, impNumerator2, LCM, denominator1, denominator2));
		}
		
		while(!input.equals("quit")){
			//Objective 1
			System.out.print("> ");
			fraction1 = input.next();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
			operator = input.next();
			fraction2 = input.next();
			System.out.println("fraction 1: " + fraction1);
			System.out.println("operator: " + operator);
			System.out.println("fraction 2: " + fraction2);
			
			wholeNumber1 = getWholeNumber(fraction1);
			wholeNumber2 = getWholeNumber(fraction2);
			numerator1 = getNumerator(fraction1);
			numerator2 = getNumerator(fraction2);
			denominator1 = getDenominator(fraction1);
			denominator2 = getDenominator(fraction2);
			impNumerator1 =  getImproperNumerator(getWholeNumber(fraction1),getNumerator(fraction1),getDenominator(fraction1));
			impNumerator2 = getImproperNumerator(getWholeNumber(fraction2),getNumerator(fraction2),getDenominator(fraction2));
			LCM = getLeastCommonMultiple(getDenominator(fraction1), getDenominator(fraction2));
			
			//Objective 2
			System.out.println("whole number #1: " + wholeNumber1 + " whole number #2: " + wholeNumber2); //print out the value of the whole number
			System.out.println("numerator #1: " + numerator1 + " numerator #2: " + numerator2); //get the value of the numerator
			System.out.println("denominator #1: " + denominator1 + " denominator #2: " + denominator2); //get the value of the denominator
			
			//improper fractions
			System.out.println("Improper fraction #1: " + impNumerator1 + "/" + getDenominator(fraction1) +
					" Improper fraction #2: " + impNumerator2 + "/" + getDenominator(fraction2));
			
			//Operations
			if(operator.equals("*")){
				//multiply
				System.out.print("Multiplication: ");
				makeProperFraction(multiply(impNumerator1, denominator1, impNumerator2, denominator2));
			}else if(operator.equals("/")){
				//divide
				System.out.print("Division: ");
				makeProperFraction(divide(impNumerator1, denominator1, impNumerator2, denominator2));
			}else if(operator.equals("+")){
				//add
				System.out.print("Addition: ");
				makeProperFraction(add(impNumerator1, impNumerator2, LCM, denominator1, denominator2));
			}else if(operator.equals("-")){
				//subtract
				System.out.print("Subtraction: ");
				makeProperFraction(subtract(impNumerator1, impNumerator2, LCM, denominator1, denominator2));
			}
		}
		
		System.out.println("Your program has ended!");

	}
}