package com.sfeir.badcalculator.strategy;

public enum Operation implements Calcul {// - avec ou sans enum
	PLUS {
		public Integer eval(int opsi, int opei) {
			 System.out.println("Plus");
			 return opsi + opei;
		}
		
	},
	MOINS {
		public Integer eval(int opsi, int opei) {
			System.out.println("Moins");
            return opsi - opei;
		}
		
	},
	FOIS {
		public Integer eval(int opsi, int opei) {
			System.out.println("Fois");
            return opsi * opei;
		}
		
	},
	DIVISE{
		public Integer eval(int opsi, int opei) {
			System.out.println("Divisé");
            return opsi / opei;
		}
		
	}
	;
	
	
	
}
