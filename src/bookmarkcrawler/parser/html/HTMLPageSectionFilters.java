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
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("h1", "class", "title", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        theSkipSection = new SectionFilterSpec("span", "class", "story-storytype", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addSkip(theSkipSection);
        theAcceptSection = new SectionFilterSpec("p", "class", "story-summary", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "class", "story-body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);

        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("h1", "class", "title", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        // this causes recursion
//        theSkipSection = new SectionFilterSpec("span", "class", "story-storytype", NodeFilter.FILTER_ACCEPT);
//        theLinkFilter.addSkip(theSkipSection);
        theAcceptSection = new SectionFilterSpec("p", "class", "story-summary", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "class", "story-body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);        
        theAcceptSection = new SectionFilterSpec("div", "id", "related-links", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "id", "searchbyline", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.linuxinsider.com", theBodyFilter, theLinkFilter);
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-body entry-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-body entry-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.javacodegeeks.com", theBodyFilter, theLinkFilter);
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("google-latlong.blogspot.com", theBodyFilter, theLinkFilter);    
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "body-copy", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "body-copy", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("techcrunch.com", theBodyFilter, theLinkFilter);      
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "storycontent", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "storycontent", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("seleniumhq.wordpress.com", theBodyFilter, theLinkFilter);   
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "adBox", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "adBox", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.gamasutra.com", theBodyFilter, theLinkFilter); 
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "section", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "section", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("openmymind.net", theBodyFilter, theLinkFilter); 
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id",  "bodyContent", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "bodyContent", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("en.wikipedia.org", theBodyFilter, theLinkFilter);  
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "postItem", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "postItem", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("zoomzum.com", theBodyFilter, theLinkFilter);     
              
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id",  "content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.time.com", theBodyFilter, theLinkFilter);      
                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "plain", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "plain", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "class", "relatedItems", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("oyc.yale.edu", theBodyFilter, theLinkFilter);      
                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "Superfish-wrap", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "Superfish-wrapn", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("reference.sitepoint.com", theBodyFilter, theLinkFilter);  
                             
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "id",  "content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "id", "content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("developer.mozilla.org", theBodyFilter, theLinkFilter);      
                             
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id",  "mainContent", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "mainContent", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.onlinecolleges.org", theBodyFilter, theLinkFilter); 
                             
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "entry entry-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry entry-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.technicallydigital.com", theBodyFilter, theLinkFilter); 
                             
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "entry", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("smashinghub.com", theBodyFilter, theLinkFilter); 
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "post", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.cyberlinks.in", theBodyFilter, theLinkFilter);   
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "postitem", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "postitem", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("webtablab.com", theBodyFilter, theLinkFilter);   
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "article-single", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "article-single", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "id", "related-posts", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("designmodo.com", theBodyFilter, theLinkFilter);  
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "id",  "main-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        theSkipSection = new SectionFilterSpec("div", "id",  "comments", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addSkip(theSkipSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "id", "main-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.catswhocode.com", theBodyFilter, theLinkFilter);  
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "class",  "entry-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "class", "entry-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("technologytosoftware.com", theBodyFilter, theLinkFilter);  
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "class",  "entry", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("skytechgeek.com", theBodyFilter, theLinkFilter);  
                                     
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "class",  "entry", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("section", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("skytechgeek.com", theBodyFilter, theLinkFilter);  
                                             
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "entry_content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry_content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("appole.org", theBodyFilter, theLinkFilter); 
        
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "yom-mod yom-art-hd", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "class",  "yom-mod yom-art-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "yom-mod yom-art-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("games.yahoo.com", theBodyFilter, theLinkFilter); 
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "prcontent", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id",  "prcontent", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.smashingmagazine.com", theBodyFilter, theLinkFilter);       
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class",  "content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.webdeveloperjuice.com", theBodyFilter, theLinkFilter);       
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "contentadcontainer", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id",  "contentadcontainer", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.noupe.com", theBodyFilter, theLinkFilter);       
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("blueblots.com", theBodyFilter, theLinkFilter);    
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "prcontent", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "prcontent", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("coding.smashingmagazine.com", theBodyFilter, theLinkFilter);    
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("stefancameron.com", theBodyFilter, theLinkFilter);    
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "dd_post_share", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "dd_post_share", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("creativedesignmagazine.com", theBodyFilter, theLinkFilter); 
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "blog-body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "blog-body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("blog.wolfire.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "asset-body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "asset-body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.allthingsdistributed.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "title", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        theAcceptSection = new SectionFilterSpec("div", "class", "post", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.good.is", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "container", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "container", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("christopheviau.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.netmagazine.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "MainColumn", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "MainColumn", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("msdn.microsoft.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("freewebdesignresources.net", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "post-content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.getrichslowly.org", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-content article", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-content article", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.script-tutorials.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.engineyard.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "textcontent", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "textcontent", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.purevpn.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry-body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("gothamist.com", theBodyFilter, theLinkFilter);        
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "content", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "id", "content", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.emergingedtech.com", theBodyFilter, theLinkFilter);    
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "article", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "article", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("scottchacon.com", theBodyFilter, theLinkFilter);    
 
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "entry", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("www.red-team-design.com", theBodyFilter, theLinkFilter);    
  
        theBodyFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "body", NodeFilter.FILTER_ACCEPT);
        theBodyFilter.addAccept(theAcceptSection);
        
        theLinkFilter = new SectionFilter();
        theAcceptSection = new SectionFilterSpec("div", "class", "body", NodeFilter.FILTER_ACCEPT);
        theLinkFilter.addAccept(theAcceptSection);
        
        addFilter("highscalability.com", theBodyFilter, theLinkFilter);    
    }
    
    public static HTMLPageSectionFilters getInstance() {
        return HTMLPageSectionFiltersHolder.INSTANCE;
    }
    
    private static class HTMLPageSectionFiltersHolder {
        private static final HTMLPageSectionFilters INSTANCE = new HTMLPageSectionFilters();
    }
}
