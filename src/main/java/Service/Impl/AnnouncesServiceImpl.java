package Service.Impl;

import Mapper.AnnounceMapper;
import Pojo.Announces;
import Service.AnnouncesService;
import Views.callboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Auther: oyy0v0
 * @Date: 2024/6/7 - 06 - 07 - 23:52
 * @Description: Service.Impl
 * @version: 1.0
 */
public class AnnouncesServiceImpl implements AnnouncesService {
    private AnnounceMapper announceMapper;
    private callboard view;

    @Override
    public ArrayList<Announces> selectAnnounce(Announces announces) {
        return null;
    }

    @Override
    public void addAnnounce(Announces announces) {
        String noticeContent = view.getContent();
        String noticeCreateTime = view.getCreateTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(noticeCreateTime);
            announces.setTime(date);
            announces.setAnnText(noticeContent);
            announceMapper.insert(announces);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAnnounce(Date date) {
        return ;
    }
}
