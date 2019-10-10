package edu.whu.sim.cloudnote.service;

import com.google.common.collect.Lists;
import edu.whu.sim.cloudnote.dao.Note;
import edu.whu.sim.cloudnote.dao.User;
import edu.whu.sim.cloudnote.dao.mapper.NoteMapper;
import edu.whu.sim.cloudnote.dao.mapper.UserMapper;
import edu.whu.sim.cloudnote.entity.NoteListRequest;
import edu.whu.sim.cloudnote.util.TimeUtils;
import edu.whu.sim.cloudnote.util.UserUtils;
import edu.whu.sim.cloudnote.vo.NoteListVO;
import edu.whu.sim.cloudnote.vo.NoteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 获得笔记列表
     * 支持关键词查询
     * @return
     */
    public List<NoteListVO> getNoteList(NoteListRequest request){
        List<NoteListVO> vo = Lists.newArrayList();
        List<Note> noteList = noteMapper.getNoteList(request);
        vo = noteList.stream().map(n -> buildNoteList(n)).collect(Collectors.toList());
        return vo;
    }

    /**
     * 获得笔记内容详情
     * @return
     */
    public NoteVO getNoteDetail(Integer noteId){
        NoteVO vo = new NoteVO();
        Note note = noteMapper.getNoteDetail(noteId);
        BeanUtils.copyProperties(note, vo);
        vo.setAuthorName(userMapper.getNameById(note.getAuthorId()));
        vo.setCreateTime(TimeUtils.formatDate(note.getCreateTime()));
        vo.setUpdateTime(TimeUtils.formatDate(note.getUpdateTime()));
        return vo;
    }

    /**
     * 新增笔记
     */
    public Integer addNote(NoteVO vo){
        Note note = new Note();
        BeanUtils.copyProperties(vo, note);
        note.setAuthorId(UserUtils.getCurrentUser().getId());
        note.setCreateTime(new Date());
        note.setUpdateTime(new Date());
        noteMapper.addNote(note);
        return note.getId();
    }

    /**
     * 更新笔记
     * @param vo
     * @return
     */
    public int updateNote(Integer id, NoteVO vo){
        Note note = new Note();
        BeanUtils.copyProperties(vo, note);
        note.setId(id);
        note.setUpdateTime(new Date());
        return noteMapper.updateNote(note);
    }

    /**
     * 删除笔记
     * @param id
     */
    public void deleteNote(Integer id){
        noteMapper.deleteNote(id);
    }

    /**
     * 构建notelist展示
     * @return
     */
    private NoteListVO buildNoteList(Note note){
        NoteListVO vo = new NoteListVO();
        BeanUtils.copyProperties(note, vo);
        vo.setUpdateTime(TimeUtils.formatDate(note.getUpdateTime()));
        return vo;
    }
}
