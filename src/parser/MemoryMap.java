package parser;

import java.util.Vector;

public class MemoryMap {
	
	Vector<String> dataSegment;
	Vector<String> textSegment;
	String activeSegment;
	
	public Vector<String> getDataSegment() {
		return dataSegment;
	}

	public void setDataSegment(Vector<String> dataSegment) {
		this.dataSegment = dataSegment;
	}

	public Vector<String> getTextSegment() {
		return textSegment;
	}

	public void setTextSegment(Vector<String> textSegment) {
		this.textSegment = textSegment;
	}

	public String getActiveSegment() {
		return activeSegment;
	}

	public void setActiveSegment(String activeSegment) {
		this.activeSegment = activeSegment;
	}

	public MemoryMap() {
		setActiveSegment(".data");
		textSegment = new Vector<String>();
		dataSegment = new Vector<String>();
	
	}
	
	public void add(String text) {
		
		if (getActiveSegment().equals(".data")) {
			dataSegment.add(text);
		} else if (getActiveSegment().equals(".text")) {
			textSegment.add(text);
		}
		
	}

	public String getString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < dataSegment.size(); i++) {
        	str.append(dataSegment.get(i) + "\n");
        }
        
        for (int i = 0; i < textSegment.size(); i++) {
        	str.append(textSegment.get(i) + "\n");
        }
        
        return str.toString();
   		
	}

}
