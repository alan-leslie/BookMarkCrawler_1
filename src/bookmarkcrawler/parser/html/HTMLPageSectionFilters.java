package bookmarkcrawler.parser.html;

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
    
     final void addFilter(String key, 
             SectionFilter bodyFilter,
             SectionFilter linkFilter){
         if(bodyFilter != null){
             if(!bodyFilters.containsKey(key)){
                 bodyFilters.put(key, bodyFilter);
             }  
         }
  
         if(linkFilter != null){
             if(!linkFilters.containsKey(key)){
                 linkFilters.put(key, linkFilter);
             }
         }
    }
     
    SectionFilter getBodyFilter(String key){
        SectionFilter bodyFilter = bodyFilters.get(key);
        return bodyFilter;
    }
    
    SectionFilter getLinkFilter(String key){
        SectionFilter linkFilter = linkFilters.get(key);
        return linkFilter;
    } 
    
    private HTMLPageSectionFilters() {
        SectionFilter theBodyFilter = new SectionFilter();
        SectionFilterSpec theAcceptSection = new SectionFilterSpec("div", "class", "story-body", NodeFilter.FILTER_ACCEPT);
        SectionFilterSpec theSkipSection = new SectionFilterSpec("div", "class", "share-help", NodeFilter.FILTER_SKIP);
        theBodyFilter.addAccept(theAcceptSection);
        theBodyFilter.addSkip(theSkipSection);

        SectionFilter theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "story-body", NodeFilter.FILTER_ACCEPT);
        theSkipSection = new SectionFilterSpec("div", "class", "share-help", NodeFilter.FILTER_SKIP);
        SectionFilterSpec theRelatedLinkSection = new SectionFilterSpec("div", "class", "related-internet-links", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theLinkFilter.addAccept(theRelatedLinkSection);
        theLinkFilter.addSkip(theSkipSection);
        
        addFilter("BBC", theBodyFilter, theLinkFilter);
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "main-article-info", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "id", "content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "main-article-info", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "id", "content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "id", "manual-trailblock", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "class", "related-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
         
        addFilter("Guardian", theBodyFilter, theLinkFilter);
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);

        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("ul", "class", "related", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("Lifehacker", theBodyFilter, theLinkFilter);
    }
    
    public static HTMLPageSectionFilters getInstance() {
        return HTMLPageSectionFiltersHolder.INSTANCE;
    }
    
    private static class HTMLPageSectionFiltersHolder {
        private static final HTMLPageSectionFilters INSTANCE = new HTMLPageSectionFilters();
    }
}
