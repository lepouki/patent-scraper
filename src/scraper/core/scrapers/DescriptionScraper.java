package scraper.core.scrapers;

import scraper.core.Document;
import scraper.core.writers.BasicFileWriter;

public class DescriptionScraper extends FileChangingPagePropertyScraper {

	private static final String READABLE_NAME = "Description";

	private String description;

	public DescriptionScraper(PageScraper pageScraper) {
		super(READABLE_NAME, pageScraper);

		setFileWriter(
			new BasicFileWriter()
		);
	}

	@Override
	public void processDocument(Document document) throws NoSuchPropertyException {
		description = selectFirst("section[itemprop=description]").wholeText();

		boolean isDescriptionEmpty = description.isEmpty();
		if (isDescriptionEmpty) {
			throw new NoSuchPropertyException();
		}

		setOutputFileForDocument(document);
	}

	private void setOutputFileForDocument(Document document) {
		setRelativeFileWriterFile("extra/description/" + document.identifier + ".txt");
	}

	@Override
	public String[] getPropertyData() {
		return new String[] {description};
	}

}
