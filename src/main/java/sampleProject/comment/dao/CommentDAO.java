package sampleProject.comment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import sampleProject.comment.domain.Comment;
import sampleProject.common.dao.AbstractDAO;

@Repository("commentDAO")
public class CommentDAO extends AbstractDAO {

    public Integer insertComment(Comment comment) throws Exception {
        return (Integer) insert("comment.insertComment", comment);
    }
    
    @SuppressWarnings("unchecked")
    public List<Comment> selectComments(Integer articleId)throws Exception{
        return selectList("comment.selectComments", articleId);
    }
}
