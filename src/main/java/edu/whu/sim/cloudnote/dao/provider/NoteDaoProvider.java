package edu.whu.sim.cloudnote.dao.provider;

import edu.whu.sim.cloudnote.entity.NoteListRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class NoteDaoProvider {

    public String getNoteList(NoteListRequest request){
        SQL sql = new SQL(){
            {
                SELECT("id", "title", "update_time as updateTime");
                FROM("note");
                WHERE(String.format("author_id = %s", request.getAuthorId()));
                ORDER_BY("update_time DESC");
                if(!StringUtils.isEmpty(request.getKeyword())){
                    WHERE(String.format("(title like '%%%s%%' OR content like '%%%s%%')", request.getKeyword(), request.getKeyword()));
                }
            }
        };
        return sql.toString();
    }
}
