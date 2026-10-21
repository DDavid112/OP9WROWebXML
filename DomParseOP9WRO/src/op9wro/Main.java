
package op9wro;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class DomReadOP9WRO {
        public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
        {
                File xmlFile = new File("C:\\Users\\au094985\\Documents\\DomParseOP9WRO\\src\\OP9WRO_XML.xml");

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                //a docbuilder a ducbuilderfactory típusú objektum new docbuilder metódusa hozza létre
                DocumentBuilder dBuilder = factory.newDocumentBuilder();

                //a parse() metódus elemzi és beölti xml filet
                Document doc = dBuilder.parse(xmlFile);

                //a dokumentum normalizálása segít a helyes eredmények elérésében
                doc.getDocumentElement().normalize();

                //kiíratjuk a dokumentum gyökérelemét
                System.out.println("Gyökér elem: " + doc.getDocumentElement().getNodeName());

                //a getelementsbytagname
                NodeList nlist = doc.getElementsByTagName("etterem");

                //végigmegyünk rajta egy ciklussal
                for (int i = 0; i < nlist.getLength(); i++)
                {
                        //lekérjük a lista aktuális elemét
                        Node nNode = nlist.item(i);

                        System.out.println("\nAktuális elem: " + nNode.getNodeName());

                        if(nNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                                Element elem = (Element) nNode;

                                String id = elem.getAttribute("ekod");

                                Node node1 = elem.getElementsByTagName("nev").item(0);
                                String name = node1.getTextContent();

                                Node node2 = elem.getElementsByTagName("varos").item(0);
                                String city = node2.getTextContent();

                                Node node3 = elem.getElementsByTagName("utca").item(0);
                                String street = node3.getTextContent();

                                Node node4 = elem.getElementsByTagName("hazszam").item(0);
                                String number = node4.getTextContent();

                                Node node5 = elem.getElementsByTagName("csillag").item(0);
                                String stars = node5.getTextContent();

                                String adr = city + ", " + street + " utca " + number + ".";

                                System.out.println("Étterem ID: " + id);
                                System.out.println("Név: " + name);
                                System.out.println("Cím: " + adr);
                                System.out.println("CSillag: " + stars);


                        }
                }

                NodeList nList2 = doc.getElementsByTagName("foszakacs");

                for (int i = 0; i < nList2.getLength(); i++)
                {
                        //lekérjük a lista aktuális elemét
                        Node nNode2 = nList2.item(i);

                        System.out.println("\nAktuális elem: " + nNode2.getNodeName());

                        if(nNode2.getNodeType() == Node.ELEMENT_NODE)
                        {
                                Element elem = (Element) nNode2;

                                String fkod = elem.getAttribute("fkod");
                                String eid = elem.getAttribute("e_f");

                                String work  = "Ez a főszakács a(z) " + eid + "azonosítójú étteremben dolgozik";


                                Node node1 = elem.getElementsByTagName("nev").item(0);
                                String name = node1.getTextContent();

                                Node node2 = elem.getElementsByTagName("eletkor").item(0);
                                String age = node2.getTextContent();

                                Node node3;
                                String edu ="";

                                for(int j=0; j<elem.getElementsByTagName("vegzettseg").getLength();j++) {
                                        node3 = elem.getElementsByTagName("vegzettseg").item(j);
                                    if (j == elem.getElementsByTagName("vegzettseg").getLength()-1) {
                                            edu += node3.getTextContent();
                                    } else {
                                            edu += node3.getTextContent() + ", ";
                                    }
                                }


                                System.out.println("Főszakács ID: " + fkod);
                                System.out.println("Név: " + name);
                                System.out.println("Életkor: " + age);
                                System.out.println("Tanulmányok: " + edu);

                        }
                }



                NodeList nList3 = doc.getElementsByTagName("szakacs");

                for (int i = 0; i < nList3.getLength(); i++)
                {
                        //lekérjük a lista aktuális elemét
                        Node nNode3 = nList3.item(i);

                        System.out.println("\nAktuális elem: " + nNode3.getNodeName());

                        if(nNode3.getNodeType() == Node.ELEMENT_NODE)
                        {
                                Element elem = (Element) nNode3;

                                String szkod = elem.getAttribute("szkod");
                                String eid = elem.getAttribute("e_sz");

                                String work  = "Ez a szakács a(z) " + eid + "azonosítójú étteremben dolgozik";

                                Node node1 = elem.getElementsByTagName("nev").item(0);
                                String name = node1.getTextContent();

                                Node node2 = elem.getElementsByTagName("reszleg").item(0);
                                String section = node2.getTextContent();

                                Node node3;
                                String edu ="";

                                for(int j=0; j<elem.getElementsByTagName("vegzettseg").getLength();j++) {
                                        node3 = elem.getElementsByTagName("vegzettseg").item(j);
                                        if (j == elem.getElementsByTagName("vegzettseg").getLength()-1) {
                                                edu += node3.getTextContent();
                                        } else {
                                                edu += node3.getTextContent() + ", ";
                                        }
                                }


                                System.out.println("Szakács ID: " + szkod);
                                System.out.println("Név: " + name);
                                System.out.println("Részleg: " + section);
                                System.out.println("Tanulmányok: " + edu);

                        }
                }


                NodeList nList4 = doc.getElementsByTagName("gyakornok");

                for (int i = 0; i < nList4.getLength(); i++)
                {
                        //lekérjük a lista aktuális elemét
                        Node nNode4 = nList4.item(i);

                        System.out.println("\nAktuális elem: " + nNode4.getNodeName());

                        if(nNode4.getNodeType() == Node.ELEMENT_NODE)
                        {
                                Element elem = (Element) nNode4;

                                String gykod = elem.getAttribute("gykod");
                                String eid = elem.getAttribute("e_gy");

                                String work  = "Ez a gyakornok a(z) " + eid + "azonosítójú étteremben dolgozik";

                                Node node1 = elem.getElementsByTagName("nev").item(0);
                                String name = node1.getTextContent();

                                Node node2 = elem.getElementsByTagName("muszak").item(0);
                                String muszak = node2.getTextContent();

                                Node node3 = elem.getElementsByTagName("gyakorlat").item(0);
                                String gyak = "";





                                System.out.println("Gyakornok ID: " + gykod);
                                System.out.println("Név: " + name);
                                System.out.println("Műszak: " + muszak);
                                System.out.println("Gyakorlat: " + gyak);

                        }
                }

        }


}

