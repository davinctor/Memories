package com.memories.dto;

import java.util.List;

public class MemoryVO {

    private Long id;
    private String text;
    private Long moodId;
    private String moodDescription;
    private List<String> picturesUrls;

    public MemoryVO(Long id, String text, Long moodId, String moodDescr, List<String> urls) {
        this.id = id;
        this.text = text;
        this.moodId = moodId;
        this.moodDescription = moodDescr;
        this.picturesUrls = urls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMoodId() {
        return moodId;
    }

    public void setMoodId(Long moodId) {
        this.moodId = moodId;
    }

    public String getMoodDescription() {
        return moodDescription;
    }

    public void setMoodDescription(String moodDescription) {
        this.moodDescription = moodDescription;
    }

    public List<String> getPictureUrls() {
        return picturesUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.picturesUrls = pictureUrls;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: " + id + "\n");
        builder.append("text: " + text + "\n");
        builder.append("moodId: " + moodId + "\n");
        builder.append("moodDescr: " + moodDescription + "\n");
        builder.append("picturesUrls: ");
       for (String str : picturesUrls)
            builder.append(str);
        return  builder.toString();
    }
}
