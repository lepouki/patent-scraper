package scraper.application.widgets;

import scraper.application.LayoutConfiguration;
import scraper.core.PropertyScraper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyScraperOptionGrid extends JPanel {

	private List<PropertyScraperOption> propertyScraperOptions;

	public PropertyScraperOptionGrid(List<PropertyScraper> propertyScrapers) {
		GridLayout layout = new GridLayout(0, LayoutConfiguration.OPTIONS_PER_ROW);
		setLayout(layout);

		createPropertyScraperOptions(propertyScrapers);
	}

	private void createPropertyScraperOptions(List<PropertyScraper> propertyScrapers) {
		int optionCount = propertyScrapers.size();
		propertyScraperOptions = new ArrayList<>(optionCount);

		for (PropertyScraper propertyScraper : propertyScrapers) {
			PropertyScraperOption propertyScraperOption = new PropertyScraperOption(propertyScraper);
			add(propertyScraperOption);
			propertyScraperOptions.add(propertyScraperOption);
		}
	}

	public List<PropertyScraper> getPropertyScrapers() {
		List<PropertyScraper> propertyScrapers = new ArrayList<>();

		for (PropertyScraperOption propertyScraperOption : propertyScraperOptions) {
			boolean selected = propertyScraperOption.isSelected();

			if (selected) {
				PropertyScraper propertyScraper = propertyScraperOption.getPropertyScraper();
				propertyScrapers.add(propertyScraper);
			}
		}

		return propertyScrapers;
	}

}