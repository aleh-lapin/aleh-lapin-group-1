package jmp.module05.testing.utils;

import java.math.BigDecimal;
import java.util.TimerTask;

import jmp.module05.testing.service.CurrencyType;
import jmp.module05.testing.service.Exchanger;
import jmp.module05.testing.utils.Utils;

public class ExchangeTask extends TimerTask {
	
	private Exchanger exchanger;

	@Override
	public void run() {
		com.jmpClassloadin.xml.bind.exchanger.ExchangerDocument document = 
				exchanger.getDocument();
		com.jmpClassloadin.xml.bind.exchanger.ExchangerType exchanger =
				document.getExchanger();
		exchanger.setBASICCURRENCY(
				com.jmpClassloadin.xml.bind.currency.CurrencyType.Enum.forString(
						randCurrencyType()));
		com.jmpClassloadin.xml.bind.currency.Currency[] currencies =
				exchanger.getCourseArray();
		for(com.jmpClassloadin.xml.bind.currency.Currency currency : currencies) {
			currency.setBigDecimalValue(BigDecimal.valueOf(rand()));
		}
		Utils.wrieDocument(exchanger.getDomNode(), 
				Utils.getFilePath(getClass(), "exchanger.xml"));
	}

	private double rand() {
		return Math.random() * 1000D;
	}
	
	private String randCurrencyType(){
		int type = 3;
		type *= Math.random();
		CurrencyType[] types = CurrencyType.values();
		return types[type].getType();
	}
	
	public Exchanger getExchanger() {
		return exchanger;
	}

	public void setExchanger(Exchanger exchanger) {
		this.exchanger = exchanger;
	}
	
}
