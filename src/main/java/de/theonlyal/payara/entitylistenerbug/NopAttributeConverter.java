package de.theonlyal.payara.entitylistenerbug;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class NopAttributeConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(final String attribute) {
		return attribute;
	}

	@Override
	public String convertToEntityAttribute(final String dbData) {
		return dbData;
	}
}