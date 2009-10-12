package at.woli.xml;

import java.util.ArrayList;

/**
 * <p>
 * <code>XMLDataElement</code> to store an Element of the XML-File. This class is used by XMLData.
 * </p>
 *
 * @author <a href="mailto:wolfgang.n@woli.at">Wolfgang Nitzlnader </a>
 * @version 1.0.0
 */

public class XMLDataElement {

    /** Name of the XMLDataElement */
    private String elementName;

    /** Value of the XMLDataElement */
    private Object elementValue;

    /** ArrayList of all attributes of the Element */
    private ArrayList<XMLDataAttribute> elementAttributes;



    /**
     * Standard constructor all variables are initialized with 0
     */
    public XMLDataElement() {
        this.elementName = "";
        this.elementValue = "";
        this.elementAttributes = new ArrayList<XMLDataAttribute>();
    }

    /**
     * @param elementName
     *            The Name of the new element
     * @param elementValue
     *            The Value of the new element
     */
    public XMLDataElement(String elementName, Object elementValue) {
        this.elementName = elementName;
        this.elementValue = elementValue;
        this.elementAttributes = new ArrayList<XMLDataAttribute>();
    }



    
    /**
     * Returns the name of the element
     *
     * @return the name of the element
     *
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * Sets the name of the element
     *
     * @param elementName the new name of the element
     *
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    /**
     * Returns the value of the element
     *
     * @return the value of the element
     *
     */
    public Object getElementValue() {
        return elementValue;
    }

    /**
     * Sets the value of the element
     *
     * @param elementValue the new value of the element
     *
     */
    public void setElementValue(Object elementValue) {
        this.elementValue = elementValue;
    }

    /**
     * Returns an Arraylist with all attributes
     *
     * @return the list of the attributes
     *
     */
    public ArrayList<XMLDataAttribute> getElementAttributes() {
        return elementAttributes;
    }

    /**
     * Sets the new ArrayList of the attributes
     *
     * @param elementAttributes the new list of attributes of the element
     *
     */
    public void setElementAttributes(ArrayList<XMLDataAttribute> elementAttributes) {
        this.elementAttributes = elementAttributes;
    }

    /**
     * Returns the number of attributes, stored in the Arraylist
     *
     * @return the number of the attributes
     *
     */
    public int getNumberOfAttributes() {
        return this.elementAttributes.size();
    }

    /**
     * Returns an attribute at a given index
     *
     * @return the attribute at the given index
     *
     */
    public XMLDataAttribute getAttributeByIndex(int index) {
        return this.elementAttributes.get(index);
    }

    /**
     * Add a new attribute for the elment.
     *
     * @param attributeName the name of the attribute
     *
     * @param attributeValue the value of the attribute
     *
     */
    public void addAttribute(String attributeName, String attributeValue) {
        XMLDataAttribute newAttribute = new XMLDataAttribute(attributeName, attributeValue);
        this.elementAttributes.add(newAttribute);
    }

    /**
     * Removes an attribute at the given index.
     */
    public void removeAttributeByIndex(int index) {
        this.elementAttributes.remove(index);
    }
}
