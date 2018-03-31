package mappers;

import models.Genre;
import models.Story;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StoryMapper {

    @Select("SELECT * FROM STORY WHERE USER_ID = #{userId}")
    @Results({
            @Result(id = true, property = "userId", column = "user_id"),
            @Result(id = true, property = "genreId", column = "genre_id"),
            @Result(id = true, property = "numChapters", column = "num_chapters"),
            @Result(id = true, property = "triggerWarnings", column = "triggers_warning"),
            @Result(id = true, property = "fileLocation", column = "file_location"),

    })

    public List<Story> getStoriesByUser(String userId);

    @Select("Select * from genre")
    public List<Genre> getGenres();

    @Update("Update story set title = #{story.title}," +
            " description = #{story.description}, " +
            "file_location = #{story.fileLocation}, " +
            "length = #{story.length}, " +
            "genre_id = #{story.genreId}, " +
            "triggers_warning = #{story.triggerWarnings}, " +
            "num_chapters = #{story.numChapters} " +
            "where user_id = #{userId} " +
            "and id = #{storyId}")
    public int updateStory(@Param("userId") String userId, @Param("storyId") String storyId, @Param("story") Story story);

}
