
package team.project.cooldown.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import team.project.cooldown.model.ItemAttach;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ItemUtils {
    Logger logger = LogManager.getLogger(ItemUtils.class);
    @Value("${saveItemImgDir}") private String saveItemImgDir;
    public ItemAttach itemImgUpload(MultipartFile attach){
        ItemAttach ia= new ItemAttach();
            ia.setFname(mkUUID()+attach.getOriginalFilename());

            ia.setFsize(attach.getSize()/1024+"");
            String saveImgPath = saveItemImgDir+ia.getFname();
            try {
                attach.transferTo(new File(saveImgPath));
            } catch (IOException e) {
                logger.error("첨부파일 처리중 오류발생");
                e.printStackTrace();
            }
        return ia;
    }

    private String mkUUID() {
        String uuid= LocalDate.now()+""+ LocalTime.now();
        uuid = uuid.replace("-","").replace(":","").replace(".","");
        return uuid;
    }

}

