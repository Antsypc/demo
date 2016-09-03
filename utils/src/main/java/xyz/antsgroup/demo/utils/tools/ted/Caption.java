package xyz.antsgroup.demo.utils.tools.ted;

/**
 * 单条字幕
 */
public class Caption {
    private Integer duration;
    private String content;
    private Boolean startOfParagraph;
    private Integer startTime;

    public Caption() {
    }

    public Caption(Integer duration, String content, Boolean startOfParagraph, Integer startTime) {
        this.duration = duration;
        this.content = content;
        this.startOfParagraph = startOfParagraph;
        this.startTime = startTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStartOfParagraph() {
        return startOfParagraph;
    }

    public void setStartOfParagraph(Boolean startOfParagraph) {
        this.startOfParagraph = startOfParagraph;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "duration=" + duration +
                ", content='" + content + '\'' +
                ", startOfParagraph=" + startOfParagraph +
                ", startTime=" + startTime +
                '}';
    }
}
