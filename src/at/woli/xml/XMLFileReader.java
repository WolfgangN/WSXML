package at.woli.xml;

import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Attribute;


import java.util.Iterator;

/**
 * <p>
 * <code>XMLFileReader</code> reads a XML file and pare it into an XMlData object.
 * </p>
 *
 * @author <a href="mailto:wolfgang.n@woli.at">Wolfgang Nitzlnader </a>
 * @version 1.0.0
 */

public class XMLFileReader {

    /** XMLData Object which stores all elements and attributes */
    private XMLData xmlFileData;
    /** Path of the XML file */
    private String  xmlFilePath;

    private SAXReader reader;
    private Document document;

    /**
     * Standard constructor all variables are initialized with 0
     */
    public XMLFileReader() {
        this.xmlFileData = new XMLData();
        this.xmlFilePath = "";
    }

    /** Constructor which initialize a new XMLData Object and sets the xmlFilePath with the given parameter
     *
     * @param xmlFilePath
     *              The path of the XML file which will be read and parse by the class
     */
    public XMLFileReader(String xmlFilePath) {
        this.xmlFileData = new XMLData();
        this.xmlFilePath = xmlFilePath;
    }


    /** Returns a XMLData Object which stores all elements and attributes
     *
     * @return the list of elements
     */
    public XMLData getXmlFileData() {
        return xmlFileData;
    }

    /** Sets the given paramante as the actual XMLData object
     *
     * @param xmlFileData
     *              A XMlData Object which store all elements and attributes
     */
    public void setXmlFileData(XMLData xmlFileData) {
        this.xmlFileData = xmlFileData;
    }

    /** Returns the actual Path, where the XML file will be saved
     *
     * @return the actual Path of the XML file
     */
    public String getXmlFilePath() {
        return xmlFilePath;
    }

    /** Stets the path for the XML file
     *
     * @param xmlFilePath
     *              Path of the XML file
     */
    public void setXmlFilePath(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }


    /** Reads the XML file
     *
     */
    public void readXMLFile() {
        reader = new SAXReader();
        document = null;

        try {
            document = reader.read(this.xmlFilePath);
        } catch (DocumentException e) {
            System.out.println("Something went wrong while reading the XMLFile at " + this.xmlFilePath);
        }
    }

    /** Reads the XML file and uses the file at the given parameter
     *
     * @param xmlFilePath
     *              Path of the XML file
     */
    public void readXMLFile(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
        this.readXMLFile();
    }


    /** Parse the XML file and stores all elements and attributes in a XMLData object<br><br>
     * <strong>Befor you can parse an XML file, you have read the XML file </strong>
     *
     * @return A list of all elements and attributes
     *
     * @see XMLFileReader#readXMLFile()
     * @see XMLFileReader#readXMLFile(String)  
     * @see XMLFileReader#readAndParseXMLFile(String)
     * @see XMLFileReader#readAndParseXMLFile()
     */
    public XMLData parseXMlFile() {

        Element root = document.getRootElement();
        this.xmlFileData.setRootElementName(root.getName());
        // iterate through child elements of root
        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            this.xmlFileData.addNewElementToArray(element.getName(), element.getText());

            for ( Iterator j = element.attributeIterator(); j.hasNext(); ) {
            Attribute attribute = (Attribute) j.next();
            this.xmlFileData.addNewAttributeToLastElement(attribute.getName(), attribute.getValue());
            }


        }

        return this.xmlFileData;
    }

    /** Read a parse a XML file
     *
     * @return a list of all elements and attributes
     */
    public XMLData readAndParseXMLFile() {

        this.readXMLFile();
        this.parseXMlFile();

        return this.xmlFileData;
    }

    /** Read and parse a XML file at the given path
     *
     * @param xmlFilePath
     *              Path of the XMl file
     * @return a list of all elements and attributes
     */
    public XMLData readAndParseXMLFile(String xmlFilePath) {

        this.readXMLFile(xmlFilePath);
        this.parseXMlFile();

        return this.xmlFileData;
    }
}
