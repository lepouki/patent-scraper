package scraper.core.processors;

import scraper.core.Document;

public abstract class IntegerPagePropertyProcessor extends SinglePropertyPageProcessor {

	private int value;

	public IntegerPagePropertyProcessor(String propertyName, PageProcessor pageProcessor) {
		super(propertyName, pageProcessor);
	}

	@Override
	public void processDocument(Document document) {
		try {
			value = getValue();
		}
		catch (NoSuchPropertyException exception) {
			value = 0;
		}
	}

	@Override
	public String getPropertyValue() {
		return Integer.toString(value);
	}

	protected abstract int getValue() throws NoSuchPropertyException;

}