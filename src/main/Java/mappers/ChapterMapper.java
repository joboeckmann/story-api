package mappers;

import models.Chapter;
import models.Story;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChapterMapper {

    @Select("SELECT * FROM CHAPTER WHERE USER_ID = #{userId} AND STORY_ID = #{storyId} ORDER BY ORDER_NUM")
    @Results({
            @Result(id=true, property="userId", column="user_id"),
            @Result(id=true, property="fileLocation", column="file_location"),
            @Result(id=true, property="storyId", column="story_id"),
            @Result(id=true, property="orderNum", column="order_num")
    })
    public List<Chapter> getChapters(@Param("userId")String userId, @Param("storyId") int storyId);



}
