/**
 * 
 */
package com.oup.ae.integration.materialmaster.util;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author gunakalc
 *
 */
public class MaterialMasterConstants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6743951055077642797L;
	/**
	 * 
	 */

	public static final String PLANT_CODE = "0001";
	public static final String WEIGHT_UNIT = "KGM";
	public static final String VOLUME_UNIT = "CMQ";
	public static final String LENGTH_UNIT = "CMT";
	public static final String COUNTRY_CODE = "HK";
	public static final String COUNTRY_OF_ORIGIN_CN = "CN";

	public static final BigDecimal ZERO_OFFSET = new BigDecimal("0.000");

	public static final String EMPTY = "";

}
