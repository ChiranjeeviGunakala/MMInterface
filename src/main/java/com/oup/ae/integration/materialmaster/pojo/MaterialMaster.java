//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.31 at 05:52:58 PM IST 
//


package com.oup.ae.integration.materialmaster.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Transmission-Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Country-Code">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="3"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Plant-Code">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="50"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Material-Num">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Article-Desc" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Article-Language-Code">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Article-Short-Desc">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="70"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Article-Long-Desc">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="70"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Media-Product" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="18"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Material-Type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Article-Group">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Base-Unit-of-Measure">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Net-Weight">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Plant">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FMC" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Commodity-Code">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="17"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Country-Origin">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Unit-Of-Measure-Of-Display" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Length">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Width">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Height">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Base-Unit-of-Measure-Length">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Base-Unit-of-Measure-Volume">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Gross-Weight">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Base-Unit-of-Measure-Weight">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transmissionHeader",
    "materialNum",
    "articleDesc",
    "mediaProduct",
    "materialType",
    "articleGroup",
    "baseUnitOfMeasure",
    "netWeight",
    "plant",
    "fmc",
    "commodityCode",
    "countryOrigin",
    "unitOfMeasureOfDisplay",
    "length",
    "width",
    "height",
    "baseUnitOfMeasureLength",
    "baseUnitOfMeasureVolume",
    "grossWeight",
    "baseUnitOfMeasureWeight"
})
@XmlRootElement(name = "Material-Master")
public class MaterialMaster {

    @XmlElement(name = "Transmission-Header", required = true)
    protected MaterialMaster.TransmissionHeader transmissionHeader;
    @XmlElement(name = "Material-Num", required = true)
    protected String materialNum;
    @XmlElement(name = "Article-Desc", required = true)
    protected List<MaterialMaster.ArticleDesc> articleDesc;
    @XmlElement(name = "Media-Product")
    protected String mediaProduct;
    @XmlElement(name = "Material-Type", required = true)
    protected String materialType;
    @XmlElement(name = "Article-Group", required = true)
    protected String articleGroup;
    @XmlElement(name = "Base-Unit-of-Measure", required = true)
    protected String baseUnitOfMeasure;
    @XmlElement(name = "Net-Weight", required = true)
    protected BigDecimal netWeight;
    @XmlElement(name = "Plant", required = true)
    protected String plant;
    @XmlElement(name = "FMC")
    protected String fmc;
    @XmlElement(name = "Commodity-Code", required = true)
    protected String commodityCode;
    @XmlElement(name = "Country-Origin", required = true)
    protected String countryOrigin;
    @XmlElement(name = "Unit-Of-Measure-Of-Display")
    protected String unitOfMeasureOfDisplay;
    @XmlElement(name = "Length", required = true)
    protected BigDecimal length;
    @XmlElement(name = "Width", required = true)
    protected BigDecimal width;
    @XmlElement(name = "Height", required = true)
    protected BigDecimal height;
    @XmlElement(name = "Base-Unit-of-Measure-Length", required = true)
    protected String baseUnitOfMeasureLength;
    @XmlElement(name = "Base-Unit-of-Measure-Volume", required = true)
    protected String baseUnitOfMeasureVolume;
    @XmlElement(name = "Gross-Weight", required = true)
    protected BigDecimal grossWeight;
    @XmlElement(name = "Base-Unit-of-Measure-Weight", required = true)
    protected String baseUnitOfMeasureWeight;

    /**
     * Gets the value of the transmissionHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MaterialMaster.TransmissionHeader }
     *     
     */
    public MaterialMaster.TransmissionHeader getTransmissionHeader() {
        return transmissionHeader;
    }

    /**
     * Sets the value of the transmissionHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialMaster.TransmissionHeader }
     *     
     */
    public void setTransmissionHeader(MaterialMaster.TransmissionHeader value) {
        this.transmissionHeader = value;
    }

    /**
     * Gets the value of the materialNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialNum() {
        return materialNum;
    }

    /**
     * Sets the value of the materialNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialNum(String value) {
        this.materialNum = value;
    }

    /**
     * Gets the value of the articleDesc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleDesc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleDesc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaterialMaster.ArticleDesc }
     * 
     * 
     */
    public List<MaterialMaster.ArticleDesc> getArticleDesc() {
        if (articleDesc == null) {
            articleDesc = new ArrayList<MaterialMaster.ArticleDesc>();
        }
        return this.articleDesc;
    }

