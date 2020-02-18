package com.ecommerce.platform.api.server.builder;

import java.util.UUID;

import org.apache.commons.lang3.math.NumberUtils;

public class BuilderPopulator {
	
	public enum Attribute {
		ID,
		CATEGORY,
		NAME,
		BRAND,
		PRODUCTLINE,
		NUMCORES,
		PROCESSORCLOCKSPEED,
		GRAPHICCLOCKSPEED,
		DIMENSION,
		RESOLUTION,
		COLOUR,
		INTERFACETYPE,
		SIZE,
		PRICE,
		QUANTITY
	}

	public static Builder populateBuilder(String componentString) {
		
		Builder builder = new Builder();
		
    	String[] attributeString = componentString.split(",");
    			
    	builder.id(UUID.fromString(attributeString[Attribute.ID.ordinal()].trim()));
    	builder.category(attributeString[Attribute.CATEGORY.ordinal()].trim());
    	builder.name(attributeString[Attribute.NAME.ordinal()].trim());
    	builder.brand(attributeString[Attribute.BRAND.ordinal()].trim());
    	builder.productLine(attributeString[Attribute.PRODUCTLINE.ordinal()].trim());  	
    	builder.numberOfCores(NumberUtils.isParsable(attributeString[Attribute.NUMCORES.ordinal()].trim()) ? Integer.parseInt(attributeString[Attribute.NUMCORES.ordinal()].trim()) : 0);   	
    	builder.processorClockSpeed(attributeString[Attribute.PROCESSORCLOCKSPEED.ordinal()].trim());
    	builder.graphicsClockSpeed(attributeString[Attribute.GRAPHICCLOCKSPEED.ordinal()].trim());
    	builder.dimension(attributeString[Attribute.DIMENSION.ordinal()].trim());
    	builder.resolution(attributeString[Attribute.RESOLUTION.ordinal()].trim());
    	builder.colour(attributeString[Attribute.COLOUR.ordinal()].trim());
    	builder.interfaceType(attributeString[Attribute.INTERFACETYPE.ordinal()].trim());
    	builder.size(attributeString[Attribute.SIZE.ordinal()].trim());
    	builder.price(NumberUtils.isParsable(attributeString[Attribute.PRICE.ordinal()].trim()) ? Integer.parseInt(attributeString[Attribute.PRICE.ordinal()].trim()) : 0);
    	builder.quantity(NumberUtils.isParsable(attributeString[Attribute.QUANTITY.ordinal()].trim()) ? Integer.parseInt(attributeString[Attribute.QUANTITY.ordinal()].trim()) : 0);
    	
    	return builder;
    }
}
