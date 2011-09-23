package bookmarkcrawler.parser.common;

import bookmarkcrawler.model.FetchedDocument;
import bookmarkcrawler.model.ProcessedDocument;

/**
 * Interface for parsing document that was retrieved/fetched during
 * collection phase.  
 */
public interface DocumentParser {
    public ProcessedDocument parse(FetchedDocument doc) 
        throws DocumentParserException;
}
