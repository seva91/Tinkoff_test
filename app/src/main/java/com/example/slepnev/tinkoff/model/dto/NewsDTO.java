package com.example.slepnev.tinkoff.model.dto;

/**
 * Created by slepnev on 12.03.16.
 */
public class NewsDTO {

    private int id;

    private String name;

    private String text;

    private DateDTO publicationDate;

    private int bankInfoTypeId;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPublicationDate(DateDTO publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setBankInfoTypeId(int bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public DateDTO getPublicationDate() {
        return publicationDate;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", publicationDate=" + publicationDate +
                ", bankInfoTypeId=" + bankInfoTypeId +
                '}';
    }
}
