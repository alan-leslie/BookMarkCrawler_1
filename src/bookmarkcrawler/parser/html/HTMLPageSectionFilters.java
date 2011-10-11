package bookmarkcrawler.parser.html;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.traversal.NodeFilter;

/**
 *
 * @author al
 */
public class HTMLPageSectionFilters {
    private Map<String, SectionFilter> bodyFilters = new HashMap<String, SectionFilter>();
    private Map<String, SectionFilter> linkFilters = new HashMap<String, SectionFilter>();
    
    SectionFilter getBodyFilter(String key){
        SectionFilter bodyFilter = bodyFilters.get(key);
        return bodyFilter;
    }
    
    SectionFilter getLinkFilter(String key){
        SectionFilter linkFilter = linkFilters.get(key);
        return linkFilter;
    } 
    
    private HTMLPageSectionFilters() {       
        initBodyFilter();
        initLinkFilter();
    }
    
    public static HTMLPageSectionFilters getInstance() {
        return HTMLPageSectionFiltersHolder.INSTANCE;
    }
    
    private static class HTMLPageSectionFiltersHolder {
        private static final HTMLPageSectionFilters INSTANCE = new HTMLPageSectionFilters();
    }
    
    private void initBodyFilter() {
        FileReader theReader = null;

        try {
            theReader = new FileReader("body_filter.txt");
            BufferedReader in = new BufferedReader(theReader);
            
            String theLine = null;
            
            while ((theLine = in.readLine()) != null) {
                String theLineArr[] = theLine.split(",");
                
                if(theLineArr.length > 4){
                    SectionFilter theBodyFilter = null;
                    String theHost = theLineArr[0];
                    String theSection = theLineArr[1].trim();                    
                    String theAttribute = theLineArr[2].trim();
                    String theValue = theLineArr[3].trim();
                    short filterType = theLineArr[4].equalsIgnoreCase("S") ? NodeFilter.FILTER_SKIP : NodeFilter.FILTER_ACCEPT;

                    if(bodyFilters.containsKey(theHost)){
                        theBodyFilter = bodyFilters.get(theHost);                    
                    } else {
                        theBodyFilter = new SectionFilter();        
                    }
                    
                    SectionFilterSpec theSectionFilter = new SectionFilterSpec(theSection, theAttribute, theValue, filterType);
                    
                    if(filterType == NodeFilter.FILTER_SKIP){
                        theBodyFilter.addSkip(theSectionFilter);                       
                    } else {
                        theBodyFilter.addAccept(theSectionFilter);                        
                    }
                    
                    bodyFilters.put(theHost, theBodyFilter);  
                }
            }

        } catch (IOException e) {
            // ...
        } finally {
            if (null != theReader) {
                try {
                    theReader.close();
                } catch (IOException e) {
                    /* .... */
                }
            }
        }
    }
    
    private void initLinkFilter() { 
        FileReader theReader = null;

        try {
            theReader = new FileReader("link_filter.txt");
            BufferedReader in = new BufferedReader(theReader);
            
            String theLine = null;
            
            while ((theLine = in.readLine()) != null) {
                String theLineArr[] = theLine.split(",");
                
                if(theLineArr.length > 4){
                    SectionFilter theLinkFilter = null;
                    String theHost = theLineArr[0];
                    String theSection = theLineArr[1].trim();                    
                    String theAttribute = theLineArr[2].trim();
                    String theValue = theLineArr[3].trim();
                    short filterType = theLineArr[4].equalsIgnoreCase("S") ? NodeFilter.FILTER_SKIP : NodeFilter.FILTER_ACCEPT;

                    if(linkFilters.containsKey(theHost)){
                        theLinkFilter = linkFilters.get(theHost);                    
                    } else {
                        theLinkFilter = new SectionFilter();        
                    }
                    
                    SectionFilterSpec theSectionFilter = new SectionFilterSpec(theSection, theAttribute, theValue, filterType);
                    
                    if(filterType == NodeFilter.FILTER_SKIP){
                        theLinkFilter.addSkip(theSectionFilter);                       
                    } else {
                        theLinkFilter.addAccept(theSectionFilter);                        
                    }
                                        
                    linkFilters.put(theHost, theLinkFilter);  
                }
            }
        } catch (IOException e) {
            // ...
        } finally {
            if (null != theReader) {
                try {
                    theReader.close();
                } catch (IOException e) {
                    /* .... */
                }
            }
        }
    }
    
    public static void main(String[] args) {
        HTMLPageSectionFilters theFilters = HTMLPageSectionFilters.getInstance();
    }
}
