package xyz.antsgroup.demo.utils.tools.ted;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * TED 演讲字幕文字下载
 */
public class TedCaptionDownloader implements Downloader<Caption> {

    private static final String ted = "https://www.ted.com/talks/subtitles/id/";

    public static class CaptionWrapper {
        private List<Caption> captions;

        public List<Caption> getCaptions() {
            return captions;
        }

        public void setCaptions(List<Caption> captions) {
            this.captions = captions;
        }
    }

    @Override
    public List<Caption> downCaptions(String id, String lang) throws IOException {

        CaptionWrapper captionWrapper = new CaptionWrapper();
        String url = ted + id + "/lang/" + lang;
        URLConnection conn = new URL(url).openConnection();
        conn.setConnectTimeout(5000);
        try (InputStream inputStream = conn.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            captionWrapper = mapper.readValue(inputStream, CaptionWrapper.class);
        }
        return captionWrapper.getCaptions();
    }

    public static void main(String[] args) throws IOException {
        Downloader<Caption> downloader = new TedCaptionDownloader();
        String tedID = "1733";

        List<Caption> enCaptions = downloader.downCaptions(tedID, Language.EN);
        List<Caption> zhCaptions = downloader.downCaptions(tedID, Language.ZH);

        FileWriter enWriter = new FileWriter(tedID + "-en.txt");
        for (Caption c : enCaptions) {
            enWriter.write(c.getContent());
            enWriter.write("\n");
        }
        FileWriter zhWriter = new FileWriter(tedID + "-zh.txt");
        for (Caption c : zhCaptions) {
            zhWriter.write(c.getContent());
            zhWriter.write("\n");
        }
        enWriter.close();
        zhWriter.close();

        FileWriter writer = new FileWriter(tedID + "-mix.txt");
        String tmp;
        for (int i = 0, j = 0, enSize = enCaptions.size(), zhSize = zhCaptions.size();
             i < enSize || j < zhSize; ) {
            while (i < enSize) {
                tmp = enCaptions.get(i++).getContent();
                writer.write(tmp);
                if (tmp.contains(".") || tmp.contains("?")) {
                    writer.write("\n\n");
                    break;
                }
            }
            while (j < zhSize) {
                tmp = zhCaptions.get(j++).getContent();
                writer.write(tmp);
                if (tmp.contains("。") || tmp.contains("？")) {
                    writer.write("\n\n");
                    break;
                }
            }
        }
        writer.close();
    }
}
