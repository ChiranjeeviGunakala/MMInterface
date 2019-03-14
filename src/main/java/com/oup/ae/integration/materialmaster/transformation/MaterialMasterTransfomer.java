/**
 * 
 */
package com.oup.ae.integration.materialmaster.transformation;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.fusesource.camel.component.sap.model.idoc.Document;
import org.fusesource.camel.component.sap.model.idoc.DocumentList;
import org.fusesource.camel.component.sap.model.idoc.Segment;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.oup.ae.integration.materialmaster.pojo.MaterialMaster;
import com.oup.ae.integration.materialmaster.pojo.ObjectFactory;
import com.oup.ae.integration.materialmaster.util.MaterialMasterBuilder;

/**
 * @author 677644
 *
 */
@Component("materialMasterTransfomer")
public class MaterialMasterTransfomer implements Processor {

	final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {

		final DocumentList documentList = exchange.getIn().getBody(DocumentList.class);
		final Document document = documentList.get(0);
		final Segment segment = document.getRootSegment();

		final ObjectFactory objectFactory = new ObjectFactory();
		final MaterialMaster materialMaster = objectFactory.createMaterialMaster();

		MaterialMasterBuilder materialMasterBuilder = new MaterialMasterBuilder();

		logger.debug("The IDOC Number : " + document.getIDocNumber() + " is associated with Unique Identifier : "
				+ exchange.getProperty("UUID"));

		materialMasterBuilder.populateTransmissionHeader(materialMaster);

		materialMasterBuilder.populateE1MARAM(segment, materialMaster);

		materialMasterBuilder.populateE1MARCM(segment, materialMaster);

		// materialMasterBuilder.populateE1MARMM(segment, materialMaster);

		materialMasterBuilder.populateZ1MARAISM(segment, materialMaster);

		materialMasterBuilder.populateE1MAKTM(segment, materialMaster);

		exchange.getIn().setBody(materialMaster);
	}

}
