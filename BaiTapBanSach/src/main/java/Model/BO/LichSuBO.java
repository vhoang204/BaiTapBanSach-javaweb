package Model.BO;

import java.util.ArrayList;
import Model.Bean.LichSuBean;
import Model.DAO.LichSuDAO;

public class LichSuBO {
    LichSuDAO lsDao = new LichSuDAO();

    public ArrayList<LichSuBean> getLichSu(long makh) throws Exception {
        return lsDao.getLichSu(makh);
    }
}