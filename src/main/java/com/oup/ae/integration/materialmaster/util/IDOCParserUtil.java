package com.oup.ae.integration.materialmaster.util;

import java.util.LinkedList;

import org.fusesource.camel.component.sap.model.idoc.Segment;
import org.fusesource.camel.component.sap.model.idoc.SegmentList;
import org.slf4j.Logger;

import com.oup.ae.integration.materialmaster.exception.ImproperSegmentPathException;
import com.oup.ae.integration.materialmaster.exception.SegmentNotFoundException;

public class IDOCParserUtil {

	final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	public LinkedList<Segment> getSegment(Segment rootSegment, String pathToFindSegment, final boolean isMandatory)
			throws ImproperSegmentPathException, SegmentNotFoundException {
		LinkedList<Segment> segmentsFound = new LinkedList<>();
		if (pathToFindSegment == null || pathToFindSegment.isEmpty())
			throw new ImproperSegmentPathException("The path is invalid....");

		String[] segments = pathToFindSegment.split("->");
		LinkedList<Segment> segmentToSend = new LinkedList<>();
		segmentToSend.add(rootSegment);
		for (String segmentNameToFind : segments) {
			logger.debug("Finding the segment : " + segmentNameToFind);
			segmentsFound = new LinkedList<>();
			segmentToSend = this.getSingleSegmentUnderThePassedSegment(segmentToSend, segmentNameToFind, isMandatory);
			segmentsFound = segmentToSend;
			logger.debug("Number of segments found for  : " + segmentNameToFind + " is :" + segmentsFound.size());
		}
		if (isMandatory && segmentsFound.isEmpty()) {
			throw new SegmentNotFoundException("No segments found with the path provided:" + pathToFindSegment);
		}
		return segmentsFound;
	}

	public LinkedList<Segment> getSingleSegmentUnderThePassedSegment(LinkedList<Segment> segments, String segmentName, boolean isMandatory) {
		LinkedList<Segment> segmentsFound = new LinkedList<>();
		if (segments.isEmpty())
			return segmentsFound;
		
		segments.parallelStream().forEach(item->{
			LinkedList<Segment> newSegmentsFound = this.getSingleSegmentUnderThePassedSegment(item, segmentName, isMandatory);
			segmentsFound.addAll(newSegmentsFound);
		});
		return segmentsFound;
	}

	public LinkedList<Segment> getSingleSegmentUnderThePassedSegment(Segment segment, String segmentName,
			boolean isMandatory) {
		LinkedList<Segment> segmentsFound = new LinkedList<>();
		SegmentList<Segment> segments = segment.getChildren(segmentName);
		if ((segments == null || segments.isEmpty()) && !isMandatory) {
			logger.warn("Segment not found : " + segmentName);
		} else {
			for (Segment item : segments) {
				segmentsFound.add(item);
			}
		}
		return segmentsFound;
	}
}
