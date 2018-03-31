package services;

import mappers.StoryMapper;
import models.Genre;
import models.Story;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.util.List;

public class StoryService  {

    public List<Story> getStoriesByUser(String userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            StoryMapper blogMapper = sqlSession.getMapper(StoryMapper.class);
            return blogMapper.getStoriesByUser(userId);
        }finally{
            sqlSession.close();
        }
    }

    public List<Genre> getGenres() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            StoryMapper blogMapper = sqlSession.getMapper(StoryMapper.class);
            return blogMapper.getGenres();
        }finally{
            sqlSession.close();
        }
    }

    public int updateStory(String userId, String storyId, Story story) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            StoryMapper blogMapper = sqlSession.getMapper(StoryMapper.class);
            int row = blogMapper.updateStory(userId, storyId, story);
            sqlSession.commit();
            return row;
        }finally{
            sqlSession.close();
        }
    }



}
