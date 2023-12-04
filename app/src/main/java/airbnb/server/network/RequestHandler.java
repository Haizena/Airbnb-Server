package airbnb.server.network;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;

import airbnb.server.persistence.MyBatisConnection;
import airbnb.server.persistence.DAO.*;
import airbnb.server.persistence.DTO.*;
import airbnb.server.persistence.request.*;

public class RequestHandler {
    private static SqlSessionFactory sqlSessionFactory;
    private static ConvenienceDAO convDAO;
    private static DiscountDAO discDAO;
    private static HouseDAO houseDAO;
    private static PayMentDAO paymDAO;
    private static ReservationDAO resvDAO;
    private static ReviewDAO revDAO;
    private static UserDAO usrDAO;
    private static TotalSalesDAO tosDAO;

    static
    {
        sqlSessionFactory = MyBatisConnection.getSqlSessionFactory();
        convDAO = new ConvenienceDAO(sqlSessionFactory);
        discDAO = new DiscountDAO(sqlSessionFactory);
        houseDAO = new HouseDAO(sqlSessionFactory);
        paymDAO = new PayMentDAO(sqlSessionFactory);
        resvDAO = new ReservationDAO(sqlSessionFactory);
        revDAO = new ReviewDAO(sqlSessionFactory);
        usrDAO = new UserDAO(sqlSessionFactory);
        tosDAO = new TotalSalesDAO(sqlSessionFactory);
    }

