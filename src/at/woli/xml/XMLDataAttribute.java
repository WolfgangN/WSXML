package at.woli.xml;

/**
 * <p>
 * <code>XMLDataAttribute</code> to store an Attribute of an element. This class is used by XMLDataElement.
 * </p>
 *
 * @author <a href="mailto:wolfgang.n@woli.at">Wolfgang Nitzlnader </a>
 * @version 1.0.0
 */

public class XMLDataAttribute {

    /** Name of the XMLDataAttribute */
    private String attributeName;

    /** Value of the XMLDataAttribute */
    private String attributeValue;


    /**
     * Standard constructor all variables are initialized with 0.
     */
    public XMLDataAttribute() {
        this.attributeName = "";
        this.attributeValue = "";
    }

    /**
     * @param attributeName
     *            The Name of the new attribute
     * @param attributeValue
     *            The Value of the new attribute
     */
    public XMLDataAttribute(String attributeName, String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }



    /**
     * Returns the name of the attribute
     *
     * @return the name of the attribute
     *
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Sets the name of the attribute
     *
     * @param attributeName the new name of the attribute
     *
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * Returns the value of the attribute
     *
     *  @return the value of the attribute
     *
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * Sets the value of the attribute.
     *
     * @param attributeValue the new value of the attribute
     *
     */
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
