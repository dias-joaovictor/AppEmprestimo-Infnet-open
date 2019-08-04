package br.com.infnet.blocojava.appfinanceiro.utils;

public class ColumnMetadata {
	
	public ColumnMetadata(String title, Class<?> type) {
		super();
		this.title = title;
		this.type = type;
	}

	private String title;
	
	private Class<?> type;

	public String getTitle() {
		return title;
	}

	public Class<?> getType() {
		return type;
	}
	
	
	
}
