package at.woli.xml;

import java.util.ArrayList;

/**
 * <p>
 * <code>XMLData</code> to store all elements and attributes of an XML Object.
 * </p>
 *
 * @author <a href="mailto:wolfgang.n@woli.at">Wolfgang Nitzlnader </a>
 * @version 0.5.1
 */

public class XMLData {

    /** Removes all elements, which were find in the List  <br>NOT IMPLEMENTED YET*/
    public final static int REMOVE_ALL = 0;

    /** Removes the first element from the list  <br>NOT IMPLEMENTED YET*/
    public final static int REMOVE_FIRST = 1;

    /** Removes the last element from the list   <br>NOT IMPLEMENTED YET */
    public final static int REMOVE_LAST = 2;

    /** The name of the root element */
    private String rootElementName;

    /** Stores all elements of the object */
    private ArrayList <XMLDataElement> dataArray;

    /** Actual element which is in use */
    private XMLDataElement xmlElement;


    /**
     * Standard constructor all variables are initialized with 0
     */
    public XMLData() {
        this.dataArray = new ArrayList<XMLDataElement>();
        this.rootElementName = "root";

    }

    /**
     * Constructor which sets the name of the root element with the given parameter
     *
     * @param rootElementName
     *            The Name of the root element
     */
    public XMLData(String rootElementName) {
        this.dataArray = new ArrayList<XMLDataElement>();
        this.rootElementName = rootElementName;
    }

    /**
     * Constructor which creates a new Element with the given parameters
     *
     * @param rootElementName
     *            The Name of the root element
     *
     * @param elementName
     *              The Name of the element
     *
     * @param elementValue
     *              The Value of the element
     */
    public XMLData(String rootElementName, String elementName, Object elementValue) {
        this.dataArray = new ArrayList<XMLDataElement>();

        this.rootElementName = rootElementName;
        this.xmlElement = new XMLDataElement(elementName, elementValue);

        this.dataArray.add(this.xmlElement);
    }


    
    /**
     * Returns the list of elements
     *
     * @return the list of elements
     *
     */
    public ArrayList<XMLDataElement> getDataArray() {
        return dataArray;
    }


    /** Sets the list of elements in this class
     *
     * @param dataArray
     *          The list of elements
     */
    public void setDataArray(ArrayList<XMLDataElement> dataArray) {
        this.dataArray = dataArray;
    }


    /**
     * Returns the actual element which is in use
     *
     * @return the actual element
     *
     */
    public XMLDataElement getXmlElement() {
        return xmlElement;
    }


    /**
     * Setd the actual element of the class.<br><br>
     * <strong>ATTENTION!!!!! This function do not add the element to the list of elements in the class.</strong> <br>
     *
     * If you want to add an element of type XMLElement to the list of elements, please use the function <code>addElementToArray()</code>
     *
     * @see XMLData#addElementToArray(XMLDataElement)
     *
     * @param xmlElement
     *          An element of the type XMLElement
     *
     */
    public void setXmlElement(XMLDataElement xmlElement) {
        this.xmlElement = xmlElement;
    }


    /**
     * Returns the name of the root element
     *
     * @return the name of the root element
     *
     */
    public String getRootElementName() {
        return rootElementName;
    }


    /**
     * Returns the first element from the list of elements
     *
     * @return the frist element
     *
     * @see XMLData#getElementAtIndex(int)
     * @see at.woli.xml.XMLData#getLastElement()
     * @see XMLData#getElementByName(String)
     *
     */
    public XMLDataElement getFirstElement() {
        return this.dataArray.get(0);
    }


    /**
     * Returns the last element from the list of elements
     *
     * @return the last element
     *
     * @see XMLData#getElementAtIndex(int)
     * @see at.woli.xml.XMLData#getFirstElement()
     * @see XMLData#getElementByName(String)
     *
     */
    public XMLDataElement getLastElement() {
        return this.dataArray.get(this.dataArray.size());
    }

    /**
     * Returns an element from the list of elements at the given index
     *
     * @return the an element from the given index
     *
     * @see at.woli.xml.XMLData#getFirstElement()
     * @see at.woli.xml.XMLData#getLastElement()
     * @see XMLData#getElementByName(String)
     *
     */
    public XMLDataElement getElementAtIndex(int index) {
        return this.dataArray.get(index);
    }

    /**
     * Returns an element from the list of elements by the given name
     *
     * @param name
     *          The name of the element
     *
     * @return the an element from the given name or null, if no element was found
     *
     * @see at.woli.xml.XMLData#getFirstElement()
     * @see at.woli.xml.XMLData#getLastElement()
     * @see XMLData#getElementAtIndex(int)
     *
     */
    public XMLDataElement getElementByName(String name) {

        for (int  x = 0; x < this.dataArray.size(); x++)
        {
            if (this.dataArray.get(x).getElementName().compareTo(name) == 0) {
                return this.dataArray.get(x);
            }
        }

        return null;
        
    }

    /**
     * Returns the number of elements from the list of elements
     *
     * @return the numbers elements
     *
     */
    public int getNumbersOfElements() {
        return this.dataArray.size();
    }


    /** Sets the name of the root element
     *
     * @param rootElementName
     *          The name of the root element
     */
    public void setRootElementName(String rootElementName) {
        this.rootElementName = rootElementName;
    }

    /** Removes an element at the given index
     *
     * @param index
     *          The index of an element, which will be removed
     */
    public void removeElementFromArrayByIndex(int index) {
        this.dataArray.remove(index);
    }

    /** Removes an element with the given name
     *
     * @param name
     *          The name of an element, which will be removed
     * @param type
     *          This is just a placeholder for features in later releases
     */
    //TODO Modify this Methodes to Delete the First or the Last Element
    public void removeElementFromArrayByName(String name, int type) {

        for (int x = 0; x < this.dataArray.size(); x++)
        {
            if (name.compareTo(this.dataArray.get(x).getElementName()) == 0) {
                this.dataArray.remove(x);
            }
        }
    }

    /** Removes an element with the given value
     *
     * @param value
     *          The value of an element, which will be removed
     * @param type
     *          This is just a placeholder for features in later releases
     */
    public void removeElementFromArrayByValue(String value, int type) {
        for (int x = 0; x < this.dataArray.size(); x++)
        {
            if (value.compareTo(this.dataArray.get(x).getElementValue().toString()) == 0) {
                this.dataArray.remove(x);
            }
        }

    }

    /** Adds an element of type XMLDataElement to the list of elements
     *
     * @param xmlElement
     *          The element which will be add to the list of elements
     */
    public void addElementToArray(XMLDataElement xmlElement) {
        this.dataArray.add(xmlElement);
    }


    /** Adds a new element to the list of elements
     *
     * @param elementName
     *          The name of the new element
     * @param elementValue
     *          The value of the new element
     */
    public void addNewElementToArray(String elementName, Object elementValue) {
        this.xmlElement = new XMLDataElement(elementName, elementValue);
        dataArray.add(this.xmlElement);
    }

    /** Adds a new attribute to the last element in the list
     *
     * @param attributeName
     *          The name of the new attribute
     * @param attributeValue
     *          The value of the new attribute
     */
    public void addNewAttributeToLastElement(String attributeName, String attributeValue) {
        this.dataArray.get(this.dataArray.size()-1).addAttribute(attributeName, attributeValue);
    }

    //TODO Add two Methods to add attributes to a special element (name or value)

}
