package com.example.slepnev.tinkoff.model.dto;

/**
 * Created by slepnev on 13.03.16.
 */
public class NewsContentDTO {

    private NewsDTO title;

    private DateDTO creationDate;

    private DateDTO lastModificationDate;

    private String content;

    private Integer bankInfoTypeId;

    private String typeId;

    /**
     *
     * @return
     * The title
     */
    public NewsDTO getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(NewsDTO title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The creationDate
     */
    public DateDTO getCreationDate() {
        return creationDate;
    }

    /**
     *
     * @param creationDate
     * The creationDate
     */
    public void setCreationDate(DateDTO creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     * @return
     * The lastModificationDate
     */
    public DateDTO getLastModificationDate() {
        return lastModificationDate;
    }

    /**
     *
     * @param lastModificationDate
     * The lastModificationDate
     */
    public void setLastModificationDate(DateDTO lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    /**
     *
     * @return
     * The content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @return
     * The bankInfoTypeId
     */
    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    /**
     *
     * @param bankInfoTypeId
     * The bankInfoTypeId
     */
    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    /**
     *
     * @return
     * The typeId
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     *
     * @param typeId
     * The typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "NewsContentDTO{" +
                "title=" + title +
                ", creationDate=" + creationDate +
                ", lastModificationDate=" + lastModificationDate +
                ", content='" + content + '\'' +
                ", bankInfoTypeId=" + bankInfoTypeId +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