    public synchronized static Object convenienceControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                return convDAO.selectConvenience((int) request.getRequestObject());
            case 0x02:
                return convDAO.insertHouseConve((HouseConveDTO) request.getRequestObject());
            case 0x03:
                return convDAO.maxHouseConve();
            case 0x04:
                return convDAO.insertAccessConve((AccessibilityConvesDTO) request.getRequestObject());
            case 0x05:
                return convDAO.maxAccess();
            case 0x06:
                return convDAO.insertBasicConve((BasicConveDTO) request.getRequestObject());
            case 0x07:
                return convDAO.maxBasic();
            case 0x08:
                return convDAO.insertManySerchConve((ManySearchConveDTO) request.getRequestObject());
            case 0x09:
                return convDAO.maxManySearch();
            case 0x0A:
                return convDAO.insertSafetyConve((SafetyConveDTO) request.getRequestObject());
            case 0x0B:
                return convDAO.maxSafety();
            default :
                return null;
        }
    }

    public synchronized static Object discountControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                return discDAO.selectDiscount((int) request.getRequestObject());
            case 0x02:
                return discDAO.insertAmountDiscount((AmountDiscountDTO) request.getRequestObject());
            case 0x03:
                return discDAO.insertRateDiscount((RateDiscountDTO) request.getRequestObject());
            case 0x04:
                return discDAO.selectDiscountByReservation_no((int) request.getRequestObject());
            default :
                return null;
        }
    }

    public synchronized static Object houseControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                return houseDAO.selectApprovedAll((int) request.getRequestObject());
            case 0x02:
                return houseDAO.selectApprovedAll((HashMap<String, Object>) request.getRequestObject());
            case 0x03:
                return houseDAO.selectApprovedAll();
            case 0x04:
                return houseDAO.selectHoustDTO((int) request.getRequestObject());
            case 0x05:
                return houseDAO.selectUnApprovedAll();
            case 0x06:
                return houseDAO.ApproveHouse((int) request.getRequestObject());
            case 0x07:
                return houseDAO.insertHouse((HouseDTO) request.getRequestObject());
            case 0x08:
                ArrayList<Object> arr = (ArrayList<Object>) request.getRequestObject();

                return houseDAO.insertHouse((IndividualRoomDTO) arr.get(0), (HouseDTO) arr.get(1));
            case 0x09:
                return houseDAO.maxHouseNo();
            case 0x0A:
                return houseDAO.selectAllOrderByPaymentASC();
            case 0x0B:
                return houseDAO.selectAllOrderByPaymentDESC();
            case 0x0C:
                return houseDAO.allPayment((int) request.getRequestObject());
            case 0x0D:
                return houseDAO.allDiscountInfo((int) request.getRequestObject());
            case 0x0E:
                return houseDAO.selectJoinedHouse((int) request.getRequestObject());
            default :
                return null;
        }
    }
    
    public synchronized static Object paymentControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                return paymDAO.selectPayMent((int) request.getRequestObject());
            case 0x02:
                return paymDAO.insertPayMent((PayMentDTO) request.getRequestObject());
            case 0x03:
                return paymDAO.selectPayMentByReservation_no((int) request.getRequestObject());
            default :
                return null;
        }
    }

    public synchronized static Object reservationControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                return resvDAO.insertReservation((ReservationDTO) request.getRequestObject());
            case 0x02:
                return resvDAO.recentlyAddedReservationNo();
            case 0x03:
                return resvDAO.reviewed((int) request.getRequestObject());
            case 0x04:
                return resvDAO.approved((int) request.getRequestObject());
            case 0x05:
                resvDAO.checkOuted((int) request.getRequestObject());

                return null;
            case 0x06:
                resvDAO.unCheckOuted((int) request.getRequestObject());

                return null;
            case 0x07:
                return resvDAO.selectHost((int) request.getRequestObject());
            case 0x08:
                return resvDAO.selectGuest((int) request.getRequestObject());
            case 0x09:
                return resvDAO.selectApprovedGuest((int) request.getRequestObject());
            case 0x0A:
                return resvDAO.selectUnReviewedCheckOut((int) request.getRequestObject());
            case 0x0B:
                return resvDAO.allApprovedList();
            case 0x0C:
                return resvDAO.allApprovedList((int) (long) request.getRequestObject());
            case 0x0D:
                return resvDAO.dateList((int) request.getRequestObject());
            case 0x0E:
                return resvDAO.hostAllInfo((int) request.getRequestObject());
            case 0x0F:
                resvDAO.deleteReservation((int) request.getRequestObject());
                return null;
            case 0x10:
                return resvDAO.hostAllInfoApproved((int) request.getRequestObject());
            default :
                return null;
        }
    }

    public synchronized static Object reviewControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                revDAO.insertReview((HashMap<String, Object>) request.getRequestObject());

                return null;
            case 0x02:
                return revDAO.insertReReview((ReviewDTO) request.getRequestObject());
            case 0x03:
                return revDAO.review((int) request.getRequestObject());
            case 0x04:
                return revDAO.reReview((int) request.getRequestObject());
            case 0x05:
                return revDAO.houseReview((int) request.getRequestObject());
            case 0x06:
                return revDAO.writeReviewList((int) request.getRequestObject());
            default:
                return null;
        }
    }

    public synchronized static Object userControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                ArrayList<Object> arr = (ArrayList<Object>) request.getRequestObject();

                return usrDAO.loginType((String) arr.get(0), (String) arr.get(1));
            case 0x02:
                return usrDAO.insertUser((UserDTO) request.getRequestObject());
            case 0x03:
                usrDAO.modifyUser((HashMap<String,Object>) request.getRequestObject());

                return null;
            case 0x04:
                usrDAO.modifyPw((HashMap<String,Object>) request.getRequestObject());

                return null;
            case 0x05:
                return usrDAO.getPw((int) request.getRequestObject());
            case 0x06:
                return usrDAO.getName((int) request.getRequestObject());
            default:
                return null;
        }
    }

    public synchronized static Object totalSalesControl(Request request)
    {
        switch(request.getType().value())
        {
            case 0x01:
                tosDAO.insertTotalAmount((TotalSalesDTO) request.getRequestObject());

                return null;
            case 0x02:
                tosDAO.dropTotalAmount((int) request.getRequestObject());

                return null;
            case 0x03:
                return tosDAO.allTotalSales((int) (long) request.getRequestObject());
            default :
                return null;
        }
    }
}
