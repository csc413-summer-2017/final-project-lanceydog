package com.example.lance.bartapp;

/**
 * Created by lance on 8/5/2017.
 */

import android.util.Log;

import com.example.lance.bartapp.Model.Last;
import com.example.lance.bartapp.Model.Plan;
import com.example.lance.bartapp.Model.Trip;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class BartApi {

    private static Document getDocumentFromXmlString(String xml) {
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);
        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }
        return doc;
    }

    public static Plan parseSchedule(String scheduleResponse) {
        Document document = getDocumentFromXmlString(scheduleResponse);
        Plan schedule = null;
        if (document != null) {
            NodeList nodes = document.getElementsByTagName("schedule");
            if (nodes.getLength() > 0) {
                Node scheduleNode = nodes.item(0);
                schedule = getSchedule(scheduleNode);
            }
        }
        return schedule;
    }

    public static Plan getSchedule(Node scheduleNode) {
        Plan schedule = null;
        if (scheduleNode.getNodeName().equals("schedule")) {
            Plan.ScheduleBuilder scheduleBuilder = new Plan.ScheduleBuilder();
            for (int i = 0; i < scheduleNode.getChildNodes().getLength(); i++) {
                Node child = scheduleNode.getChildNodes().item(i);
                if (child.getNodeName().equals("date")) {
                    scheduleBuilder.setDate(child.getChildNodes().item(0).getNodeValue());
                } else if (child.getNodeName().equals("time")) {
                    scheduleBuilder.setTime(child.getChildNodes().item(0).getNodeValue());
                } else if (child.getNodeName().equals("request")) {
                    NodeList tripChildren = child.getChildNodes();
                    for (int j = 0; j < tripChildren.getLength(); j++) {
                        Node tripNode = tripChildren.item(j);
                        if (tripNode.getNodeName().equals("trip")) {
                            scheduleBuilder.addTrip(getTrip(tripNode));
                        }
                    }

                }
            }
            schedule = scheduleBuilder.build();
        }
        return schedule;
    }

    public static Trip getTrip(Node tripNode) {
        Trip trip = null;
        if (tripNode.getNodeName().equals("trip")) {
            NamedNodeMap tripNodeMap = tripNode.getAttributes();
            Trip.TripBuilder tripBuilder = new Trip.TripBuilder()
                    .setOrigin(tripNodeMap.getNamedItem("origin").getNodeValue())
                    .setDestination(tripNodeMap.getNamedItem("destination").getNodeValue())
                    .setOrigTimeMin(tripNodeMap.getNamedItem("origTimeMin").getNodeValue())
                    .setOrigTimeDate(tripNodeMap.getNamedItem("origTimeDate").getNodeValue());
            for (int i = 0; i < tripNode.getChildNodes().getLength(); i++) {
                tripBuilder.addL(getLat(tripNode.getChildNodes().item(i)));
            }
            trip = tripBuilder.build();
        }
        return trip;
    }

    public static Last getLat(Node lnode) {
        Last leg = null;
        if (lnode.getNodeName().equals("leg")) {
            NamedNodeMap NodeMap = lnode.getAttributes();
            leg = new Last.Builder()
                    .setTransferCode(NodeMap.getNamedItem("transfercode").getNodeValue())
                    .setOrigTimeMin(NodeMap.getNamedItem("origTimeMin").getNodeValue())
                    .setLine(NodeMap.getNamedItem("line").getNodeValue())
                    .build();
        }
        return leg;
    }

}
