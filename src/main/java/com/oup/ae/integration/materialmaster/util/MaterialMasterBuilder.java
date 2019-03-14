/**
 * 
 */
package com.oup.ae.integration.materialmaster.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.StringUtils;
import org.fusesource.camel.component.sap.model.idoc.Segment;
import org.slf4j.Logger;

import com.oup.ae.integration.materialmaster.pojo.MaterialMaster;
import com.oup.ae.integration.materialmaster.pojo.MaterialMaster.ArticleDesc;
import com.oup.ae.integration.materialmaster.pojo.MaterialMaster.TransmissionHeader;
import com.oup.ae.integration.materialmaster.exception.ValidationException;
import com.oup.ae.integration.materialmaster.pojo.ObjectFactory;

/**
 * @author 677644
 *
 */
public class MaterialMasterBuilder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8202854411135346055L;

	final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	final IDOCParserUtil idcoParserUtil = new IDOCParserUtil();

	final ObjectFactory objectFactory = new ObjectFactory();

	public void populateE1MARCM(final Segment segment, final MaterialMaster materialMaster) throws Exception {

		final String segE1MARAM_E1MARCM = "E1MARAM->E1MARCM";
		final LinkedList<Segment> E1MARCM = new IDOCParserUtil().getSegment(segment, segE1MARAM_E1MARCM, false);
		if (!E1MARCM.isEmpty()) {
			for (final Segment segE1MARCM : E1MARCM) {
				logger.debug(" The Segment E1MARCM value is :" + new ReflectionToStringBuilder(segE1MARCM));
				// Plant Code
				final String WERKS = (String) segE1MARCM.get("WERKS");
				logger.debug(" The value of WERKS is : " + WERKS);
				// Validation for Plant code
				if (WERKS != null && !MaterialMasterConstants.PLANT_CODE.equals(WERKS)) {
					throw new ValidationException("Invalid Plant : " + WERKS);
				}
				// As of now SAP sending only 0001 as Plant code --> 0001 is
				// hard coded here
				materialMaster.setPlant(MaterialMasterConstants.PLANT_CODE);

				// Commodity Code/Import Code Number for Foreign Trade
				final String STAWN = (String) segE1MARCM.get("STAWN");
				logger.debug("The value of STAWN(Commodity Code/Import Code Number for Foreign Trade) is : " + STAWN);
				materialMaster.setCommodityCode(STAWN);

				// Country of origin of the material
				final String HERKL = (String) segE1MARCM.get("HERKL");
				logger.debug("The value of HERKL( Country of origin of the material) is : " + HERKL);
				if(null!=HERKL && !HERKL.isEmpty()){
					materialMaster.setCountryOrigin(HERKL);
				}else{
					materialMaster.setCountryOrigin(MaterialMasterConstants.COUNTRY_OF_ORIGIN_CN);
				}

				// ABC Indicator
				final String MAABC = (String) segE1MARCM.get("MAABC");
				logger.debug("The value of MAABC( ABC Indicator) is : " + HERKL);
				materialMaster.setFMC(MAABC);
			}
		} else {
			// If segment / Subsegment are missing from SAP , SM team will send
			// those with empty values.
			materialMaster.setPlant(MaterialMasterConstants.PLANT_CODE);
			materialMaster.setCommodityCode(MaterialMasterConstants.EMPTY);
			materialMaster.setCountryOrigin(MaterialMasterConstants.COUNTRY_OF_ORIGIN_CN);
			materialMaster.setFMC(MaterialMasterConstants.EMPTY);
		}

	}

	public void populateE1MARAM(final Segment segment, final MaterialMaster materialMaster) throws Exception {

		final String seg_E1MARAM = "E1MARAM";
		final LinkedList<Segment> E1MARAM = new IDOCParserUtil().getSegment(segment, seg_E1MARAM, true);
		String MEINS = null;

		for (final Segment segE1MARAM : E1MARAM) {
			logger.debug(" The Segment E1MARAM value is :" + new ReflectionToStringBuilder(segE1MARAM));

			// Material Number
			final String MATNR = (String) segE1MARAM.get("MATNR");
			logger.debug("The value of MATNR (Material Number) is :" + MATNR);
			materialMaster.setMaterialNum(MATNR);

			// Material Type
			final String MTART = (String) segE1MARAM.get("MTART");
			logger.debug("The value of MTART(Material Type) is :" + MTART);
			materialMaster.setMaterialType(MTART);

			// Material Group
			final String MATKL = (String) (String) segE1MARAM.get("MATKL");
			logger.debug("The value of MATKL(Meterail Group) is :" + MATKL);
			materialMaster.setArticleGroup(MATKL);

			// Base Unit of Measure
			MEINS = (String) segE1MARAM.get("MEINS");
			logger.debug("The value of MEINS(Base Unit of Measure) is :" + MEINS);
			materialMaster.setBaseUnitOfMeasure(MEINS);

			// Unit of Measure for Display
			materialMaster.setUnitOfMeasureOfDisplay(MEINS);

			// Net Weight
			final BigDecimal NTGEW = (BigDecimal) segE1MARAM.get("NTGEW");
			logger.debug("The value of NTGEW (Net Weight) is :" + NTGEW);
			materialMaster.setNetWeight(NTGEW);
			if (NTGEW == null || NTGEW.toString().equalsIgnoreCase("")) {
				materialMaster.setNetWeight(MaterialMasterConstants.ZERO_OFFSET);
			}

			// Base-Unit-of-Measure-Weight
			materialMaster.setBaseUnitOfMeasureWeight(MaterialMasterConstants.WEIGHT_UNIT);

			// Gross Weigh
			final BigDecimal BRGEW = (BigDecimal) segE1MARAM.get("BRGEW");
			logger.debug(" The Value of BRGEW(Gross Weigh) is :" + BRGEW);
			materialMaster.setGrossWeight(BRGEW);
			if (BRGEW == null || BRGEW.toString().equalsIgnoreCase("")) {
				materialMaster.setGrossWeight(MaterialMasterConstants.ZERO_OFFSET);
			}

			// Volum Weight - always weight unit will be CMQ
			materialMaster.setBaseUnitOfMeasureVolume(MaterialMasterConstants.VOLUME_UNIT);

			// Unit of Dimension for Length/Width/Height - always weight unit
			// will be CMT
			materialMaster.setBaseUnitOfMeasureLength(MaterialMasterConstants.LENGTH_UNIT);

			// Length
			final BigDecimal LAENG = (BigDecimal) segE1MARAM.get("LAENG");
			logger.debug(" The Value of LAENG (Length) is :" + LAENG);
			materialMaster.setLength(LAENG);
			if (LAENG == null || LAENG.toString().equalsIgnoreCase("")) {
				materialMaster.setLength(MaterialMasterConstants.ZERO_OFFSET);
			}

			// Width
			final BigDecimal BREIT = (BigDecimal) segE1MARAM.get("BREIT");
			logger.debug(" The Value of BREIT (Width) is :" + BREIT);
			materialMaster.setWidth(BREIT);
			if (BREIT == null || BREIT.toString().equalsIgnoreCase("")) {
				materialMaster.setWidth(MaterialMasterConstants.ZERO_OFFSET);
			}

			// Height
			final BigDecimal HOEHE = (BigDecimal) segE1MARAM.get("HOEHE");
			logger.debug(" The Value of HOEHE (Height) is :" + HOEHE);
			materialMaster.setHeight(HOEHE);
			if (HOEHE == null || HOEHE.toString().equalsIgnoreCase("")) {
				materialMaster.setHeight(MaterialMasterConstants.ZERO_OFFSET);
			}

			final String MEABM = (String) segE1MARAM.get("MEABM");
			logger.debug("The value of MEABM (Unit of Dimension for Length/Width/Height) is : " + MEABM);

			if (MEABM != null && !(MEABM).trim().equalsIgnoreCase(StringUtils.EMPTY)
					&& !MaterialMasterConstants.LENGTH_UNIT.equals((String) MEABM)) {

				// Length
				logger.debug("The value of length is " + LAENG + " In Measurement unit of " + MEABM);
				final BigDecimal length = BigDecimal
						.valueOf(MeasurementConvertion.convertionToCMT(MEABM, LAENG.toString()));
				materialMaster.setLength(length);
				logger.debug("The Converted " + MEABM + " -> " + MaterialMasterConstants.LENGTH_UNIT
						+ " value of Length is : " + length);

				// Width
				logger.debug("The value of width is " + BREIT.toString() + " In Measurement unit of " + MEABM);
				final BigDecimal width = BigDecimal
						.valueOf(MeasurementConvertion.convertionToCMT(MEABM, BREIT.toString()));
				materialMaster.setWidth(width);
				logger.debug("The Converted " + MEABM + " -> " + MaterialMasterConstants.LENGTH_UNIT
						+ " value of Width is : " + width);

				// Height
				logger.debug("The value of height is " + HOEHE.toString() + " In Measurement unit of " + MEABM);
				final BigDecimal height = BigDecimal
						.valueOf(MeasurementConvertion.convertionToCMT(MEABM, HOEHE.toString()));
				materialMaster.setHeight(height);
				logger.debug("The Converted " + MEABM + " -> " + MaterialMasterConstants.LENGTH_UNIT
						+ " value of Height is : " + height);
			}
		}
	}

	// --- The Segment Values of E1MARAMM are populated from Segment MARAM
	public void populateE1MARMM(final Segment segment, final MaterialMaster materialMaster) throws Exception {

		// Setting for the Segment E1MARAM->E1MARMM and Choose the E1MARMM based
		// upon logic E1MARMM.MEINH=E1MARAM.MEINS
		final String seg_E1MARAM_E1MARMM = "E1MARAM->E1MARMM";
		final LinkedList<Segment> E1MARMM = new IDOCParserUtil().getSegment(segment, seg_E1MARAM_E1MARMM, false);
		if (!E1MARMM.isEmpty()) {
			for (Segment segE1MARMM : E1MARMM) {
				logger.debug(" The Segment E1MARMM value is :" + new ReflectionToStringBuilder(segE1MARMM));
				final String MEINH = (String) segE1MARMM.get("MEINH");
				/*
				 * Choose the E1MARMM based upon logic
				 * E1MARMM.MEINH=E1MARAM.MEINS
				 */
				if (MEINH.equalsIgnoreCase(materialMaster.getBaseUnitOfMeasure())) {

					// Unit of Measure for Display
					materialMaster.setUnitOfMeasureOfDisplay(MEINH);

					// Unit of Dimension for Length/Width/Height - always weight
					// unit will be CMT
					materialMaster.setBaseUnitOfMeasureLength(MaterialMasterConstants.LENGTH_UNIT);

					// Volum Weight - always weight unit will be CMQ
					materialMaster.setBaseUnitOfMeasureVolume(MaterialMasterConstants.VOLUME_UNIT);

					// Unit Weight - always weight unit will be KGM
					materialMaster.setBaseUnitOfMeasureWeight(MaterialMasterConstants.WEIGHT_UNIT);

					// Length
					final BigDecimal LAENG = (BigDecimal) segE1MARMM.get("LAENG");
					logger.debug(" The Value of LAENG (Length) is :" + LAENG);
					materialMaster.setLength(LAENG);
					if (LAENG.toString().equalsIgnoreCase("") || LAENG == null) {
						materialMaster.setLength(MaterialMasterConstants.ZERO_OFFSET);
					}

					// Width
					final BigDecimal BREIT = (BigDecimal) segE1MARMM.get("BREIT");
					logger.debug(" The Value of BREIT (Width) is :" + BREIT);
					materialMaster.setWidth(BREIT);
					if (BREIT.toString().equalsIgnoreCase("") || BREIT == null) {
						materialMaster.setWidth(MaterialMasterConstants.ZERO_OFFSET);
					}

					// Height
					final BigDecimal HOEHE = (BigDecimal) segE1MARMM.get("HOEHE");
					logger.debug(" The Value of HOEHE (Height) is :" + HOEHE);
					materialMaster.setHeight(HOEHE);
					if (HOEHE.toString().equalsIgnoreCase("") || HOEHE == null) {
						materialMaster.setHeight(MaterialMasterConstants.ZERO_OFFSET);
					}

					// Gross Weigh
					final BigDecimal BRGEW = (BigDecimal) segE1MARMM.get("BRGEW");
					logger.debug(" The Value of BRGEW(Gross Weigh) is :" + BRGEW);
					materialMaster.setGrossWeight(BRGEW);
					if (BRGEW.toString().equalsIgnoreCase("") || BRGEW == null) {
						materialMaster.setGrossWeight(MaterialMasterConstants.ZERO_OFFSET);
					}

					final String MEABM = (String) segE1MARMM.get("MEABM");
					logger.debug("The value of MEABM (Unit of Dimension for Length/Width/Height) is : " + MEABM);

					if (MEABM != null && !(MEABM).trim().equalsIgnoreCase(StringUtils.EMPTY)
							&& !MaterialMasterConstants.LENGTH_UNIT.equals((String) MEABM)) {

						// Length
						logger.debug("The value of length is " + LAENG + " In Measurement unit of " + MEABM);
						final BigDecimal length = BigDecimal
								.valueOf(MeasurementConvertion.convertionToCMT(MEABM, LAENG.toString()));
						materialMaster.setLength(length);
						logger.debug("The Converted " + MEABM + " -> " + MaterialMasterConstants.LENGTH_UNIT
								+ " value of Length is : " + length);

						// Width
						logger.debug("The value of width is " + BREIT.toString() + " In Measurement unit of " + MEABM);
						final BigDecimal width = BigDecimal
								.valueOf(MeasurementConvertion.convertionToCMT(MEABM, BREIT.toString()));
						materialMaster.setWidth(width);
						logger.debug("The Converted " + MEABM + " -> " + MaterialMasterConstants.LENGTH_UNIT
								+ " value of Width is : " + width);

						// Height
						logger.debug("The value of height is " + HOEHE.toString() + " In Measurement unit of " + MEABM);
						final BigDecimal height = BigDecimal
								.valueOf(MeasurementConvertion.convertionToCMT(MEABM, HOEHE.toString()));
						materialMaster.setHeight(height);
						logger.debug("The Converted " + MEABM + " -> " + MaterialMasterConstants.LENGTH_UNIT
								+ " value of Height is : " + height);
					}
					break;

				} else {
					// If segment / Subsegment are missing from SAP , SM team
					// will send those with empty values.
					populateDefaultE1MARMMValues(materialMaster);
				}
			}
		} else {
			// If segment / Subsegment are missing from SAP , SM team will send
			// those with empty values.
			populateDefaultE1MARMMValues(materialMaster);
		}

	}

	public void populateE1MAKTM(final Segment segment, final MaterialMaster materialMaster) throws Exception {

		// Setting for the Segment E1MARAM->E1MAKTM

		final String seg_E1MARAM_E1MAKTM = "E1MARAM->E1MAKTM";
		final LinkedList<Segment> E1MAKTM = new IDOCParserUtil().getSegment(segment, seg_E1MARAM_E1MAKTM, false);
		materialMaster.getArticleDesc().clear();

		if (!E1MAKTM.isEmpty()) {
			for (Segment segE1MAKTM : E1MAKTM) {
				final ArticleDesc articleDesc = objectFactory.createMaterialMasterArticleDesc();
				// ISO code for language key
				final String SPRAS_ISO = (String) segE1MAKTM.get("SPRAS_ISO");
				logger.debug("The value of SPRAS_ISO(ISO code for language key) is :" + SPRAS_ISO);
				articleDesc.setArticleLanguageCode(SPRAS_ISO);

				// Material Description (Short Text)
				final String MAKTX = (String) segE1MAKTM.get("MAKTX");
				logger.debug("The value of MAKTX (Material Description(Short Text) ) is :" + MAKTX);
				articleDesc.setArticleShortDesc(MAKTX);

				// Material Description (Long Text)
				articleDesc.setArticleLongDesc(MAKTX);
				materialMaster.getArticleDesc().add(articleDesc);
			}
		} else {
			// If segment / Subsegment are missing from SAP , SM team will send
			// those with empty values.
			final ArticleDesc articleDesc = objectFactory.createMaterialMasterArticleDesc();
			articleDesc.setArticleLanguageCode(MaterialMasterConstants.EMPTY);
			articleDesc.setArticleShortDesc(MaterialMasterConstants.EMPTY);
			articleDesc.setArticleLongDesc(MaterialMasterConstants.EMPTY);
			materialMaster.getArticleDesc().add(articleDesc);
		}
	}

	public void populateZ1MARAISM(final Segment segment, final MaterialMaster materialMaster) throws Exception {

		// Setting for the Segment E1MARAM->Z1MARAISM
		final String seg_E1MARAM_Z1MARAISM = "E1MARAM->Z1MARAISM";
		final LinkedList<Segment> Z1MARAISM = new IDOCParserUtil().getSegment(segment, seg_E1MARAM_Z1MARAISM, false);
		if (!Z1MARAISM.isEmpty()) {
			for (Segment segZ1MARAISM : Z1MARAISM) {
				// Higher-Level Media Product
				final String ISMREFMDPROD = (String) segZ1MARAISM.get("ISMREFMDPROD");
				logger.debug("The value of ISMREFMDPROD (Higher-Level Media Product) is :" + ISMREFMDPROD);
				materialMaster.setMediaProduct(ISMREFMDPROD);
			}
		} else {
			// If segment / Subsegment are missing from SAP , SM team will send
			// those with empty values.
			materialMaster.setMediaProduct(MaterialMasterConstants.EMPTY);
		}
	}

	public void populateTransmissionHeader(final MaterialMaster materialMaster) throws Exception {

		// Setting TransmissionHeader
		final TransmissionHeader transmissionHeader = objectFactory.createMaterialMasterTransmissionHeader();
		transmissionHeader.setCountryCode(MaterialMasterConstants.COUNTRY_CODE);
		transmissionHeader.setPlantCode(MaterialMasterConstants.PLANT_CODE);
		materialMaster.setTransmissionHeader(transmissionHeader);
	}

	public void populateDefaultE1MARMMValues(final MaterialMaster materialMaster) throws Exception {

		materialMaster.setUnitOfMeasureOfDisplay(MaterialMasterConstants.EMPTY);
		materialMaster.setBaseUnitOfMeasureLength(MaterialMasterConstants.LENGTH_UNIT);
		materialMaster.setBaseUnitOfMeasureVolume(MaterialMasterConstants.VOLUME_UNIT);
		materialMaster.setBaseUnitOfMeasureWeight(MaterialMasterConstants.WEIGHT_UNIT);
		materialMaster.setLength(MaterialMasterConstants.ZERO_OFFSET);
		materialMaster.setWidth(MaterialMasterConstants.ZERO_OFFSET);
		materialMaster.setHeight(MaterialMasterConstants.ZERO_OFFSET);
		materialMaster.setGrossWeight(MaterialMasterConstants.ZERO_OFFSET);

	}
}
