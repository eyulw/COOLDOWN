package team.project.cooldown.mybatis;

import org.apache.ibatis.annotations.Mapper;
import team.project.cooldown.model.Board;
import team.project.cooldown.model.BoardAttach;
import team.project.cooldown.model.BoardComments;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    int insertBoard(Board b);

    int updateViewBoard(String board_id);

    Board selectOneBoard(String board_id);

    List<Board> selectBoard(int stnum);

    int selectCountBoard();

    int insertBoardAttach(BoardAttach ba);

    int lastBoardBoard_id();

    List<Board> selectFindBoard(Map<String, Object> params);

    int countFindBoard(Map<String, Object> params);

    int insertnobdattach(int board_id);

    List<Board> selectFindcBoard(String category);

    List<BoardComments> selectBoardComment(String board_id);

    int insertBoardComment(BoardComments bc);

    int insertBoardReply(BoardComments bc);

}