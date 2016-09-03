package xyz.antsgroup.demo.utils.tools.ted;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface Downloader<T> {
    List<T> downCaptions(String id, String lang) throws IOException;
}
