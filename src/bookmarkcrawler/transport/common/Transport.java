package bookmarkcrawler.transport.common;

import bookmarkcrawler.model.FetchedDocument;

public interface Transport {
    public FetchedDocument fetch(String url) throws TransportException;
    public void init();
    public void clear();
    public boolean pauseRequired();
}
