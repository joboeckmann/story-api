package services;

import mappers.ChapterMapper;
import models.Chapter;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtil;

import java.util.List;

public class ChapterService {

    public List<Chapter> getChapters(String userId, int storyId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            ChapterMapper blogMapper = sqlSession.getMapper(ChapterMapper.class);
            return blogMapper.getChapters(userId, storyId);
        }finally{
            sqlSession.close();
        }
    }



}
