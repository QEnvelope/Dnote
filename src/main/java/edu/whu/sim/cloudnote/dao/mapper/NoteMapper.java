package edu.whu.sim.cloudnote.dao.mapper;

import edu.whu.sim.cloudnote.dao.Note;
import edu.whu.sim.cloudnote.dao.provider.NoteDaoProvider;
import edu.whu.sim.cloudnote.entity.NoteListRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface NoteMapper {

    @SelectProvider(type= NoteDaoProvider.class, method = "getNoteList")
//    @Select("SELECT id, title, update_time as updateTime FROM note WHERE author_id = #{authorId} ORDER BY update_time DESC")
    List<Note> getNoteList(NoteListRequest request);

    @Select("SELECT id, title, author_id as authorId, create_time as createTime, update_time as updateTime, content from note WHERE id=#{id}")
    Note getNoteDetail(Integer id);

    @Insert("INSERT INTO note (title, author_id, create_time, update_time, content)" +
            " VALUES (#{title}, #{authorId}, #{createTime}, #{updateTime}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addNote(Note note);

    @Delete("DELETE FROM note WHERE id=#{id}")
    void deleteNote(Integer id);

    @Update("UPDATE note SET title=#{title}, update_time=#{updateTime}, content=#{content} WHERE id=#{id}")
    int updateNote(Note note);
}
