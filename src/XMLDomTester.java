import at.woli.xml.XMLFileReader;
import at.woli.xml.XMLData;
import at.woli.xml.XMLFileWriter;
import org.junit.Test;

/**
 * <p>
 * This Class is for testing the WSXMLPackage.
 * </p>
 *
 * @author <a href="mailto:wolfgang.n@woli.at">Wolfgang Nitzlnader </a>
 * @version 0.5.1
 */

public class XMLDomTester {

	@Test
    public void writeXML() {
        XMLData myData = new XMLData("testfile", "name", "Wolfgang");
        myData.addNewElementToArray("nachname", "nachname");
        myData.addNewAttributeToLastElement("index", "1");
        myData.addNewAttributeToLastElement("index2", "2");
        myData.addNewElementToArray("adresse", "musterstrasse");
        myData.addNewAttributeToLastElement("index", "1");

        XMLFileWriter myWriter = new XMLFileWriter(myData, "testfiles/testfile.xml");
        myWriter.saveDataToFile();
    }
	
    @Test
    public void readXML() {

        String elementName;
        String elementValue;
        String outputString;


        XMLFileReader xmlReader = new XMLFileReader("testfiles/testfile.xml");
        XMLData myData = xmlReader.readAndParseXMLFile();

        System.out.println("<" + myData.getRootElementName() + ">");
        for (int x = 0; x < myData.getNumbersOfElements(); x++) {

            elementName = myData.getElementAtIndex(x).getElementName();
            elementValue = myData.getElementAtIndex(x).getElementValue().toString();


            outputString = "\t<" + elementName;

            for (int y = 0; y < myData.getElementAtIndex(x).getNumberOfAttributes(); y++) {
                outputString += " " + myData.getElementAtIndex(x).getAttributeByIndex(y).getAttributeName() + "='"
                        + myData.getElementAtIndex(x).getAttributeByIndex(y).getAttributeValue() + "'";
            }

            outputString += ">" + elementValue + "</" + elementName + ">";
            System.out.println(outputString);
        }
        System.out.println("</" + myData.getRootElementName() + ">");

    }
}