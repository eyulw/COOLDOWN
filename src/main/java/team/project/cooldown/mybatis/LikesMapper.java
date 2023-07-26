package team.project.cooldown.mybatis;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikesMapper {


    void insertLikes(String u_id, Integer item_id);


    void updateLikesCount_i( Integer item_id);


    void deleteLikes(String u_id, Integer item_id);


    void updateLikesCount_d(Integer item_id);

    int selectLikesCount(String u_id, Integer item_id);

    int LikesItemCount(Integer item_id);
}
