package models;

import java.util.Date;

public class Story {

    private long id;
    private String title;
    private String description;
    private String fileLocation;
    private Long genreId;
    private String triggerWarnings;
    private String userId;
    private Date dateUploaded;
    private int numChapters;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getTriggerWarnings() {
        return triggerWarnings;
    }

    public void setTriggerWarnings(String triggerWarnings) {
        this.triggerWarnings = triggerWarnings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public int getNumChapters() {
        return numChapters;
    }

    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
