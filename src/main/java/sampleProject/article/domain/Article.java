package sampleProject.article.domain;

public class Article {

    private Integer articleId;
    private String articleTitle;
    private String articleContent;
    private String articleWriter;
    private String articlePassword;
    private String articleInsertDate;
    private String articleDeleteDate;
    private Integer articleHit;
    private String articleCategory;

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

    public String getArticlePassword() {
        return articlePassword;
    }

    public void setArticlePassword(String articlePassword) {
        this.articlePassword = articlePassword;
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
