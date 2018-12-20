package com.thumati.ds.stacks;

public class DijkstrasAlgorithm {
	private Stacks<String> operatorsStack;
	private Stacks<Double> valuesStack;
	
	public DijkstrasAlgorithm() {
		this.operatorsStack = new Stacks<String>();
		this.valuesStack = new Stacks<Double>();
	}
	
	public void interpretExpression(String expression) {
		String[] strArray = expression.split(" ");
		for(String s : strArray) {
			if(s.equals("(")) {
				//do nothing
			}else if(s.equals("+")) {
				operatorsStack.push(s);
			}else if(s.equals("-")) {
				operatorsStack.push(s);
			}else if(s.equals("*")) {
				operatorsStack.push(s);
			}else if(s.equals("/")) {
				operatorsStack.push(s);
			}else if(s.equals(")")) {
				String operator = operatorsStack.pop();
				if(operator.equals("+")) {
					valuesStack.push(valuesStack.pop() + valuesStack.pop());
				}else if(operator.equals("*")) {
					valuesStack.push(valuesStack.pop() * valuesStack.pop());
				}else if(operator.equals("-")) {
					valuesStack.push(valuesStack.pop() - valuesStack.pop());
				}else if(operator.equals("/")) {
					Double operand1 = valuesStack.pop();
					Double operand2 = valuesStack.pop();
					valuesStack.push(operand2 / operand1);
				}
			}else {
				valuesStack.push(Double.parseDouble(s));
			}
		}
	}
	
	public void result() {
		System.out.println("Result : "+valuesStack.pop());
	}
	
	public static void main(String[] args) {
		//String s = "( ( 2 + 1 ) * ( 2 + 1 ) )";
		String s = "( ( ( ( 1 + 2 ) * 3 ) + 6 ) / ( 2 + 3 ) )";
		
		DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
		dijkstrasAlgorithm.interpretExpression(s);
		dijkstrasAlgorithm.result();
		
		System.out.println("5.0/15.0 : "+5.0/15.0);
		System.out.println("15.0/5.0 : "+15.0/5.0);
	}

}
