package sampleProject.board.domain;

public class Article {

    private Integer article_id;
    private String article_title;
    private String article_content;
    private String article_writer;
    private String article_password;
    private String article_insert_date;
    private String article_delete_date;
    private Integer article_hit;
    private String article_category;

    public String getArticle_category() {
        return article_category;
    }

    public void setArticle_category(String article_category) {
        this.article_category = article_category;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public String getArticle_writer() {
        return article_writer;
    }

    public void setArticle_writer(String article_writer) {
        this.article_writer = article_writer;
    }

    public String getArticle_password() {
        return article_password;
    }

    public void setArticle_password(String article_password) {
        this.article_password = article_password;
    }

    public String getArticle_insert_date() {
        return article_insert_date;
    }

    public void setArticle_insert_date(String article_insert_date) {
        this.article_insert_date = article_insert_date;
    }

    public String getArticle_delete_date() {
        return article_delete_date;
    }

    public void setArticle_delete_date(String article_delete_date) {
        this.article_delete_date = article_delete_date;
    }

    public Integer getArticle_hit() {
        return article_hit;
    }

    public void setArticle_hit(Integer article_hit) {
        this.article_hit = article_hit;
    }
}
