package com.cxd.service;

import com.cxd.po.Comment;

import java.util.List;

/**
 * Created by cxd on 2020/10/22.
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
