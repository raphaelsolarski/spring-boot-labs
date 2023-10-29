package com.example.springbootlabs.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByText(String text);

    List<Comment> findByCommentType(CommentType commentType);

    Optional<Comment> findByUuID(UUID uuID);

    List<Comment> findByTextAndCommentType(String text, CommentType commentType);

    Long countByCommentType(CommentType commentType);

    List<Comment> findByTextContaining(String text);
    List<Comment> findTop5ByCommentTypeOrderById(CommentType commentType);
    List<Comment> findByCommentTypeIsNull();
    Long countByTextContainingAndCommentType(String text, CommentType commentType);
    @Query("SELECT DISTINCT c.commentType FROM Comment c WHERE c.text LIKE %:text%")
    Set<CommentType> findDistinctCommentTypesByTextContaining(String text);
}
























