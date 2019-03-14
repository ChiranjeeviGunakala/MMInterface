/**
 * 
 */
package com.oup.ae.integration.materialmaster.util;

/**
 * @author 677644
 *
 */
public class MeasurementConvertion {

	// Default Centimeter
	public static double defaultCMT(final String cmt) {

		return Double.valueOf(cmt);
	}

	// Decimal meter to centimeter
	public static double convert_DMT_CMT(String dmt) {

		double decimeter = Double.valueOf(dmt);
		double cmt = decimeter * 10;
		return cmt;
	}

	// Feet to Centimeter
	public static double convert_FT_CMT(String mtr) {
		double feet = Double.valueOf(mtr);
		double cmt = feet * 30.48;
		return cmt;
	}

	// inches to centimeters
	public static double convert_INH_CMT(String inh) {
		double inch = Double.valueOf(inh);
		double cmt = inch * 2.54;
		return cmt;
	}

	// kilometer to Centimeter
	public static double convert_KMT_CMT(String mtr) {
		double kiloMeter = Double.valueOf(mtr);
		double cmt = kiloMeter * 100000;
		return cmt;
	}

	// Meter to Centimeter
	public static double convert_MTR_CMT(String mtr) {
		double meter = Double.valueOf(mtr);
		double cmt = meter * 100;
		return cmt;
	}

	// Mile to Centimeter
	public static double convert_SMI_CMT(String mtr) {
		double mile = Double.valueOf(mtr);
		double cmt = mile * 160934;
		return cmt;
	}

	// Micro meter to Centimeter
	public static double convert_MIM_CMT(String mtr) {

		double mile = Double.valueOf(mtr);
		double cmt = mile * 0.0001;
		return cmt;
	}

	// MilliMeter to Centimeter
	public static double convert_MMT_CMT(String mtr) {

		double milliMeter = Double.valueOf(mtr);
		double cmt = milliMeter * 0.1;
		return cmt;
	}

	// Nano meter to Centimeter
	public static double convert_NAM_CMT(String mtr) {

		double nanoMeter = Double.valueOf(mtr);
		double cmt = nanoMeter * 0.0000001;
		return cmt;
	}

	// Yards to Centimeter
	public static double convert_YD_CMT(String mtr) {

		double yards = Double.valueOf(mtr);
		double cmt = yards * 91.44;
		return cmt;
	}

	// ---------------------------------------
	// Cubic Decimal Meter to Cubic CentiMeter
	public static double convert_DMQ_CCM(String dmq) {

		double cubicDecimalMeter = Double.valueOf(dmq);
		double ccm = cubicDecimalMeter * 1000;
		return ccm;
	}

	// Cubic Meter to Cubic CentiMeter
	public static double convert_MTQ_CCM(String mtq) {

		double cubicMeter = Double.valueOf(mtq);
		double ccm = cubicMeter * 1000000;
		return ccm;
	}

	// Cubic Inch to Cubic CentiMeter
	public static double convert_IN3_CCM(String mtq) {

		double cubicInch = Double.valueOf(mtq);
		double ccm = cubicInch * 16.3871;
		return ccm;
	}

	// Cubic Foot to Cubic CentiMeter
	public static double convert_FT3_CCM(String mtq) {

		double cubicFoot = Double.valueOf(mtq);
		double ccm = cubicFoot * 16.3871;
		return ccm;
	}

	public static double convertionToCMT(String measurement, String val) {

		double value = 0;

		switch (measurement) {

		case "CMT":
		case "CM":
			value = defaultCMT(val);
			break;

		case "DMT":
		case "DM":
			value = convert_DMT_CMT(val);
			break;

		case "FT":
			value = convert_FT_CMT(val);
			break;

		case "INH":
		case "IN":
			value = convert_INH_CMT(val);
			break;

		case "KM":
		case "KMT":
			value = convert_KMT_CMT(val);
			break;

		case "MTR":
		case "M":
			value = convert_MTR_CMT(val);
			break;

		case "MI":
		case "SMI":
			value = convert_SMI_CMT(val);
			break;

		case "MIM":
		case "4H":
			value = convert_MTR_CMT(val);
			break;

		case "MMT":
		case "MM":
			value = convert_MMT_CMT(val);
			break;

		case "NAM":
		case "C45":
			value = convert_NAM_CMT(val);
			break;

		case "YD":
			value = convert_YD_CMT(val);
			break;

		case "DMQ":
			value = convert_DMQ_CCM(val);
			break;

		case "MTQ":
			value = convert_MTQ_CCM(val);
			break;

		case "IN3":
			value = convert_IN3_CCM(val);
			break;

		case "FT3":
			value = convert_FT3_CCM(val);
			break;
		}
		return value;
	}

}
