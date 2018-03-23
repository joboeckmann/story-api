package mappers;

import models.Genre;
import models.Story;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoryMapper {

    @Select("SELECT * FROM STORY WHERE USER_ID = #{userId}")
    @Results({
            @Result(id = true, property = "userId", column = "user_id"),
            @Result(id = true, property = "genreId", column = "genre_id"),
            @Result(id = true, property = "numChapters", column = "num_chapters"),
            @Result(id = true, property = "fileLocation", column = "file_location"),

    })

    public List<Story> getStoriesByUser(String userId);

    @Select("Select * from genre")
    public List<Genre> getGenres();

}
