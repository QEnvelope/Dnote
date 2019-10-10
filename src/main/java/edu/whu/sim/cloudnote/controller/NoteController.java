package edu.whu.sim.cloudnote.controller;

import edu.whu.sim.cloudnote.entity.NoteListRequest;
import edu.whu.sim.cloudnote.service.NoteService;
import edu.whu.sim.cloudnote.entity.BaseResponse;
import edu.whu.sim.cloudnote.util.UserUtils;
import edu.whu.sim.cloudnote.vo.NoteListVO;
import edu.whu.sim.cloudnote.vo.NoteVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}/")
    public ModelAndView getNoteDetail(@PathVariable("id") Integer id, Model model){
        NoteVO vo = noteService.getNoteDetail(id);
        model.addAttribute("noteDetail", vo);
        return new ModelAndView("green/note_detail");
    }

    @GetMapping("/notes/")
    public ModelAndView getNoteList(@RequestParam(name = "keyword", required = false) String keyword, Model model){
        NoteListRequest request = new NoteListRequest();
        request.setAuthorId(UserUtils.getCurrentUser().getId());
        if (!StringUtils.isEmpty(keyword)) {
            request.setKeyword(keyword);
        }
        List<NoteListVO> noteList = noteService.getNoteList(request);
        model.addAttribute("noteList", noteList);
        if (!noteList.isEmpty()) {
            model.addAttribute("hasNote", true);
            model.addAttribute("topNoteId", noteList.get(0).getId());
        }
        return new ModelAndView("green/notelist");
    }

    @PostMapping("/create/")
    public ResponseEntity<BaseResponse> addNote(@RequestBody NoteVO vo, HttpServletRequest request) {
        Integer id = noteService.addNote(vo);
        return ResponseEntity.ok().body(BaseResponse.successResponse(id));
//        return id;
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<BaseResponse> deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().body(BaseResponse.successResponse());
    }

//    @PutMapping("/{id}/")
//    public ResponseEntity<BaseResponse> updateNode(@PathVariable("id") Integer id, @RequestBody NoteVO vo){
//        noteService.updateNote(id, vo);
//        return ResponseEntity.ok().body(BaseResponse.successResponse());
//    }

    @GetMapping("/write")
    public ModelAndView newNote(){
        return new ModelAndView("green/write");
    }
}
