package sampleProject.article.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Article {

    private Integer articleId;

    @NotEmpty(message = "필수 입력")
    @Size(min = 1, max = 200, message = "제목의 길이가 너무 깁니다")
    private String articleTitle;

    @NotEmpty(message = "필수 입력")
    @Size(min = 1)
    private String articleContent;

    private String articleWriter;
    private String articleInsertDate;
    private String articleDeleteDate;
    private Integer articleHit;
    private String articleCategory;
    private String articleTag;
    private String articleWriterName;
    private Integer totalCount;
    private Integer rowNumber;

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getArticleWriterName() {
        return articleWriterName;
    }

    public void setArticleWriterName(String articleWriterName) {
        this.articleWriterName = articleWriterName;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = "[" + articleTag + "] ";
    }

    public Article(Integer articleId) {
        super();
        this.articleId = articleId;
    }

    public Article() {
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleWriter() {
        return articleWriter;
    }

    public void setArticleWriter(String articleWriter) {
        this.articleWriter = articleWriter;
    }

    public String getArticleInsertDate() {
        return articleInsertDate;
    }

    public void setArticleInsertDate(String articleInsertDate) {
        this.articleInsertDate = articleInsertDate;
    }

    public String getArticleDeleteDate() {
        return articleDeleteDate;
    }

    public void setArticleDeleteDate(String articleDeleteDate) {
        this.articleDeleteDate = articleDeleteDate;
    }

    public Integer getArticleHit() {
        return articleHit;
    }

    public void setArticleHit(Integer articleHit) {
        this.articleHit = articleHit;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

}
