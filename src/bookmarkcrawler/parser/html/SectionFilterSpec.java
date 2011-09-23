
package bookmarkcrawler.parser.html;

/**
 *
 * @author al
 */
public class SectionFilterSpec {

    private final String tagName;
    private final String attribName;
    private final String attribValue;
    private final short filterAction;

    public SectionFilterSpec(String tagName,
            String attribName,
            String attribValue,
            short filterAction) {
        this.tagName = tagName;
        this.attribName = attribName;
        this.attribValue = attribValue;
        this.filterAction = filterAction;
    }

    String getTagName() {
        return tagName;
    }

    String getAttribName() {
        return attribName;
    }

    String getAttribValue() {
        return attribValue;
    }
    
   short getFilterAction() {
        return filterAction;
    }
}
