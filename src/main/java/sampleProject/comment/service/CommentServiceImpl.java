package sampleProject.comment.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import sampleProject.comment.dao.CommentDAO;
import sampleProject.comment.vo.Comment;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource
    private CommentDAO commentDAO;

    @Override
    public Boolean setComment(Comment comment) throws Exception {
        if (commentDAO.insertComment(comment) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> getComments(Integer articleId) throws Exception {
        return commentDAO.selectComments(articleId);
    }
}
