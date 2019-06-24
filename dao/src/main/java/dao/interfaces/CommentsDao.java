package dao.interfaces;

import entity.Apartment;
import entity.Comments;

import java.util.List;

public interface CommentsDao {
    List<Comments> getComments(Long id);

    void addComment(Comments comments);
}