    /**
     * Gets the value of the mediaProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediaProduct() {
        return mediaProduct;
    }

    /**
     * Sets the value of the mediaProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaProduct(String value) {
        this.mediaProduct = value;
    }

    /**
     * Gets the value of the materialType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * Sets the value of the materialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterialType(String value) {
        this.materialType = value;
    }

    /**
     * Gets the value of the articleGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleGroup() {
        return articleGroup;
    }

    /**
     * Sets the value of the articleGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleGroup(String value) {
        this.articleGroup = value;
    }

    /**
     * Gets the value of the baseUnitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnitOfMeasure() {
        return baseUnitOfMeasure;
    }

    /**
     * Sets the value of the baseUnitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnitOfMeasure(String value) {
        this.baseUnitOfMeasure = value;
    }

    /**
     * Gets the value of the netWeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * Sets the value of the netWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetWeight(BigDecimal value) {
        this.netWeight = value;
    }

    /**
     * Gets the value of the plant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlant() {
        return plant;
    }

    /**
     * Sets the value of the plant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlant(String value) {
        this.plant = value;
    }

    /**
     * Gets the value of the fmc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMC() {
        return fmc;
    }

    /**
     * Sets the value of the fmc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMC(String value) {
        this.fmc = value;
    }

    /**
     * Gets the value of the commodityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommodityCode() {
        return commodityCode;
    }

    /**
     * Sets the value of the commodityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommodityCode(String value) {
        this.commodityCode = value;
    }

    /**
     * Gets the value of the countryOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOrigin() {
        return countryOrigin;
    }

    /**
     * Sets the value of the countryOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOrigin(String value) {
        this.countryOrigin = value;
    }

    /**
     * Gets the value of the unitOfMeasureOfDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasureOfDisplay() {
        return unitOfMeasureOfDisplay;
    }

    /**
     * Sets the value of the unitOfMeasureOfDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasureOfDisplay(String value) {
        this.unitOfMeasureOfDisplay = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLength(BigDecimal value) {
        this.length = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWidth(BigDecimal value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    /**
     * Gets the value of the baseUnitOfMeasureLength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnitOfMeasureLength() {
        return baseUnitOfMeasureLength;
    }

    /**
     * Sets the value of the baseUnitOfMeasureLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnitOfMeasureLength(String value) {
        this.baseUnitOfMeasureLength = value;
    }

    /**
     * Gets the value of the baseUnitOfMeasureVolume property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnitOfMeasureVolume() {
        return baseUnitOfMeasureVolume;
    }

    /**
     * Sets the value of the baseUnitOfMeasureVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnitOfMeasureVolume(String value) {
        this.baseUnitOfMeasureVolume = value;
    }

    /**
     * Gets the value of the grossWeight property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    /**
     * Sets the value of the grossWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossWeight(BigDecimal value) {
        this.grossWeight = value;
    }

    /**
     * Gets the value of the baseUnitOfMeasureWeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUnitOfMeasureWeight() {
        return baseUnitOfMeasureWeight;
    }

    /**
     * Sets the value of the baseUnitOfMeasureWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUnitOfMeasureWeight(String value) {
        this.baseUnitOfMeasureWeight = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Article-Language-Code">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Article-Short-Desc">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="70"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Article-Long-Desc">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="70"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "articleLanguageCode",
        "articleShortDesc",
        "articleLongDesc"
    })
    public static class ArticleDesc {

        @XmlElement(name = "Article-Language-Code", required = true)
        protected String articleLanguageCode;
        @XmlElement(name = "Article-Short-Desc", required = true)
        protected String articleShortDesc;
        @XmlElement(name = "Article-Long-Desc", required = true)
        protected String articleLongDesc;

        /**
         * Gets the value of the articleLanguageCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArticleLanguageCode() {
            return articleLanguageCode;
        }

        /**
         * Sets the value of the articleLanguageCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArticleLanguageCode(String value) {
            this.articleLanguageCode = value;
        }

        /**
         * Gets the value of the articleShortDesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArticleShortDesc() {
            return articleShortDesc;
        }

        /**
         * Sets the value of the articleShortDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArticleShortDesc(String value) {
            this.articleShortDesc = value;
        }

        /**
         * Gets the value of the articleLongDesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArticleLongDesc() {
            return articleLongDesc;
        }

        /**
         * Sets the value of the articleLongDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArticleLongDesc(String value) {
            this.articleLongDesc = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Country-Code">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="3"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Plant-Code">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="50"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "countryCode",
        "plantCode"
    })
    public static class TransmissionHeader {

        @XmlElement(name = "Country-Code", required = true)
        protected String countryCode;
        @XmlElement(name = "Plant-Code", required = true)
        protected String plantCode;

        /**
         * Gets the value of the countryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Sets the value of the countryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        /**
         * Gets the value of the plantCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlantCode() {
            return plantCode;
        }

        /**
         * Sets the value of the plantCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlantCode(String value) {
            this.plantCode = value;
        }

    }

}