package at.woli.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 * <code>XMLFileWriter</code> writes all elements of an given list to a file.
 * </p>
 *
 * @author <a href="mailto:wolfgang.n@woli.at">Wolfgang Nitzlnader </a>
 * @version 1.0.0
 */

public class XMLFileWriter {

    /** XMLData Object which stores all elements and attributes */
    private XMLData xmlFileData;

    /** Path of the XML file */
    private String xmlFilePath;

    /**
     * Standard constructor all variables are initialized with 0
     */
    public XMLFileWriter() {
        this.xmlFileData = new XMLData();
        this.xmlFilePath = "";
    }

    /** Constructor which sets the XMLData Object with the given paramenter and the xmlFilePath is set to 0
     *
     * @param xmlFileData
     *          The XMLData Object which stores all elements and attributes
     */
    public XMLFileWriter(XMLData xmlFileData) {
        this.xmlFileData = xmlFileData;
        this.xmlFilePath = "";
    }

    /** Constructor which setes the XMLData and the xmlFilePath object with the given parameter
     *
     * @param xmlFileData
     *          The XMLData Object which stores all elements and attributes
     * @param xmlFilePath
     *          The path for the XML-File
     */
    public XMLFileWriter(XMLData xmlFileData, String xmlFilePath) {
        this.xmlFileData = xmlFileData;
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


    /**
     * Save the given XMlData object as XMLFile at the given Path
     */
    public void saveDataToFile() {

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement(this.xmlFileData.getRootElementName());


        for (int i = 0; i < this.xmlFileData.getNumbersOfElements(); i++)
        {
            Element xmlElement = root.addElement(this.xmlFileData.getElementAtIndex(i).getElementName()).addText(this.xmlFileData.getElementAtIndex(i).getElementValue().toString());

            if (this.xmlFileData.getElementAtIndex(i).getNumberOfAttributes() > 0) {

                for (int x = 0; x < this.xmlFileData.getElementAtIndex(i).getNumberOfAttributes(); x++)
                {
                    xmlElement.addAttribute(this.xmlFileData.getElementAtIndex(i).getAttributeByIndex(x).getAttributeName(), this.xmlFileData.getElementAtIndex(i).getAttributeByIndex(x).getAttributeValue());
                }
            }

        }

        try {
             XMLWriter writer = new XMLWriter(new FileWriter(this.xmlFilePath));
             writer.write( document );
             writer.close();

        } catch (IOException e) {
            System.out.println("Something went wrong while writing the XMLFile at " + this.xmlFilePath);
        }
    }
}
