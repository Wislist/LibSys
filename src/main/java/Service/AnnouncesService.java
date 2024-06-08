package Service;

import Pojo.Announces;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Auther: oyy0v0
 * @Date: 2024/6/7 - 06 - 07 - 19:08
 * @Description: Service
 * @version: 1.0
 */
public interface AnnouncesService {
    ArrayList<Announces> selectAnnounce(Announces announces);

    void addAnnounce(Announces announces);
    void deleteAnnounce(Date date);
}
