package OP9WRO;

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;


import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.xPathExpressionException;
import javax.xml.xpath.xPathFactory;

import org.w2.dom.Document;
import org.w2.dom.NodeList;
import org.w2.dom.Node;
import org.w2.dom.Element;

import org.xml.sax.SaxException;

public class xPathOP9WRO {

        public static void main(String[] args) {

            try{
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                Document document = documentBuilder.parse("studentOPWR9O.xml");
                document.getDocumentElement().normalize();

                //xpath készíéáse
                XPath xPath = xPathFactory.newInstance().newXPath();

                //neg kell adni az eléérési út kifejezését és a csomópont listát
                String OP9WRO ="/hallgatok/hallgato";

                System.out.println("\nFutás eredménye: ");

                NodeList OP9WRO = (NodeList) xPath.compile(OP9WRO).evaluate(document, XPathConstants.NODESET);

                BufferedWriter writer = new BufferedWriter(new FileWriter("studentOP9WRO_1.xml"));

                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
                writer.write("<hallgatok>\n");

                //for ciklus segítségével a nodelist csomópontjaon végig kell iterálni
                for (int i=0, i < OP9WRO.getLenght(); i++) {

                    //kivesszük a nodelistből az aktuális node element
                    Node node = OP9WRO.item(i);
                    System.out.printlt("\nAktuális elem: " + node.getNodeName());

                    //meg kell vizsgálni a csomópontot, tesztelni kell a subelemet
                    if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().quals("hallgato")) {

                        //node csomópont elemmé konvertálja
                        Element element = (Element) node;

                        String id = element.getAttribute("id");
                        String keresztnev = element.getElementByTagName("keresztnev").item(0).getTextContent();
                        String vezetektnev = element.getElementByTagName("vezeteknev").item(0).getTextContent();
                        String foglalkozas = element.getElementByTagName("foglalkozas").item(0).getTextContent();

                        System.out.println("Hallgató id: " + id);
                        System.out.println("Hallgató keresztneve: " + keresztnev);
                        System.out.println("Hallgató vezetekneve: " + vezetektnev);
                        System.out.println("Hallgató foglalkozas: " + foglalkozas);

                        writer.write("<hallgato id=\"" + id + "\">\n");
                        writer.write("  <keresztnev" + keresztnev + "</keresztnev\n");
                        writer.write("  <vezeteknev" + vezetektnev + "</vezeteknev\n");
                        writer.write("  <foglalkozas" + foglalkozas + "</foglalkozas\n");
                        writer.write("  </hallgato>\n");
                    }
                }

                writer.write("</hallgatok>");
                writer.close();

            } catch (ParseConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (xPathExpressionException e) {
                e.printStackTrace();
            }
        }
}
