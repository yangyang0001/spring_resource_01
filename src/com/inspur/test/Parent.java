package com.inspur.test;

public class Parent extends GrandFather{

	@Override
	protected void sayHello(String data) {
		System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		this.resultData = "PPPPPPPPPPPPP" + data;
	}
	

}
