package sampleProject.comment.domain;

public class Comment {
    private Integer commentId;
    private String commentWriter;
    private String commentContent;
    private String commentInsertDate;
    private String commentDeleteDate;
    private Integer commentParentsId;
    private String commentWriterName;
    private Integer articleId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentInsertDate() {
        return commentInsertDate;
    }

    public void setCommentInsertDate(String commentInsertDate) {
        this.commentInsertDate = commentInsertDate;
    }

    public String getCommentDeleteDate() {
        return commentDeleteDate;
    }

    public void setCommentDeleteDate(String commentDeleteDate) {
        this.commentDeleteDate = commentDeleteDate;
    }

    public Integer getCommentParentsId() {
        return commentParentsId;
    }

    public void setCommentParentsId(Integer commentParentsId) {
        this.commentParentsId = commentParentsId;
    }

    public String getCommentWriterName() {
        return commentWriterName;
    }

    public void setCommentWriterName(String commentWriterName) {
        this.commentWriterName = commentWriterName;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

}
